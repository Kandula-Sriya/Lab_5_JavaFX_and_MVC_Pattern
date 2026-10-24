/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5.model;

/**
 *
 * @author sriya
 */


public class Person {

    private final String name;
    private final int age;
    private final String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName()  { return name; }
    public int getAge()      { return age; }
    public String getEmail() { return email; }

    // ---------- Validation rules (return null when valid) ----------

    public static String validateName(String name) {
        if (name == null || name.trim().isEmpty())
            return "Name is required.";
        String n = name.trim();
        if (n.length() < 2)
            return "Name must be at least 2 characters.";
        if (n.length() > 50)
            return "Name must be at most 50 characters.";
        if (!n.matches("[A-Za-z]+([ .'-][A-Za-z]+)*"))
            return "Use letters only (spaces, . ' - allowed between words).";
        return null;
    }

    public static String validateAge(String ageText) {
        if (ageText == null || ageText.trim().isEmpty())
            return "Age is required.";
        try {
            int a = Integer.parseInt(ageText.trim());
            if (a < 1 || a > 120)
                return "Age must be between 1 and 120.";
        } catch (NumberFormatException e) {
            return "Age must be a whole number.";
        }
        return null;
    }

    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty())
            return "Email is required.";
        if (email.trim().length() > 100)
            return "Email is too long.";
        if (!email.trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$"))
            return "Enter a valid email (e.g. name@example.com).";
        return null;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }
}
