// Path: /src/main/java/com/example/exceptions/StudentNotFoundException.java
package com.example.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
