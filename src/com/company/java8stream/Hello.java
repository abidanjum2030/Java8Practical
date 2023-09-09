package com.company.java8stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class Hello {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("abid", 1, "English", 70.0));
        studentList.add(new Student("kashif", 1, "English", 90.0));
        studentList.add(new Student("ahmad", 1, "Math", 50.0));
        studentList.add(new Student("nasir", 1, "Math", 65.0));
        studentList.add(new Student("anandha", 1, "Math", 35.0));
        studentList.add(new Student("shujah", 1, "Biology", 80.0));

        Map<String,List<Student>> studentGroupBySubject = studentList.stream().collect(Collectors.groupingBy(student -> student.getSubject()));

        studentGroupBySubject.forEach((s, students) -> System.out.println(s + " " + students));


        exit(0);
        Long totalStudent = studentList.stream().collect(Collectors.counting());
        System.out.println(totalStudent);


        DoubleSummaryStatistics studentStat = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
                System.out.println("Highest " + studentStat.getMax());
                System.out.println("Highest " + studentStat.getMin());

        exit(0);

        Set<String> subjectList =  studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
        subjectList.forEach(s -> System.out.println(s));

        Map<Boolean, List<Student>> studentabove60percent =
                studentList.stream().collect(Collectors.partitioningBy(student -> student.getPercentage() > 60.0));
        // 2. For-each loop
        for (Map.Entry<Boolean, List<Student>> entry : studentabove60percent.entrySet()) {
            if (entry.getKey().booleanValue() == true) {
                //System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

        studentabove60percent.forEach((aBoolean, students) -> {
            if (aBoolean) {
                //System.out.println(students);
            }
        });


        List<Student> top3student =studentList.stream().sorted(Comparator.comparingDouble(Student:: getPercentage).reversed())
                .limit(3).collect(Collectors.toList());

        //top3student.forEach(student -> System.out.println(student.name));

        Map<String,Double> studentinfo = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));

        //studentinfo.forEach((s, aDouble) -> System.out.println(s + ":" + aDouble));

    }
}
class Student
{
String name;
int id;
String subject;
double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject='" + subject + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
