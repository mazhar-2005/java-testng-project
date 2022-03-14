package org.trianz.eagleaccess.tests.practice;

//practice is abstract class
abstract class practice {
    //testMethod is abstract method of abstract class practice
    abstract public void testMethod();
    public static int x;
}

//practice2 class extends practice class
class practice2 extends practice{
    //practice.testMethod is implemented in practice2
    public void testMethod()
    {
        System.out.println("This method is inside normal class practice2 ");
        x=1;
        System.out.println("Value of abstract class variable x in testMethod() is : "+x);
    }
    public static void main(String args[])
    {
        practice2 p2 = new practice2();
        p2.testMethod();
        practice p = new practice2();
        p.testMethod();
        x=x+1;
        System.out.println("Value of abstract class variable x in main() is : "+x);
    }
}
