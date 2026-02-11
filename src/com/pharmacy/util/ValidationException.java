package com.pharmacy.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Validation Error: Invalid input or expired medicine";
    }
}
