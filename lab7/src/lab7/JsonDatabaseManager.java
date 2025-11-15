package lab7;


import lab7.Instructor;
import lab7.Course;
import java.io.File;
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
             c.addStudent(jsonToStudent(sArr.getJSONObject(i)));
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
    public static Student jsonToStudent(JSONObject obj){
          String name = obj.getString("username");
          int id = obj.getInt("userid");
          String email = obj.getString("email");
          String password = obj.getString("password");
          return new Student(name,id,email,password);
    }
    public static Instructor jsonToInstructor(JSONObject obj){
          String name = obj.getString("username");
          int id = obj.getInt("userid");
          String email = obj.getString("email");
          String password = obj.getString("password");
          return new Instructor(name,id,email,password);
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
}
