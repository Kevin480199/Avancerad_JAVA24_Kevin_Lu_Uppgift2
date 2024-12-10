package org.example;

public class Student {
    // Static to make sure it belongs to class
    private static int id = 1000;
    private int studentId;
    private String name;
    private int grade;
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        // Give a student id an id
        studentId = id;
        // Raise the id with one
        id++;
    }

    public int getId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
}
