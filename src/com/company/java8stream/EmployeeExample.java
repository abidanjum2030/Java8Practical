package com.company.java8stream;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class EmployeeExample {
    public static void main(String[] args)
    {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(1,"abid",40, "male","DIS",2013,15000));
        employeeList.add(new Employee(2,"astaba",35, "male","DIS",2016,17000));
        employeeList.add(new Employee(3,"anandha",30, "male","DIS",2019,21000));
        employeeList.add(new Employee(4,"shujah",45, "male","DIS",2017,19000));
        employeeList.add(new Employee(5,"ehab",37, "male","DIS",2020,12000));
        employeeList.add(new Employee(6,"lama",25, "female","DIS",2022,10000));
        employeeList.add(new Employee(7,"Wael",50, "male","GIS",2000,22000));



        Map<String, Long> genderclassification = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        genderclassification.forEach(new BiConsumer<String, Long>() {
            @Override
            public void accept(String s, Long aLong) {
                System.out.println(s + " " + aLong);
            }
        });

        exit(0);

        Map<String, Long> numberofemployeedepartmentwise = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

numberofemployeedepartmentwise.forEach(new BiConsumer<String, Long>() {
    @Override
    public void accept(String s, Long aLong) {
        System.out.println(s + " " + aLong);
    }
});

exit(0);

        Optional<Employee> mostYoungest = employeeList.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println(mostYoungest);


        exit(0);
        Optional<Employee> mostsenior =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        System.out.println(mostsenior);

        exit(0);

        Optional<Employee> senioremployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println(senioremployee);

        exit(0);

        Map<String, Double> empaverageage = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));

        empaverageage.forEach((s, aDouble) -> System.out.println(s + " " + aDouble));

        exit(0);


        Optional<Employee> highlypaid = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(highlypaid);


        exit(0);

        Map<String, Double> empAverageSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        empAverageSalary.forEach((s, aDouble) -> System.out.println(s + " " + aDouble));


        exit(0);

        Map<String, Long> empCount =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empCount.forEach((s, aLong) -> System.out.println(s + " " + aLong));

    }
}
