/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author farida helal
 */
public class StudentManager {
    Student s;
    
     public ArrayList<Course> availableCourses() throws IOException {
        return JsonDatabaseManager.loadCourses();
    }

    public void enroll(int courseID) {
        s.getEnrolledCourses().add(courseID);   
    }

    public ArrayList<Course> viewEnrolled() throws IOException {
        ArrayList<Course> x = new ArrayList();
        ArrayList<Course> c = new ArrayList();
        c = JsonDatabaseManager.loadCourses();
        for (int i = 0; i < s.getEnrolledCourses().size(); i++) {
            for (int j = 0; j < c.size(); j++) {
                if (s.getEnrolledCourses().get(i).equals(c.get(j).getCourseID())) {
                    x.add(c.get(j));
                    break;
                }
            }

        }
        return x;
    }

    
}
