import java.util.Scanner;

public class SavingAccount extends Customer{
    private  int savingsAccountNumber;
    private  float balance;
    Scanner sin=new Scanner(System.in);
    public void setSavingAccountNumber(int i)
    {
        savingsAccountNumber=i;
    }

    public void setBalance() {


        do {
            System.out.print("Enter the initial balance :");
            while (!sin.hasNextFloat()) {
                System.out.println("enter the valid amount in numbers");
                sin.next();
            }
            this.balance = sin.nextFloat();
            if (this.balance < 0.0) {
                System.out.println("Balance should greater than zero");
                continue;

            } else {
                break;
            }
        } while (true);
    }

    public void displayData()
    {

        System.out.println("savings acoount number:"+savingsAccountNumber);
        System.out.println("Balance amount of savings:"+balance);
    }

    public void deposit(float x)
    {
        balance+=x;
    }
    public int getSavingsAccountNumber()
    {
        return savingsAccountNumber;
    }
    public void withDraw(float x)
    {
        if(balance>=x)
            balance=balance-x;
        else
            System.out.println("your balance is only "+balance);
    }

    public float getBalance()
    {
        return balance;
    }



}

