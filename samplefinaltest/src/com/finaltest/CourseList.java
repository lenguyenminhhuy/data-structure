package com.finaltest;
import java.sql.Array;
import java.util.*;

public class CourseList {
    int currentSize;
    ArrayList<RMITCourse> listOfCourses;

    public CourseList() {
        listOfCourses = new ArrayList<RMITCourse>();
    }

    public void addCourse(RMITCourse c){
        listOfCourses.add(c);
    }

    public void addPrerequisite(RMITCourse c, RMITCourse pre){
        c.addPrerequisite(pre);
    }

    public boolean takeFirst(RMITCourse c){
        return (c.prerequisite.size() == 0);
    }

    // topological sort
    public String coursesTaken(){
        int size = listOfCourses.size();
        ArrayList<RMITCourse> res = new ArrayList<>();
        boolean[] added = new boolean[size];

        for (int i = 0; i<size; i++){
            // make sure the course has not been added
            if (added[i]) {
                continue;
            }
            RMITCourse c = listOfCourses.get(i);
            boolean foundPre = false;
            for (int j = 0; j< size; j++){
                // make sure the course has not been added
                if (added[j]) {
                    continue;
                }
                // avoid checking the same course
                if (i==j){
                    continue;
                }
                RMITCourse c2 = listOfCourses.get(j);
                // check whether c2 is prerequisite of c
                if (c.prerequisite.contains(c2)){
                    foundPre = true;
                    break;
                }
            }
            if (foundPre){
                continue;
            }
            // if not found prerequisite, add the course to result list and mark as added
            res.add(c);
            added[i] = true;
            // remove course if that course is a prerequisite of another course
            for (int j = 0; j<size; j++){
                RMITCourse c3 = listOfCourses.get(j);
                if (c3.prerequisite.contains(c)){
                    c3.prerequisite.remove(c);
                }
            }
        }
        String courseSuggestion = "";
        for (int i = 0; i< size; i++){
            courseSuggestion += ", " + res.get(i).name;
        }
        return courseSuggestion.substring(2);
    }

    private void display(){
        for (int i = 0; i< listOfCourses.size(); i++){
            System.out.println("Course " + (i+1) );
            System.out.println(listOfCourses.get(i));
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
        list.addPrerequisite(c4, c2);  // make Web Programming a prerequisite of Database Application
        System.out.println(list.takeFirst(c1));  // true
        System.out.println(list.takeFirst(c2));  // false
        System.out.println(list.takeFirst(c3));  // false
        System.out.println(list.takeFirst(c4));  // false
        System.out.println(list.coursesTaken()); // return "Programming 1, Web Programming, Data Structures, Database Application"


    }
}

class RMITCourse {
    String name;
    String code;
    ArrayList<RMITCourse> prerequisite;

    public RMITCourse(String name, String code){
        this.name = name;
        this.code = code;
        prerequisite = new ArrayList<RMITCourse>();
    }

    public void addPrerequisite(RMITCourse pre){
        prerequisite.add(pre);
    }

    public String toString(){
        return "course name: " + name + " code " + code;
    }
}