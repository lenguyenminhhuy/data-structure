package com.finaltest;
import java.sql.Array;
import java.util.*;

public class CourseList {
    int maxSize = 24;
    int currentSize;
    RMITCourse[] listOfCourses = new RMITCourse[maxSize];
    ArrayList<ArrayList<String>> prerequisiteCourses = new ArrayList<>();
    ArrayList<String> prerequisite;
    public CourseList() {
        currentSize = 0;
        for (int i = 0; i<maxSize; i++){
            listOfCourses[i] = null;
        }
    }

    public void addCourse(RMITCourse c){
        for (int i = 0 ; i <= currentSize; i++){
            if (listOfCourses[i] == null){
                listOfCourses[i] = c;
            }
        }
        currentSize++;
    }

    public void addPrerequisite(RMITCourse c, RMITCourse pre){
        prerequisite = new ArrayList<>();
        prerequisite.add(c.code);
        prerequisite.add(pre.code);

        prerequisiteCourses.add(prerequisite);

    }

    public boolean takeFirst(RMITCourse c){
        boolean result = false;

        for (int i = 0; i<prerequisiteCourses.size(); i++){
            if (c.code.equals(prerequisiteCourses.get(i).get(1))) {
                result = true;
            }
        }
        System.out.println(result);
        return result;
    }

    public String coursesTaken(){
        String courseName = null;
        return courseName;
    }

    private void display(){
        for (int i = 0; i<currentSize; i++){
            System.out.println("Course " + (i+1) );
            System.out.println(listOfCourses[i]);
        }
    }

    public static void main(String args[]){
        RMITCourse c1 = new RMITCourse("Programming 1", "C123");
        RMITCourse c2 = new RMITCourse("Web Programming", "C456");
        RMITCourse c3 = new RMITCourse("Data Structures", "C789");
        RMITCourse c4 = new RMITCourse("Database Application", "C000");
        CourseList list = new CourseList();
        list.addCourse(c1);
        list.addCourse(c2);
        list.addCourse(c3);
        list.addCourse(c4);
        list.display();
        list.addPrerequisite(c2, c1);  // make Programming 1 a prerequisite of Web Programming
        list.addPrerequisite(c3, c1);  // make Programming 1 a prerequisite of Data Structures
        list.addPrerequisite(c4, c2);
        list.takeFirst(c1);  // true
        list.takeFirst(c2);  // true
        list.takeFirst(c3);  // false
        list.takeFirst(c4);  // false

    }




}

class RMITCourse {
    String name;
    String code;
    ArrayList<RMITCourse> prerequisite;

    public RMITCourse(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String toString(){
        return "course name: " + name + " code " + code;
    }
}