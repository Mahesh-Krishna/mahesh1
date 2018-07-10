import java.util.Scanner;
    public class Rectangle1 {
        double length;
        double breadth;
        double area;

         Rectangle1() {
            length = 0;
            breadth = 0;
        }
        Rectangle1(double x,double y)
        {
            length=x;
            breadth=y;
        }



        public void set(double a,double b)
        {
            length=a;
            breadth=b;
        }

       /* public int getlength() {

            return length;
        }

        public int getbreadth() {
            return breadth;
        }*/

        public double area() {
            area = length * breadth;
            area=area*100;
            Math.round(area);
            area=area/100;
            return area;
        }

        public void display() {
            System.out.println("length=" + length);
            System.out.println("breadth=" + breadth);
            System.out.println("area=" + area);
        }
    }



