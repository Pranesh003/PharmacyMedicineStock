package com.pharmacy.util;

public class ActivePrescriptionException extends Exception {
    public String toString() {
        return "Cannot remove medicine: Active prescriptions exist";
    }
}
