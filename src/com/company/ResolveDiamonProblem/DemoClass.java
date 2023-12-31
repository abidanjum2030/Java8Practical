package com.company.ResolveDiamonProblem;

interface DemoInterface1
{
    public default void display()
    {
        System.out.println("the display() method of DemoInterface1 invoked");
    }
}
interface DemoInterface2
{
    public default void display()
    {
        System.out.println("the display() method of DemoInterface2 invoked");
    }
}

public class DemoClass implements DemoInterface1, DemoInterface2
{
    public static void main(String args[])
    {
        DemoClass obj = new DemoClass();
        obj.display();
    }


    @Override
    public void display() {
        DemoInterface2.super.display();
    }
}