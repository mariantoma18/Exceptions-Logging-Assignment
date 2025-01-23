package org.example;

public class Student {

  private String firstName;
  private String lastName;
  private int dateOfBirth;
  private String gender;
  private String ID;

  public Student(String firstName, String lastName, int dateOfBirth, String gender, String ID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.ID = ID;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(int dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  @Override
  public String toString() {
    return "Student{"
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", dateOfBirth='"
        + dateOfBirth
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", ID='"
        + ID
        + '\''
        + '}';
  }
}
