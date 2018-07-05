import java.util.Scanner;
public class rectangle1 {
    double length;
    double width;
    double area;
    double perimeter;

    rectangle1() {
        length = 1;
        width= 1;
    }

    rectangle1(int a,int b)
    {
        length=a;
        width=b;

    }


    public void set(double a,double b)
    {

        if(((a >=0.0 ) && (a<=20.0))  &&  (b>=0.0  &&  b<=20.0))
        {
            length = length;
            width = width;
        }
        else
        {
            System.out.println("Invalid input");

        }




    }


    public double perimeter()
    {

        perimeter=2*(length+width);
        return perimeter;
    }

       /* public int getlength() {

            return length;
        }

        public int getbreadth() {
            return breadth;
        }*/

    public double area() {
        area = length * width;
        area=area*100;
        Math.round(area);
        area=area/100;
        return area;
    }

    public void display() {
        System.out.println("length=" + length);
        System.out.println("breadth=" + width);
        System.out.println("area=" + area);
        System.out.println("perimeter="+perimeter);
    }
}





