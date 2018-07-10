import java.util.Scanner;
public class Rectangle
{
    private double length;
    private double width;
    private double area;
    private double perimeter;

    Rectangle()
    {
        length = 1;
        width= 1;
    }

    Rectangle(double length,double width)
    {
       this.length=length;
        this.width=width;

    }


    public void setLength(double length)
    {

        if (((length >= 0.0) && (length <= 20.0)  && ((length*10)%10)!=0)  )
        {
            this.length = length;
        } else

            {
              double x;
              do {
                  System.out.println("enter valid floating point length in between 0.0 to 20.0");
                  Scanner in = new Scanner(System.in);
                  while (!in.hasNextDouble())
                  {
                      System.out.println("Invalid input\n Type the double-type number:");
                      in.next();
                  }
                  x = in.nextDouble();
                  this.length = x;
              }while(this.length<=0 || this.length>20  || ((this.length*10)%10)==0);

        }
    }



        public void setWidth(double width)
        {


            if ((width >= 0.0) && (width <= 20.0) && ((width*10)%10)!=0) {
                this.width = width;
            }
            else
                {
                    do {

                        System.out.println("enter floating point  width in between 0.0 to 20.0");
                        Scanner in = new Scanner(System.in);
                        while (!in.hasNextDouble())
                        {
                            System.out.println("Invalid input\n Type the double-type number:");
                            in.next();
                        }
                        double y = in.nextDouble();
                        this.width = y;
                    }while(this.width<=0 || this.width>20 || ((this.width*10)%10)==0);

            }


        }










    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }


    public double getArea() {
        area = length * width;
        area=area*100;
        Math.round(area);
        area=area/100;

        return area;
    }


    public double getPerimeter() {

        perimeter=2.0 * (length + width);
        perimeter=perimeter*100;
        Math.round(perimeter);
        perimeter=perimeter/100;


        return perimeter;
    }

   /* public void display()
    {
        System.out.println("length=" + length);
        System.out.println("breadth=" + width);
        System.out.println("area=" + area);
        System.out.println("perimeter="+perimeter);
    }*/
}





