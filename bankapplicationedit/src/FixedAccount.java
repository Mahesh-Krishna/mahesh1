import java.util.Scanner;

public class FixedAccount extends Customer
{
    private int fixedAccountNumber;
    private float fixedAmount;
    private float rateOfInterest=8;
    private float finalAmount,interest;
    private int  time;
    Scanner in=new Scanner(System.in);
    public void setFixedAccountNumber(int i)
    {
        fixedAccountNumber=i;

    }


   // public void setAccountNo(int i) {
     //   setAccountNo(i);
    //}

    public void setFixedAmount()
    {
       do {
           System.out.println("enter the amount for fixed deposit");
           while (!in.hasNextFloat()) {
               System.out.println("Enter valid amount");
               in.next();
           }
           fixedAmount = in.nextFloat();
           if(fixedAmount>0)
           {
               break;
           }
           else
               System.out.println("Enter amount greater than zero");
       }while(true);

    }
    public void setTime()
    {
       do {
           System.out.println("enter the time duration in years");
           while (!in.hasNextInt()) {

               System.out.println("Invalid duration \n enter valid duration");
               in.next();
           }
           time = in.nextInt();
           if(time>0)
           {
               break;
           }
       }while (true);
    }
    void calculate() {

        interest = (fixedAmount) * (time) * (rateOfInterest) / (100);
        finalAmount = fixedAmount + interest;
    }

    public int getFixedAccountNumber() {
        return fixedAccountNumber;
    }

    public float getFixedAmount() {
        return fixedAmount;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public float getFinalAmount() {
        return finalAmount;
    }

    public float getInterest() {
        return interest;
    }

    public int getTime() {
        return time;
    }

    public void display()
    {

        System.out.println("fixed deposit account number:"+fixedAccountNumber);
        System.out.println("fixed deposit amount:"+fixedAmount);
        System.out.println("Fixed deposit duration in years"+time);
        calculate();
        System.out.println("Interest for your deposit= "+interest);
        System.out.println("final amount after "+time+" years ="+finalAmount);

    }

}
