import java.util.Scanner;
public class TestEmployee {

    void  CreateEmployee(int l,String m,String n,Employee d)
    {
        d.setNumber(l);
        d.setName(m);
        d.setDate(n);

    }

    void showdetails(Employee d)
    {

        //d.get_book_title();
        //2
        //d.get_price();
        System.out.println("Employee details  " );
        System.out.println("Number"+d.getNumber());
        System.out.println("name"+d.getName());
        System.out.println("Join date"+d.getDate());



    }








    public static void main(String args[]) {
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


            System.out.println("Enter Employee joining date");
            Scanner in2= new Scanner(System.in);
            String c = in2.nextLine();


            z.CreateEmployee(a,b,c,d);
            z.showdetails(d);

        }
    }
}
