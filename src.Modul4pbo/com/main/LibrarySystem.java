package com.main;

import books.Book;
import books.StoryBook;
import books.HistoryBook;
import books.TextBook;
import data.Admin;
import data.Student;
import data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    public static Book[] daftarBuku = new Book[100];
    public static ArrayList<Student> studentList = new ArrayList<>(100);
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku[i++] = new StoryBook("SB32F", "Semangat Merdeka", 17, "Story", "kikiy");
        daftarBuku[i++] = new HistoryBook("HB324", "Kartini", 2, "History", "mikkiy");
        daftarBuku[i++] = new TextBook("TB323", "Sejarah", 4, "Text", "Cici Paramida");

        // Add students to the ArrayList
        studentList.add(new Student("202310370311248", "Tasyah Aulia Rahma", "Teknik", "Mesin"));
        studentList.add(new Student("202310370311233", "Mini", "Teknik", "Informatika"));
        studentList.add(new Student("202310370311100", "Fia", "Teknik", "Elektro"));

        boolean isRunning = true;
        while (isRunning) {
            // Display menu
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose (1-3): ");
            int choice = scanner.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    loginStudent();
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 3:
                    System.out.println("Thank you for using our service. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Method to handle student login
    public static void loginStudent() {
        System.out.print("Enter NIM: ");
        String nimStudent = scanner.next();
        scanner.nextLine(); // Consume newline character

        // Check if NIM exists and login
        if (nimStudent.length() == 15 && checkNim(nimStudent)) {
            Student student = new Student(nimStudent);
            student.login();
        } else {
            System.out.println("NIM not found or invalid format!");
        }
    }

    // Method to check if NIM exists in the studentList
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}