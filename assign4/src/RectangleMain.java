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


        //  Rectangle1 ob=new Rectangle1(1,2);


        for (int i = 0; i < 5; i++)
        {
            rectangle[i] = new Rectangle();
            System.out.println("Enter length");
            Scanner in = new Scanner(System.in);
            double length = in.nextDouble();

            rectangle[i].setLength(length);

          /*  if (a <= 0 || a>20)
            {

                System.out.println("invalid length");
                continue;
            }*/

            System.out.println("Enter width");
            Scanner in1 = new Scanner(System.in);
            double width = in1.nextDouble();

           /* if (b <= 0 || b >20)
            {

                System.out.println("invalid width");
                continue;
            }*/


            rectangle[i].setWidth(width);

            System.out.println("Length="+rectangle[i].getLength());
            System.out.println("width="+rectangle[i].getWidth());
            System.out.println("area="+ rectangle[i].getArea());
            System.out.println("perimeter"+ rectangle[i].getPerimeter());



        }
    }
}


