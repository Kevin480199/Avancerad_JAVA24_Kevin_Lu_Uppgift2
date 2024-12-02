package org.example;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    addStudent();
                    break;
                case 2:
                    
                    break;
            }
        }while(running);
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
