package lab7;


import lab7.Instructor;
import lab7.Course;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joudy
 */
public class JsonDatabaseManager {
    public static ArrayList<Course> loadCourses() throws IOException{
           ArrayList<Course> c = new ArrayList<Course>();
           String lines = new String(Files.readAllBytes(Paths.get("courses.json")));
           JSONArray arr = new JSONArray(lines);
           int i;
           for(i=0;i<arr.length();++i){
           JSONObject obj = arr.getJSONObject(i);
           Course course = jsonToCourse(obj);
           c.add(course);
           }
          return c; 
    } 
    public static ArrayList<User> loadUsers() throws IOException{
          ArrayList<User> u = new ArrayList<User>();
          String lines = new String(Files.readAllBytes(Paths.get("users.json")));
          JSONArray arr = new JSONArray(lines);
          int i;
          for(i=0;i<arr.length();++i){
             JSONObject obj = arr.getJSONObject(i);
             String role = obj.getString("role");
            if(role.equalsIgnoreCase("student")){
                Student s = jsonToStudent(obj);
                u.add(s);}
            else {
                Instructor ins = jsonToInstructor(obj);
                u.add(ins);
            }
          }
          return u;
    }
    public static Course jsonToCourse(JSONObject obj){
        int cID = obj.getInt("courseId");
        int instID = obj.getInt("instructorID");
        String title = obj.getString("title");
        String description = obj.getString("description");
        Course c = new Course(cID,instID,title,description);
        int i;
        if(obj.has("students")){
          JSONArray sArr = obj.getJSONArray("students");
          for(i=0;i<sArr.length();++i){
             c.addStudent((Student) jsonToStudent(sArr.getJSONObject(i)));
           }
        }
        if(obj.has("lessons")){
          JSONArray lArr = obj.getJSONArray("lessons");
          for(i=0;i<lArr.length();++i){
             c.addLesson(jsonToLesson(lArr.getJSONObject(i)));
           }
        }

        return c;
    }
    private static Student jsonToStudent(JSONObject obj) {
        int id = obj.getInt("userId");
        String username = obj.getString("username");
        String email = obj.getString("email");
        String passwordHash = obj.getString("passwordHash");
        int i;
        Student s = new Student(id,username,email,passwordHash);
        if(obj.has("enrolledCourses")){
        JSONArray ec = obj.getJSONArray("enrolledCourses");
        ArrayList<Integer> enrolledCourses = new ArrayList<>();
        for(i=0;i<ec.length();++i)
            enrolledCourses.add(ec.getInt(i));
         s.setEnrolledCourses(enrolledCourses);
        }
        if(obj.has("progress")){
         JSONArray p = obj.getJSONArray("progress");
        ArrayList<CourseProgress> cprogress = new ArrayList<>();
        for(i=0;i<p.length();++i){
            int cid = p.getJSONObject(i).getInt("courseId");
            int progress = p.getJSONObject(i).getInt("progress");
            CourseProgress temp = new CourseProgress(cid,progress);
            cprogress.add(temp);
        }
        s.setProgress(cprogress);
        }
        return s;
}
    private static Instructor jsonToInstructor(JSONObject obj) {
        int id = obj.getInt("userId");
        String username = obj.getString("username");
        String email = obj.getString("email");
        String passwordHash = obj.getString("passwordHash");
        int j;
        Instructor i = new Instructor(id,username,email,passwordHash);
        if(obj.has("createdCourses")){
        JSONArray cc = obj.getJSONArray("createdCourses");
        ArrayList<Integer> createdCourses = new ArrayList<>();
        for(j=0;j<cc.length();++j)
            createdCourses.add(cc.getInt(j));
        i.setCreatedCourses(createdCourses);
        }
        return i;
}
    public static Lesson jsonToLesson(JSONObject obj){
         int id = obj.getInt("lessonId");
         String title = obj.getString("title");
         String content = obj.getString("content");
         Lesson l = new Lesson(id,title,content);
         if(obj.has("resources")){
           JSONArray arr = obj.getJSONArray("resources");
           int i;
           for(i=0;i<arr.length();++i){
              l.addResource(arr.getString(i));
           }
         }
         return l;
    
    }
     private static JSONObject userToJson(User u) {
        JSONObject obj = new JSONObject();
        obj.put("username", u.getUsername());
        obj.put("userId", u.getUserId());
        obj.put("email", u.getEmail());
        obj.put("passwordHash", u.getPasswordHash());
        obj.put("role", u.getRole());
        if(u.getRole().equalsIgnoreCase("student")){
          Student s = (Student) u;
          obj.put("enrolledCourses",new JSONArray(s.getEnrolledCourses()));
          int i;
          ArrayList<CourseProgress> temp = s.getProgress();
          JSONArray temparr = new JSONArray();
          for(i=0;i<temp.size();++i){
             JSONObject prog = new JSONObject();
             prog.put("courseId",temp.get(i).getCourseID());
             prog.put("progress",temp.get(i).getCompletedLessons());
             temparr.put(prog);
          }
          obj.put("progress", temparr);
        }
        else{
            Instructor ins = (Instructor) u;
            obj.put("createdCourses",new JSONArray(ins.getCreatedCourses()));
        }

        return obj;
    }
     public static int generateNewUserId() throws IOException {
         ArrayList<User> users = loadUsers();
         
         int maxId = 0;
         
         for (int i = 0 ; i < users.size() ; i++) {
             if (users.get(i).getUserId() > maxId) {
                 maxId = users.get(i).getUserId();
             }
         }
         return maxId + 1;
    }
     public static void saveUser(ArrayList<User> u) throws IOException{
       JSONArray user = new JSONArray();
       int i;
       for(i=0;i<u.size();++i)
           user.put(userToJson(u.get(i)));
          FileWriter f = new FileWriter("users.json");
         f.write(user.toString(2));
         f.close();
     }
}
