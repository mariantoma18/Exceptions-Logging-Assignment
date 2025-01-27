package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

  @Test
  void initializeStudentList() {
    StudentManager manager = new StudentManager();
    ArrayList<Student> students = manager.initializeStudentList();

    assertEquals(5, students.size());
  }

  @Test
  void addStudent() {
    StudentManager manager = new StudentManager();
    ArrayList<Student> students = manager.initializeStudentList();

    Student student2 = new Student("Test2", "Test2", 1999, "M", "10011");

    manager.addStudent(students, student2);

    assertEquals(6, students.size());
  }

  @Test
  void buildStudent() {}

  @Test
  void getFirstNameFromUserWithValidInput() {}

  @Test
  void getLastNameFromUser() {}

  @Test
  void getIdFromUser() {}

  @Test
  void deleteStudent() {}

  @Test
  void getStudentIdToDelete() {}

  @Test
  void retrieveAllStudentsByAge() {}

  @Test
  void getStudentAge() {}

  @Test
  void calculateAge() {}
}
