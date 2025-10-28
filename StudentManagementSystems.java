import java.io.*;
import java.util.*;

//  Student class
class Student implements Serializable {
    private String name;
    private String rollNumber;
    private String grade;
    private int age;

    public Student(String name, String rollNumber, String grade, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getGrade() { return grade; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name +
               ", Grade: " + grade + ", Age: " + age;
    }
}

// StudentManagementSystem class
class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }

    // Remove student
    public boolean removeStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                students.remove(s);
                saveStudentsToFile();
                return true;
            }
        }
        return false;
    }

    // Search for student
    public Student searchStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n----- Student List -----");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Save students to file
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load students from file
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}

//  Main class 
public class StudentManagementSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Roll Number: ");
                    String rollNumber = sc.nextLine().trim();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine().trim();
                    System.out.print("Enter Age: ");
                    int age = getValidAge(sc);

                    if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
                        System.out.println("Error: All fields are required!");
                    } else {
                        sms.addStudent(new Student(name, rollNumber, grade, age));
                        System.out.println(" Student added successfully!");
                    }
                }

                case 2 -> {
                    System.out.print("Enter Roll Number to edit: ");
                    String roll = sc.nextLine().trim();
                    Student s = sms.searchStudent(roll);
                    if (s != null) {
                        System.out.print("Enter new name (" + s.getName() + "): ");
                        String newName = sc.nextLine().trim();
                        System.out.print("Enter new grade (" + s.getGrade() + "): ");
                        String newGrade = sc.nextLine().trim();
                        System.out.print("Enter new age (" + s.getAge() + "): ");
                        int newAge = getValidAge(sc);

                        if (!newName.isEmpty()) s.setName(newName);
                        if (!newGrade.isEmpty()) s.setGrade(newGrade);
                        s.setAge(newAge);
                        System.out.println(" Student updated successfully!");
                    } else {
                        System.out.println(" Student not found!");
                    }
                }

                case 3 -> {
                    System.out.print("Enter Roll Number to remove: ");
                    String roll = sc.nextLine().trim();
                    boolean removed = sms.removeStudent(roll);
                    if (removed) System.out.println(" Student removed!");
                    else System.out.println(" Student not found!");
                }

                case 4 -> {
                    System.out.print("Enter Roll Number to search: ");
                    String roll = sc.nextLine().trim();
                    Student found = sms.searchStudent(roll);
                    if (found != null) System.out.println(" Found: " + found);
                    else System.out.println(" Student not found!");
                }

                case 5 -> sms.displayAllStudents();
                case 6 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 6);

        sc.close();
    }

    // Helper: Validates integer age input
    private static int getValidAge(Scanner sc) {
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine().trim());
                if (age > 0 && age < 120) break;
                else System.out.print("Enter a valid age (1-120): ");
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number for age: ");
            }
        }
        return age;
    }
}
