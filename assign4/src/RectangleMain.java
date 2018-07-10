import java.util.Scanner;

public class RectangleMain {
    public static void main(String arg[]) {

     /*   rectangle1 obj1=new rectangle1();
       // rectangle1 obj1=new rectangle1(2,6);
        System.out.println("Enter length");
        Scanner in = new Scanner(System.in);
        double a =in.nextDouble();
        System.out.println("Enter width");
        double b = in.nextDouble();




        obj1.set(a,b);
        obj1.area();
        obj1.perimeter();
        obj1.display();
*/


        Rectangle rectangle[] = new Rectangle[5];





        for (int i = 0; i < 5; i++)
        {
            rectangle[i] = new Rectangle();
            System.out.println("Enter length");
            Scanner in = new Scanner(System.in);

            while (!in.hasNextDouble())
            {
                System.out.println("Invalid input\n Type the double-type number:");
                in.next();
            }
            double length = in.nextDouble();

            rectangle[i].setLength(length);



            System.out.println("Enter width");
            Scanner in1 = new Scanner(System.in);
            while (!in1.hasNextDouble())
            {
                System.out.println("Invalid input\n Type the double-type number:");
                in1.next();
            }
            double width = in1.nextDouble();


            rectangle[i].setWidth(width);


            System.out.println("Length="+rectangle[i].getLength());
            System.out.println("width="+rectangle[i].getWidth());
            System.out.println("area="+ rectangle[i].getArea());
            System.out.println("perimeter"+ rectangle[i].getPerimeter());



        }
    }
}


