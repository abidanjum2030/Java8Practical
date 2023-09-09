package com.company.hashcodeequal;

import java.util.HashSet;
import java.util.Objects;

public class HashCodeEquallExample {

    public static void main(String[] args)
    {
        Student std= new Student(1);
        Student std1= new Student(1);
        //System.out.println(std.equals(std1));

        //System.out.println(std.hashCode());
        //System.out.println(std1.hashCode());

        HashSet<Student> studenths = new HashSet<Student>();
        studenths.add(std);
        //studenths.add(std1);

        System.out.println(studenths.contains(std1));



    }
}

class Student {
    String name;
    int age;
    int id;

    public Student(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

