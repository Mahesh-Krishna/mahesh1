import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class TestEmployee {

    void  createEmployee(int l,String m,String n,Employee d)
    {
        d.setNumber(l);
        d.setName(m);
        d.setDate(n);

    }

    void showDetails(Employee d)
    {

        //d.get_book_title();
        //2
        //d.get_price();
        System.out.println("Employee details  " );
        System.out.println("Number "+d.getNumber());
        System.out.println("name "+d.getName());
        System.out.println("Join date "+d.getDate());



    }








    public static void main(String args[])  {
        Employee obj[] = new Employee[5];
        TestEmployee z=new TestEmployee();
        Employee d=new Employee();



        for (int i = 0; i < 5; i++)
        {
           // Employee obj[i]=new Employee();
            System.out.println("enter employee number");
            Scanner in = new Scanner(System.in);
            int a=in.nextInt();




            System.out.println("Enter employee name");
            Scanner in1= new Scanner(System.in);
            String b = in1.nextLine();


            System.out.println("Enter Employee joining date in format dd-MMM-yyyy");
            Scanner in2= new Scanner(System.in);
            String c = in2.nextLine();



           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");




            try {
                //Parsing the String
                 Date date2= dateFormat.parse(c);








            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("invalid date format");

               // System.out.println("Re enter Employee joining date in format dd-MMM-yyyy");
               // Scanner in3= new Scanner(System.in);
              //
                //  c = in3.next();

            }
          //  System.out.println(date2);*/



            z.createEmployee(a,b,c,d);
            z.showDetails(d);

        }
    }
}
