package lab7;


import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Joudy
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Course> a = JsonDatabaseManager.loadCourses();
        int i;
        for(i=0;i< a.size();++i){
            printc(a.get(i));
        }
        ArrayList<User> u = JsonDatabaseManager.loadUsers();
        for(i=0;i< u.size();++i){
            prints(u.get(i));
        }
        Student s = new Student(9443,"Joudy","jzeyadelsherbiny@gmail.com","962005J");
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(3);
        ArrayList<CourseProgress> c = new ArrayList<>();
        c.add(new CourseProgress(1,2));
        c.add(new CourseProgress(3,0));
        s.setEnrolledCourses(aa);
        s.setProgress(c);
        u.add(s);
        JsonDatabaseManager.saveUser(u);
    }
    public static void printc(Course c){
          System.out.println(c.getCourseID());
          System.out.println(c.getInstructorID());
          System.out.println(c.getDescription());
          System.out.println(c.getTitle());
          ArrayList<Lesson> l = c.getLessons();
          ArrayList<Student> s = c.getStudents();
          int i;
        for(i=0;i< l.size();++i){
            printl(l.get(i));
        }
         for(i=0;i< s.size();++i){
            prints(s.get(i));
        }
        
    }
    public static void printl(Lesson l){
         System.out.println(l.getLessonId());
         System.out.println(l.getTitle());
         System.out.println(l.getContent());
    }
    public static void prints(User s){
    
        System.out.println(s.getUsername());
        System.out.println(s.getUserId());
        System.out.println(s.getEmail());
        System.out.println(s.getPasswordHash());
    
    }
    
}
