package inher_1;

import java.util.Scanner;

public class ContactDetails{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter how many contact to be added");
        int n=sc.nextInt();

        Derived d=new Derived(n);
        int z;
        do{
            System.out.println("select the choice \n1.add\n2.list\n3.search\n4.exit");
            z=sc.nextInt();
            switch(z)
            {
                case 1:d.add();
                    break;
                case 2:System.out.println(d.toString());
                    break;
                case 3:System.out.println("enter the name  to search contact number");
                    sc.nextLine();
                    String y=sc.nextLine();
                    d.search(y);
                    break;
                default:java.lang.System.exit(0);
            }
        }while(z==1||z==2||z==3);
    }
}
