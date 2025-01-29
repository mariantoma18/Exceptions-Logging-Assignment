package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestStudentManager {

  @Mock Scanner mockScanner;

  @InjectMocks StudentManager manager;

  @Mock StudentManager mockManager;

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
  void buildStudent() {

    when(mockManager.buildStudent()).thenReturn(new Student("Test", "Test", 1956, "M", "1111"));

    Student testStudent = mockManager.buildStudent();

    assertEquals("Test", testStudent.getFirstName());
  }

  @Test
  void getFirstNameFromUser() {

    //    when(mockScanner.next()).thenReturn("Test");
    //
    //    StudentManager manager = new StudentManager(mockScanner);
    //
    //    String firstNameTest = manager.getFirstNameFromUser();
    //
    //    assertEquals("Test", firstNameTest);
  }

  @Test
  void deleteStudent() {
    when(mockScanner.next()).thenReturn("1111");

    ArrayList<Student> studentsTest =
        new ArrayList<Student>(
            Arrays.asList(
                new Student("Test1", "Test2", 2000, "F", "1111"),
                new Student("Test2", "Test2", 1999, "M", "2222")));

    manager.deleteStudent(studentsTest);

    assertEquals(1, studentsTest.size());
  }

  @Test
  void retrieveAllStudentsByAge() {
    when(mockScanner.nextInt()).thenReturn(25);

    ArrayList<Student> studentsTest =
        new ArrayList<Student>(
            Arrays.asList(
                new Student("Test1", "Test2", 2000, "F", "1111"),
                new Student("Test2", "Test2", 1999, "M", "2222")));

    ArrayList<Student> studentsWithTheSameAgeTest = manager.retrieveAllStudentsByAge(studentsTest);

    assertEquals(1, studentsWithTheSameAgeTest.size());
  }

  @Test
  void calculateAge() {
      int result = manager.calculateAge(2025,2000);

      assertEquals(25,result);
  }
}
