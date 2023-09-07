package com.company.ComparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GFG {
    // Main driver method
    public static void main(String[] args) {
        // Creating an empty ArrayList of Student type
        ArrayList<Student> ar = new ArrayList<Student>();

        // Adding entries in above List
        // using add() method
        ar.add(new Student(111, "Mayank", "london"));
        ar.add(new Student(131, "Anshul", "nyc"));
        ar.add(new Student(121, "Solanki", "jaipur"));
        ar.add(new Student(101, "Aggarwal", "Hongkong"));

        // Display message on console for better readability
        System.out.println("Unsorted");

        // Iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by roll number
        Collections.sort(ar, new Sortbyroll());

        // Display message on console for better readability
        System.out.println("\nSorted by rollno");
        // Iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

    }
}

// Class 1
// A class to represent a Student
class Student {

    // Attributes of a student
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name, String address)
    {

        // This keyword refers to current instance itself
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Method of Student class
    // To print student details in main()
    public String toString()
    {

        // Returning attributes of Student
        return this.rollno + " " + this.name + " "
                + this.address;
    }
}

class Sortbyroll implements Comparator<Student>
{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollno - o2.rollno;
    }
}
