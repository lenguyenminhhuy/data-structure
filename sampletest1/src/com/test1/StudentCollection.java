package com.test1;

public class StudentCollection {
    int currentSize;
    int maxSize = 100;
    Student[] students;

    public StudentCollection(){
        currentSize = 0;
        students = new Student[maxSize];
    }

    // add student
    private void addStudent(Student std){
        for (int i = 0; i < currentSize; i++){
            if (students[i].ID.equals(std.ID)){
                return; // do nothing
            }
        }
        students[currentSize] = std;
        currentSize++;
        System.out.println("Add student successfully");
    }

    // search by name
    private Student searchByName(String name){
        for (int i=0; i< currentSize; i++){
            if (students[i].name.contains(name)){
                return students[i];
            }
        }
        return null;
    }

    // rank students by GPA
    private int rankStudent(String ID){
        Student currStudent = null;
        for (int i = 0; i < currentSize; i++){
            if (students[i].ID.equals(ID)){
                currStudent = students[i];
            }
        }
        int rank = 0;
        double currGPA = currStudent.GPA;
        for (int i=0; i<currentSize;i++){
            if(students[i].GPA - currGPA > 0){
                rank ++;
            }
        }
        return rank+1;
    }

    private void printCollection(){
        for (int i = 0; i < currentSize; i++){
            System.out.printf("Student %d%n", i+1);
            System.out.println(students[i].ID);
            System.out.println(students[i].name);
            System.out.println(students[i].GPA);
        }
    }

    public static void main(String[] args){
        StudentCollection stdCollection = new StudentCollection();
        Student std1 = new Student("s377281", "Le Nguyen Minh Huy", 3.6);
        Student std2 = new Student("s377280", "Le Nguyen Minh Huy", 3.7);
        Student std = new Student("s377282", "Le Mi", 3.5);
        stdCollection.addStudent(std);
        stdCollection.addStudent(std1);
        stdCollection.addStudent(std2);
        stdCollection.printCollection();

        // test searchByName function
        Student std3 = stdCollection.searchByName("Le Nguyen");
        System.out.printf("Found result: %s %s %.2f\n", std.ID, std3.name, std.GPA);


        // test rankStudent function
        System.out.printf("Rank of student %s is %d\n", std.ID, stdCollection.rankStudent(std.ID));
    }

}

class Student{
    String ID;
    String name;
    double GPA;

    public Student(String ID, String name, double GPA){
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

    public String toString() {
        return "Student " + name + " (" + ID + ") has GPA: " + GPA;
    }
}