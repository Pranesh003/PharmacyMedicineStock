package com.pharmacy.util;

public class OutOfStockException extends Exception {
    public String toString() {
        return "Out Of Stock: Insufficient stock available";
    }
}
