package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
  Scanner scanner;

  public StudentManager() {
    this.scanner = new Scanner(System.in);
  }

  public StudentManager(Scanner scanner) {
    this.scanner = scanner;
  }

  /*
  Initialize the list of students
   */
  public ArrayList<Student> initializeStudentList() {
    ArrayList<Student> students = new ArrayList<>();

    students.add(new Student("Maria", "Johnson", 2001, "F", "1001"));
    students.add(new Student("Andrew", "Smith", 1999, "M", "1002"));
    students.add(new Student("Hannah", "Williams", 2000, "F", "1003"));
    students.add(new Student("Michael", "Brown", 2002, "M", "1004"));
    students.add(new Student("Emma", "Taylor", 1998, "F", "1005"));

    return students;
  }

  /*
  Add a student to the student list, using the buildStudent method
   */
  public void addStudent(ArrayList<Student> students, Student builtStudent) {

    students.add(builtStudent);
  }

  /*
  A method that builds student based on the inputs
   */
  public Student buildStudent() {
    String firstName = null;
    String lastName = null;
    int dateOfBirth = 0;
    String gender = null;

    while (firstName == null) {
      try {
        firstName = getFirstNameFromUser();
      } catch (NullPointerException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    while (lastName == null) {
      try {
        lastName = getLastNameFromUser();
      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    while (dateOfBirth == 0) {
      try {
        dateOfBirth = getDateOfBirthFromUser();
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid date of birth: " + e.getMessage());
      } catch (InputMismatchException v) {
        System.out.println("The input must be a number!");
        scanner.nextLine();
      }
    }

    while (gender == null) {
      try {
        gender = getGenderFromUser();
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid gender: " + e.getMessage());
      }
    }

    String ID = getIdFromUser();

    Student student = new Student(firstName, lastName, dateOfBirth, gender, ID);
    return student;
  }

  /*
  Based on the user's input, return the gender
   */
  public String getGenderFromUser() {
    System.out.print("Enter the student gender: ");
    String gender = scanner.next();

    if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
      throw new IllegalArgumentException("The gender must be M/F");
    }

    return gender.toUpperCase();
  }

  /*
  Based on the user's input, return the date of birth
   */
  public int getDateOfBirthFromUser() {
    System.out.print("Enter the student date of birth: ");
    int dateOfBirth = scanner.nextInt();
    scanner.nextLine();

    if (dateOfBirth < 1900 | dateOfBirth > 2025) {
      throw new IllegalArgumentException("The date of birth must be between 1900 and current year");
    }

    return dateOfBirth;
  }

  /*
  Based on the user's input, return the first name
   */
  public String getFirstNameFromUser() {
    System.out.print("Enter the student first name: ");
    String firstName = scanner.next();

    if (firstName == null) {
      throw new NullPointerException("The field can't be empty.");
    }

    return firstName;
  }

  /*
  Based on the user's input, return the last name
   */
  public String getLastNameFromUser() {
    System.out.print("Enter the student last name: ");
    String lastName = scanner.next();

    if (lastName == null) {
      throw new NullPointerException("The field can't be empty.");
    }

    return lastName;
  }

  /*
  Based on the user's input, return the ID
   */
  public String getIdFromUser() {
    System.out.print("Enter the student id: ");
    String id = scanner.next();

    return id;
  }

  /*
  Method used to delete a student by ID
   */
  public void deleteStudent(ArrayList<Student> students) {
    System.out.print("Enter the student ID to delete: ");
    String idToDeletedToDelete = scanner.next();

    if (students == null) {
      throw new NullPointerException("The list is null");
    } else {

        if (!students.removeIf(student -> student.getID().equals(idToDeletedToDelete))) {
        throw new StudentNotFoundException(
            "Student with ID: " + idToDeletedToDelete + " not found.");
      }
    }
    System.out.println("\nThe student has been deleted.");
  }

  /*
  Based on the input, the method return an ArrayList of students with the same age
   */
  public ArrayList<Student> retrieveAllStudentsByAge(ArrayList<Student> students) {
    ArrayList<Student> studentsWithTheSameAge = new ArrayList<>();

    System.out.print("Enter age to search: ");
    int ageToSearch = scanner.nextInt();
    for (Student student : students) {
      if (calculateAge(2025, student.getDateOfBirth()) == ageToSearch) {
        studentsWithTheSameAge.add(student);
      }
    }
    return studentsWithTheSameAge;
  }

  /*
  Method that calculate the age of a student
   */
  public int calculateAge(int currentYear, int dateOfBirth) {
    return currentYear - dateOfBirth;
  }

  /*
  Method that print the student list sorted by the last name
   */
  public void printStudentsByLastName(ArrayList<Student> studentsList) {
    studentsList.sort(Comparator.comparing(Student::getLastName));

    System.out.println("\nStudents ordered by last name:");
    for (Student student : studentsList) {
      System.out.println(student);
    }
  }

  /*
  Method that print the student list sorted by the date of birth
   */
  public void printStudentsByBirthDate(ArrayList<Student> studentsList) {
    studentsList.sort(Comparator.comparing(Student::getDateOfBirth));

    System.out.println("\nStudents ordered by date of birth:");
    for (Student student : studentsList) {
      System.out.println(student);
    }
  }
}
