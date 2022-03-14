package org.trianz.eagleaccess.tests.practice;

interface interfaceEx {
    abstract void interfaceMethodEx();
}
interface interfaceEx1 {
    abstract void interfaceMethodEx1();
}
public class extInterfaceClass implements interfaceEx,interfaceEx1
{
    public void interfaceMethodEx()
    {
        System.out.println("This is interfaceMethodEx()");
    }
    public void interfaceMethodEx1()
    {
        System.out.println("This is interfaceMethodEx1()");
    }
    public static void main(String args[])
    {
        interfaceEx ex = new extInterfaceClass();
        System.out.println("interfaceEx.interfaceMethodEx() is called");
        ex.interfaceMethodEx();
        interfaceEx1 ex1 = new extInterfaceClass();
        System.out.println("interfaceEx1.interfaceMethodEx1() is called");
        ex1.interfaceMethodEx1();
    }
}