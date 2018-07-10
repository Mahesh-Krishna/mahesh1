import java.util.Scanner;

public class Rectangle2
{
    public static void main(String arg[])
    {
        Rectangle1 obj[]=new Rectangle1[5];



      //  Rectangle1 ob=new Rectangle1(1,2);
        for(int i=0;i<5;i++)
        {
            obj[i]=new Rectangle1();
            System.out.println("Enter length");
            Scanner in = new Scanner(System.in);
            double a = in.nextDouble();
            if(a<=0 )
            {

                System.out.println("invalid length");
                continue;
            }
            System.out.println("Enter breadth");
            double b = in.nextDouble();
            if(b<=0 )
            {

                System.out.println("invalid breadth");
                continue;
            }
            obj[i].set(a, b);
            obj[i].area();
            obj[i].display();



        }

    }
}

