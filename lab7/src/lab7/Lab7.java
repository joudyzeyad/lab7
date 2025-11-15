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
    public static void prints(Student s){
    
        System.out.println(s.getUsername());
        System.out.println(s.getUserid());
        System.out.println(s.getEmail());
        System.out.println(s.getPassword());
    
    }
    
}
