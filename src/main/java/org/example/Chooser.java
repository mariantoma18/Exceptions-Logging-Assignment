package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Chooser {
  Scanner scanner = new Scanner(System.in);
  StudentManager studentManager = new StudentManager();
  ArrayList<Student> students = studentManager.initializeStudentList();

  public void chooseMainAction() {
    boolean isRunning = true;

    while (isRunning) {
      System.out.print(
          "\nMenu:\n"
              + "(1) Add Student;\n"
              + "(2) Delete Student;\n"
              + "(3) Retrieve students by age;\n"
              + "(4) List students by last name or birth date;\n"
              + "(5) Exit.\n"
              + "Answer: ");
      int mainAnswer = scanner.nextInt();

      switch (mainAnswer) {
        case 1:
          studentManager.addStudent(students);
          break;

        case 2:
          studentManager.deleteStudent(students);
          break;

        case 3:
          studentManager.retrieveAllStudentsByAge(students);
          break;

        case 4:
          chooseSortingCriterion();
          break;

        case 5:
          isRunning = false;
          break;

        default:
          System.out.println("Not a valid option.");
      }
    }
  }

  public void chooseSortingCriterion() {
    System.out.print(
        "\nBy what criteria do you want the list to be sorted?\n"
            + "(1) Sort by last name;\n"
            + "(2) Sort by birth date;\n"
            + "Answer: ");
    int answer = scanner.nextInt();

    switch (answer) {
      case 1:
        studentManager.printStudentsByLastName(students);
        break;

      case 2:
        studentManager.printStudentsByBirthDate(students);
        break;

      default:
        System.out.println("Not a valid option.");
    }
  }
}
