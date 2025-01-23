package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
  Scanner scanner = new Scanner(System.in);

  public ArrayList<Student> initializeStudentList() {
    ArrayList<Student> students = new ArrayList<>();

    students.add(new Student("Maria", "Johnson", 2001, "F", "1001"));
    students.add(new Student("Andrew", "Smith", 1999, "M", "1002"));
    students.add(new Student("Hannah", "Williams", 2000, "F", "1003"));
    students.add(new Student("Michael", "Brown", 2002, "M", "1004"));
    students.add(new Student("Emma", "Taylor", 1998, "F", "1005"));

    return students;
  }

  public void addStudent(ArrayList<Student> students) {
    Student builtStudent = buildStudent();

    students.add(builtStudent);
  }

  public Student buildStudent() {
    String firstName = getFirstNameFromUser();
    String lastName = getLastNameFromUser();
    int dateOfBirth = getDateOfBirthFromUser();
    String gender = getGenderFromUser();
    String ID = getIdFromUser();

    Student student = new Student(firstName, lastName, dateOfBirth, gender, ID);
    return student;
  }

  private String getGenderFromUser() {
    String gender;

    try {
      System.out.print("Enter the student gender: ");
      gender = scanner.next();

      if (!gender.equalsIgnoreCase("M") & !gender.equalsIgnoreCase("F")) {
        throw new IllegalArgumentException("The gender must be M/F");
      }

      return gender;
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

    return getGenderFromUser();
  }

  private int getDateOfBirthFromUser() {
    int dateOfBirth;

    try {
      System.out.print("Enter the student date of birth: ");
      dateOfBirth = scanner.nextInt();
      scanner.nextLine();

      if (dateOfBirth < 1900 | dateOfBirth > 2025) {
        throw new IllegalArgumentException(
            "The date of birth must be between 1900 and current year");
      }

      return dateOfBirth;

    } catch (IllegalArgumentException v) {
      System.out.println("Error: " + v.getMessage());
    } catch (Exception e) {
      System.out.println("Please enter a valid number");
      scanner.nextLine();
    }

    return getDateOfBirthFromUser();
  }

  public String getFirstNameFromUser() {
    String firstName;

    try {
      System.out.print("Enter the student first name: ");
      firstName = scanner.next();

      if (firstName == null) {
        throw new NullPointerException("Fields empty.");
      }

      return firstName;

    } catch (NullPointerException e) {
      System.out.println("Error: " + e.getMessage());
    }

    return getFirstNameFromUser();
  }

  public String getLastNameFromUser() {
    String lastName;

    try {
      System.out.print("Enter the student last name: ");
      lastName = scanner.next();

      if (lastName == null) {
        throw new NullPointerException("Fields empty.");
      }

      return lastName;

    } catch (NullPointerException e) {
      System.out.println("Error: " + e.getMessage());
    }

    return getLastNameFromUser();
  }

  public String getIdFromUser() {
    String ID;

    try {
      System.out.print("Enter the student ID: ");
      ID = scanner.next();

      return ID;
    } catch (Exception e) {
      System.out.println("Error :" + e.getMessage());
    }

    return getIdFromUser();
  }

  public void deleteStudent(ArrayList<Student> students) {
    String IdToDelete = getStudentIdToDelete(scanner);

    try {
      for (Student student : students) {
        if (student.getID().equals(IdToDelete)) {
          students.remove(student);
          return;
        } else {
          System.out.println("The student doesn't exist!");
        }
      }
    } catch (Exception e) {
      throw new RuntimeException("The student doesn't exist!");
    }
  }

  public String getStudentIdToDelete(Scanner scanner) {
    scanner = new Scanner(System.in);

    System.out.print("Enter the student ID to delete: ");
    String IdToDelete = scanner.next();

    return IdToDelete;
  }

  public ArrayList<Student> retrieveAllStudentsByAge(ArrayList<Student> students) {
    ArrayList<Student> studentsWithTheSameAge = new ArrayList<>();

    int ageToSearch = getStudentAge(scanner);
    for (Student student : students) {
      if (calculateAge(2025, student.getDateOfBirth()) == ageToSearch) {
        studentsWithTheSameAge.add(student);
      }
    }
    return studentsWithTheSameAge;
  }

  public int getStudentAge(Scanner scanner) {
    scanner = new Scanner(System.in);

    System.out.print("Enter age to search: ");
    int ageToSearch = scanner.nextInt();

    return ageToSearch;
  }

  public int calculateAge(int currentYear, int dateOfBirth) {
    return currentYear - dateOfBirth;
  }

  public void printStudentsByLastName(ArrayList<Student> studentsList) {
    studentsList.sort(Comparator.comparing(Student::getLastName));

    System.out.println("\nStudents ordered by last name:");
    for (Student student : studentsList) {
      System.out.println(student);
    }
  }

  public void printStudentsByBirthDate(ArrayList<Student> studentsList) {
    studentsList.sort(Comparator.comparing(Student::getDateOfBirth));

    System.out.println("\nStudents ordered by date of birth:");
    for (Student student : studentsList) {
      System.out.println(student);
    }
  }
}
