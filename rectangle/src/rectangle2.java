import java.util.Scanner;

public class rectangle2
{
    public static void main(String arg[])
    {
        rectangle1 obj1=new rectangle1();
        System.out.println("Enter length");
        Scanner in = new Scanner(System.in);
        double a =in.nextDouble();
        System.out.println("Enter breadth");
        double b = in.nextDouble();




        obj1.set(a,b);
        obj1.area();
        obj1.display();



        rectangle1 obj2=new rectangle1();
        System.out.println("Enter length");
        a =in.nextDouble();
        System.out.println("Enter breadth");
        b = in.nextDouble();
        obj2.set(a,b);
        obj2.area();
        obj2.display();

        rectangle1 obj3=new rectangle1();
        System.out.println("Enter length");
         a =in.nextDouble();
        System.out.println("Enter breadth");
         b = in.nextDouble();
        obj3.set(a,b);
        obj3.area();
        obj3.display();

        rectangle1 obj4=new rectangle1();
        System.out.println("Enter length");
         a =in.nextDouble();
        System.out.println("Enter breadth");
         b = in.nextDouble();
        obj4.set(a,b);
        obj4.area();
        obj4.display();

        rectangle1 obj5=new rectangle1();
        System.out.println("Enter length");
         a =in.nextDouble();
        System.out.println("Enter breadth");
         b = in.nextDouble();
        obj5.set(a,b);
        obj5.area();
        obj5.display();
    }
}

