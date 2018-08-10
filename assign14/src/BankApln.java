import java.util.*;
public class BankApln {
    public static void main(String arg[])
    {
        Bank b[];
        Bank y=new Bank();
        int n,accno=0,ch,i,temp=0;
        float amt;
        Scanner sin=new Scanner(System.in);
l3:   do{     System.out.println("Enter the number of account do you want to create:");
        while (!sin.hasNextInt()) {
            System.out.println("enter the valid  number");
            sin.next();
        }
        n=sin.nextInt();
        if(n<=0)
        {
           System.out.println("enter valid number");
           continue l3;
        }
        else
            {
            break l3;
        }}while(true);
        b=new Bank[n];
        for(i=0;i<n;i++)
            b[i]=new Bank();
        for(i=0;i<n;i++) {
            b[i].setcname();
            b[i].setAddr();


            b[i].setAccNo(i+1);
            System.out.println("Your account number = "+b[i].getAccno());
            b[i].setBal();
        }

        do
        {
            System.out.println("1.Deposit");
            System.out.println("2.WithDraw");
            System.out.println("3.Display all data");
          //  System.out.println("4.Check Balance");
            System.out.println("4.exit");
            System.out.print("Enter ur choice:");
            ch=sin.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Enter the account number:");
                    accno=sin.nextInt();
                    System.out.print("Enter the amount:");
                    amt=sin.nextInt();
                    for(i=0;i<b.length;i++)
                    {
                        if(accno==b[i].getAccno())
                        {
                            b[i].Deposit(amt);
                            b[i].displayData();
                            temp=10;
                        }
                    }
                    if(temp==0)
                        System.out.println("Enter the correct account number");
                    break;
                case 2:
                    System.out.print("Enter the account number:");
                    accno=sin.nextInt();
                    System.out.print("Enter the amount to be withdraw:");
                    amt=sin.nextFloat();
                    for(i=0;i<b.length;i++)
                    {
                        if(accno==b[i].getAccno())
                        {
                            b[i].withDraw(amt);
                            temp=10;
                        }
                    }
                    if(temp==0)
                        System.out.println("Enter the correct account number");
                    break;
                case 3:
                    for(i=0;i<b.length;i++)
                        b[i].displayData();
                    break;


               /*     case 4:
                        System.out.print("Enter the account number:");
                        accno=sin.nextInt();
                    for(i=0;i<b.length;i++)
                    {
                        if(accno==b[i].getAccno())
                        {
                            b[i].displayData();
                            temp=10;
                        }
                    }
                        if(temp==0)
                            System.out.println("Enter the correct account number");
                        break;


*/
                case 4:
                    break;
            }
            temp=0;
            System.out.print("Do u want to continue press '1' else press any other number to exit):");
            while (!sin.hasNextInt()) {
                System.out.println("enter the valid number ");
                sin.next();
            }

            ch=sin.nextInt();

        }while(ch==1);
    }
}
