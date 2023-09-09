package com.company.java8Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StudentExample {
    public static void main(String[] args) {
        List<Student> studentlist = new ArrayList<Student>();
        studentlist.add(new Student("Jon", 22, 1001));
        studentlist.add(new Student("Steve", 19, 1003));
        studentlist.add(new Student("Kevin", 23, 1005));
        studentlist.add(new Student("Ron", 20, 1010));
        studentlist.add(new Student("Lucy", 18, 1111));
        System.out.println("Before Sorting the student data:");

        //java 8 forEach for printing the list
        //anonymous class
        studentlist.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });

        //Lambda
        studentlist.forEach(student -> System.out.println(student));

        //method reference
        studentlist.forEach(System.out::println);

        System.out.println("********************");

        //sort
        studentlist.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        studentlist.sort((o1, o2) -> o1.age - o2.age);
        studentlist.forEach(System.out::println);

    }
}

class Student {
    String name;
    int age;
    int id;
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    Student(String n, int a, int i){
        name = n;
        age = a;
        id = i;
    }
    @Override public String toString() {
        return ("Student[ "+"Name:"+this.getName()+
                " Age: "+ this.getAge() +
                " Id: "+ this.getId()+"]");
    }
}

