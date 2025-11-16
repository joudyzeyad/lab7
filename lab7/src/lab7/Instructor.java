/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author NEXT STORE
 */
public class Instructor extends User{
    private ArrayList<Integer> createdCourses;
    
    public Instructor(int userId, String username, String email, String password) {
        super(userId, username, email, password, "instructor");
        createdCourses = new ArrayList<>();
    }
    
    public Instructor(int userId, String username, String email, String passwordHash, boolean alreadyHashed) {
       super(userId, username, email, passwordHash, "instructor", alreadyHashed);
    }

    public ArrayList<Integer> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(ArrayList<Integer> createdCourses) {
        this.createdCourses = createdCourses;
    }
    
    public static ArrayList<Student> viewEnrolledStudents()
    {
       ArrayList<User> users =new ArrayList<>();
       ArrayList<Student>s=new ArrayList<>();
        try {
            users=JsonDatabaseManager.loadUsers();
        } catch (IOException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
       for(int i=0;i<users.size();i++)
       {
           if(users.get(i).getRole().equalsIgnoreCase("student"))
               s.add((Student) users.get(i));
               
       }
       return s;
        
    }
    public void courseCreation(Course c) throws IOException
    {
        ArrayList<Course>courses=JsonDatabaseManager.loadCourses();
        courses.add(c);
        JsonDatabaseManager.saveCourse(courses);
        
    }
    public void deleteCourse(Course c) throws IOException
    {
        ArrayList<Course> courses=JsonDatabaseManager.loadCourses();
        courses.remove(c);
         JsonDatabaseManager.saveCourse(courses);

        
    }
    public void addLesson(Course c,Lesson l) throws IOException
    {
       ArrayList<Lesson> lessons=c.getLessons();
       ArrayList<Course> course=new ArrayList<>();
       lessons.add(l);
       c.setLessons(lessons);
       course.add(c);
       JsonDatabaseManager.saveCourse(course);
    }
    


public void deleteLesson(Course c,Lesson l) throws IOException
{
  ArrayList<Lesson>lessons = c.getLessons();
   ArrayList<Course> course=new ArrayList<>();
  lessons.remove(l);
   c.setLessons(lessons);
      course.add(c);
       JsonDatabaseManager.saveCourse(course);
}
}
