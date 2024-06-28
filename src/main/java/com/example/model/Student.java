// Path: /src/main/java/com/example/model/Student.java
package com.example.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, String id) {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidStudentException("First name cannot be empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidStudentException("Last name cannot be empty.");
        }
        try {
            this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            throw new InvalidStudentException("Invalid date of birth format. Use yyyy-MM-dd.");
        }
        if (this.dateOfBirth.isBefore(LocalDate.of(1900, 1, 1)) || this.dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
            throw new InvalidStudentException("Date of birth must be between 1900 and current year - 18.");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female") && !gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            throw new InvalidStudentException("Gender must be 'male', 'female', 'M', or 'F'.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
