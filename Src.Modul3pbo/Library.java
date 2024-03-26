import java.util.Scanner;
import java.util.*;

public class Library {
    private static Map<String, Integer> bookStock = new HashMap<>();
    private static Map<String, List<String>> borrowedBooks = new HashMap<>();
    private static Map<String, Student> registeredStudents = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String currentUserID = null;

    static {
        bookStock.put("388c-e681-9152", 4);
        bookStock.put("ed90-be30-5cdb", 0);
        bookStock.put("d95e-0c4a-9523", 2);
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. keluar");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    loginAsStudent();
                    break;
                case 2:
                    loginAsAdmin();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    public static void loginAsStudent() {
        System.out.print("Enter your NIM (input 99 to go back): ");
        String nim = scanner.nextLine();

        if (nim.equals("99")) {
            return;
        }

        currentUserID = nim;

        while (true) {
            System.out.println("==== Student Menu ====");
            System.out.println("1. Display Borrowed Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Logout");
            System.out.print("Choose option (1-4): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    displayBorrowedBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    currentUserID = null;
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void borrowBook() {
        System.out.println("==== Borrow a Book ====");
        displayAvailableBooks();

        System.out.println("Input the ID of the book you want to borrow (input 99 to go back):");
        System.out.print("Input: ");
        String bookId = scanner.nextLine();
        if (bookId.equals("99")) {
            System.out.println("Returning to the main menu...");
            return;
        }

        if (bookStock.containsKey(bookId)) {
            int stock = bookStock.get(bookId);
            if (stock > 0) {
                bookStock.put(bookId, stock - 1);

                System.out.println("How many days will you borrow the book? (maximum 14 days)");
                System.out.print("Input duration (days): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                borrowedBooks.computeIfAbsent(currentUserID, k -> new ArrayList<>()).add(bookId);

                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book stock is empty! Please choose another book.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void returnBook() {
        System.out.println("==== Return a Book ====");
        displayBorrowedBooks();

        System.out.println("Input the ID of the book you want to return (input 99 to go back):");
        System.out.print("Input: ");
        String bookId = scanner.nextLine();
        if (bookId.equals("99")) {
            System.out.println("Returning to the main menu...");
            return;
        }

        if (borrowedBooks.containsKey(currentUserID)) {
            List<String> userBooks = borrowedBooks.get(currentUserID);
            if (userBooks.contains(bookId)) {
                userBooks.remove(bookId);
                int stock = bookStock.getOrDefault(bookId, 0);
                bookStock.put(bookId, stock + 1);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book is not borrowed by this user.");
            }
        } else {
            System.out.println("No books borrowed by this user.");
        }
    }

    public static void displayAvailableBooks() {
        System.out.println("==== Available Books ====");
        System.out.println("=======================================================================");
        System.out.println("|| No. || Book ID || Title || Author || Category || Stock ||");
        System.out.println("=======================================================================");
        int count = 1;
        for (Map.Entry<String, Integer> entry : bookStock.entrySet()) {
            String bookId = entry.getKey();
            int stock = entry.getValue();
            System.out.println("|| " + count + " || " + bookId + " || Title || Author || Category || " + stock + " ||");
            count++;
        }
        System.out.println("=======================================================================");
    }

    public static void displayBorrowedBooks() {
        System.out.println("==== Borrowed Books ====");
        System.out.println("=======================================================================");
        System.out.println("|| No. || Book ID || Title || Author || Category || Duration (days) ||");
        System.out.println("=======================================================================");
        List<String> userBooks = borrowedBooks.getOrDefault(currentUserID, new ArrayList<>());
        if (userBooks.isEmpty()) {
            System.out.println("No books borrowed by this user.");
        } else {
            int count = 1;
            for (String bookId : userBooks) {
                System.out.println("|| " + count + " || " + bookId + " || Title || Author || Category || Duration ||");
                count++;
            }
        }
        System.out.println("=======================================================================");
    }

    public static void loginAsAdmin() {
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Display Available Books");
            System.out.println("5. Logout");
            System.out.print("Choose option (1-5): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    break;
                case 3:
                    displayRegisteredStudents();
                    break;
                case 4:
                    displayAvailableBooks();
                    break;
                case 5:
                    System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void addStudent() {
        System.out.println("==== Add Student ====");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();

        Student student = new Student(name, faculty, nim, program);
        registeredStudents.put(nim, student);

        System.out.println("Student added successfully.");
    }

    public static void displayRegisteredStudents() {
        System.out.println("===== Registered Students =====");
        if (registeredStudents.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : registeredStudents.values()) {
                System.out.println("Name: " + student.getName());
                System.out.println("Faculty: " + student.getFaculty());
                System.out.println("NIM: " + student.getNim());
                System.out.println("Program: " + student.getProgram());
                System.out.println();
            }
        }
    }

    private static class Student {
        private String name;
        private String faculty;
        private String nim;
        private String program;

        public Student(String name, String faculty, String nim, String program) {
            this.name = name;
            this.faculty = faculty;
            this.nim = nim;
            this.program = program;
        }

        public String getName() {
            return name;
        }

        public String getFaculty() {
            return faculty;
        }

        public String getNim() {
            return nim;
        }

        public String getProgram() {
            return program;
        }
    }
}

