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
    
}
