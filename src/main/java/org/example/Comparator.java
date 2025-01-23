package org.example;

public class Comparator {

    public int compareStudentsByLastName(Student student1, Student student2){
        return student1.getLastName().compareTo(student2.getLastName());
    }

    public int compareStudentsByDateOfBirth(Student student1 , Student student2){
        return student1.getDateOfBirth() - student2.getDateOfBirth();
    }
}
