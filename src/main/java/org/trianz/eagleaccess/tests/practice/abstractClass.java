package org.trianz.eagleaccess.tests.practice;

abstract class abstractClass {
    //abstractMethod is abstract method of abstract class abstractClass
    abstract public void abstractMethod();
    public static int x;
}

class extendsAbsClass extends abstractClass{
public void abstractMethod()
{
    System.out.println("The abstractMethod of abstractClass is implemented in extendsAbsClass");
    x=2;
    System.out.println("Value of x in extendsAbsClass.abstractMethod is : "+x);
}
public static void main(String args[])
{

    extendsAbsClass e = new extendsAbsClass();
    System.out.println("Calling abstractMethod() using object of extendsAbsClass");
    e.abstractMethod();
    System.out.println("Manipulating value of x in main using object of extendsAbsClass");
    x=x*2;
    System.out.println("Value of x in main() is : "+x);
}
}