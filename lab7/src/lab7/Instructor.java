package lab7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joudy
 */
public class Instructor extends User{

    public Instructor(String username, int userid, String email, String password) {
        super(username, userid, email, password);
        super.setRole("Instructor");
    }
    
    
}
