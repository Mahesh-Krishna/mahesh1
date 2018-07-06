import java.util.Scanner;
public class Date1 {

    public static void main(String args[])
    {
        Date obj=new Date(28,5,2018);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number to add");
        int a=in.nextInt();

        obj.change(a);



    }
}
