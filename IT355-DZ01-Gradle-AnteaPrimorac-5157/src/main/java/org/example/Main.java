package org.example;

public class Main {

    public static void main(String[] args) {
        StudentDataReader reader = new StudentDataReader();
        // Datoteka namjerno sadrži jedan nepravilan red
        reader.readStudentData("studenti.xlsx");
    }
}