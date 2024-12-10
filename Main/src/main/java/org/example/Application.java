package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Application {
    // Singleton creates new application;
    static Application application = new Application();
    private Scanner scanner;
    private LinkedList<Student> students;
    private Application(){
        // Creates new Linked list for students
        students = new LinkedList<>();
        scanner = new Scanner(System.in);
        // Makes sure options refreshes
        boolean running = true;
        do{
            // Print out options
            System.out.println("Select your option");
            System.out.println("1. Add Student");
            System.out.println("2. Find student");
            System.out.println("3. Show all students");
            System.out.println("4. Save students to file");
            System.out.println("5. Read from file");
            System.out.println("6. Exit");
            // Scan next option
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    // Calls method
                    addStudent();
                    break;
                case 2:
                    // Calls method
                    findStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    readFromFile();
                    break;
                case 6:
                    // Exits the loop
                    running = false;
                    break;
            }
        }while(running);
    }

    private void readFromFile() {
        // File path
        String fileName = "students.csv";
        // Initiates buffered reader and closes it
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            // Reads lines from students.csv as long as there are lines to read
            while((line = reader.readLine()) != null){
                // Creates a String array called data that splits with ","
                String[] data = line.split(",");
                // First string will always contain name of student
                String name = data[0];
                // Second string will always contain grade of student
                int grade = Integer.parseInt(data[1]);
                // Creates a new student and adds it to linkedList
                students.add(new Student(name, grade));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        // File path
        String fileName = "students.csv";
        // Initiates buffered writer and closes it
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            // Loops through linked list with students
            for (Student student : students){
                // Saves each object to a new line
                writer.write(student.getName()+","+student.getGrade());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showAllStudents() {
        // Check it linked list students is empty
        if (students.isEmpty()){
            System.out.println("Please add students first");
        }
        // Loops through linked list students
        for (Student student : students){
            // Prints out student ID, name and grade to console
            System.out.println("Student ID: " + student.getId() + ", Student name: " + student.getName() + ", Student grade: " + student.getGrade());
        }
    }

    private void findStudent() {
        // Prints out text in console
        System.out.println("Enter student ID");
        // Scans next integer
        int id = scanner.nextInt();
        // A boolean if found
        boolean found = false;
        // Loops through linked list students
        for(Student student : students){
            // If input id matches with any of students ID print out student name
            if(student.getId() == id){
                System.out.println(student.getName());
                // Flips boolean to true
                found = true;
            }
        }
        // If it didn't find a student print out text
        if (!found){
            System.out.println("Student not found");
        }
    }

    private void addStudent() {
        // Prints out text
        System.out.println("Enter student name");
        // Scan next line
        scanner.nextLine();
        // Scans and stores next line
        String name = scanner.nextLine();
        // Prints out text
        System.out.println("Enter student grade");
        // Scans next int for grade
        try{
            int grade = scanner.nextInt();
            // Creates a student
            Student student = new Student(name, grade);
            System.out.println(student.getId());
            // Add student to linked list
            students.add(student);
        }catch (InputMismatchException e){
            System.out.println("Enter a grade between 1-5");
            scanner.next();
        }
    }
    // Returns singleton
    public static Application getInstance(){
        return application;
    }
}
