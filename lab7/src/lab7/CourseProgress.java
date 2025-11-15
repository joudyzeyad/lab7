/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author NEXT STORE
 */
public class CourseProgress {
    private int courseID;
    private int completedLessons;
    
    public CourseProgress(int courseID, int completedLessons) {
        this.courseID = courseID;
        this.completedLessons = completedLessons;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }
}
