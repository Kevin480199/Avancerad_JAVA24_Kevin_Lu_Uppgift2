package org.example;

public class Student {
    private static int id = 1000;
    private int studentId;
    private String name;
    private int grade;
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        studentId = id;
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
