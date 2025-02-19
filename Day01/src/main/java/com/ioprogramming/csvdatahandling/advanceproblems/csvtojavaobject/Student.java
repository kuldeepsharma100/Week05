package com.ioprogramming.csvdatahandling.advanceproblems.csvtojavaobject;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
