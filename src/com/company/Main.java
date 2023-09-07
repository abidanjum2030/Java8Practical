package com.company;

import com.company.polymorphism.Parent;
import com.company.polymorphism.child1;
import com.company.polymorphism.child2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parent parent = new Parent();
        //parent.Print();         //executes parent Print () method

        parent = new child1();  //upcasting
        parent.Print();         //executes child1 Print () method

        //parent = new child2();  //upcasting
        //parent.Print();         //executes child2 Print () method
    }
}
