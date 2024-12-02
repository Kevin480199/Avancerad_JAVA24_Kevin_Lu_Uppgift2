package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Application {
    private Scanner scanner;
    private LinkedList<Student> students;
    Application(){
        students = new LinkedList<>();
        scanner = new Scanner(System.in);
        boolean running = true;
        do{
            System.out.println("Select your option");
            System.out.println("1. Add Student");
            System.out.println("2. Find student");
            System.out.println("3. Show all students");
            System.out.println("4. Save students to file");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    addStudent();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    saveToFile();
            }
        }while(running);
    }

    private void saveToFile() {
        String fileName = "students.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Student student : students){
                writer.write(student.getName()+","+student.getGrade());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showAllStudents() {
        for (Student student : students){
            System.out.println("Stundent ID: " + student.getId() + ", Student name: " + student.getName() + ", Student grade: " + student.getGrade());
        }
    }

    private void findStudent() {
        System.out.println("Enter student ID");
        int id = scanner.nextInt();
        boolean found = false;
        for(Student student : students){
            if(student.getId() == id){
                System.out.println(student.getName());
                found = true;
            }
        }
        if (!found){
            System.out.println("Student not found");
        }
    }

    private void addStudent() {
        System.out.println("Enter student name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter student grade");
        try{
            int grade = scanner.nextInt();
            Student student = new Student(name, grade);
            System.out.println(student.getId());
            students.add(student);
        }catch (InputMismatchException e){
            System.out.println("Enter a grade between 1-5");
            scanner.next();
        }
    }
}
