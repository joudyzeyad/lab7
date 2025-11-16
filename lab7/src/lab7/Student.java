/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.util.ArrayList;

/**
 *
 * @author NEXT STORE
 */
public class Student extends User{
    private ArrayList<Integer> enrolledCourses;
    private ArrayList<CourseProgress> progress;

    public Student(int userId, String username, String email, String password) {
        super(userId, username, email, password, "student");
        enrolledCourses = new ArrayList<>();
        progress = new ArrayList<>();
    }
    
    public Student(int userId, String username, String email, String passwordHash, boolean alreadyHashed) {
        super(userId, username, email, passwordHash, "student", alreadyHashed);
    }

    public ArrayList<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<CourseProgress> getProgress() {
        return progress;
    }

    public void setEnrolledCourses(ArrayList<Integer> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setProgress(ArrayList<CourseProgress> progress) {
        this.progress = progress;
    }
    
}
