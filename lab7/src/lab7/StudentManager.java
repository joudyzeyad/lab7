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

    private Student s;
    
    public StudentManager(Student s)
    {
        this.s=s;
    
    }

    public ArrayList<Course> availableCourses() throws IOException {
        return JsonDatabaseManager.loadCourses();
    }

    public boolean enroll(int courseID) throws IOException {
        ArrayList<Integer> temp = s.getEnrolledCourses();
        int i;
        for(i=0;i<temp.size();++i)
            if(courseID == temp.get(i))
                return false;
        temp.add(courseID);
        s.setEnrolledCourses(temp);
        this.editStudentList(s);
        this.editCourseList(courseID, s);
        return true;
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

    public ArrayList<Lesson> lessonList(int cID) throws IOException {
        ArrayList<Course> x = viewEnrolled();
        ArrayList<Lesson> l = new ArrayList();
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getCourseID() == cID) {
                l = x.get(i).getLessons();
            }
        }
        return l;
    }

    public void lessonComplete(int lessonId, int courseId) throws IOException {

        ArrayList<CourseProgress> progressList = s.getProgress();
        CourseProgress cp = null;
        for (CourseProgress p : progressList) {
            if (p.getCourseID() == courseId) {
                cp = p;
                break;
            }
        }

        if (cp == null) {
            cp = new CourseProgress(courseId, 0);
            progressList.add(cp);
        }

        int updated = cp.getCompletedLessons() + 1;
        cp.setCompletedLessons(updated);

    }
    public void editStudentList(Student s) throws IOException{
          ArrayList<User> temp = JsonDatabaseManager.loadUsers();
          int i;
          for(i=0;i<temp.size();++i){
              if(temp.get(i).getUserId() == s.getUserId()){
                  temp.add(i, s);
                  break;
              }
          }
          JsonDatabaseManager.saveUser(temp);
    }
    public void editCourseList(int id,Student s) throws IOException{
        ArrayList<Course> temp = JsonDatabaseManager.loadCourses();
        int i;
          for(i=0;i<temp.size();++i){
               if(temp.get(i).getCourseID() == id){
                  temp.get(i).addStudent(s);
               }
            } 
        JsonDatabaseManager.saveCourse(temp);
    }
}
