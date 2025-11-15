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

    public ArrayList<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<CourseProgress> getProgress() {
        return progress;
    }
}
