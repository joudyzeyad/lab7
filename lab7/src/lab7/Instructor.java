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

    public ArrayList<Integer> getCreatedCourses() {
        return createdCourses;
    }
}
