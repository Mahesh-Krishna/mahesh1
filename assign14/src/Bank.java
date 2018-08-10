import java.util.*;
public class Bank {
    private int accno;
    private float bal;
    private String cname,addr;
    Scanner sin = new Scanner(System.in);
    public void setcname() {
        System.out.print("Enter the Customer name:");
        cname = sin.nextLine();
    }
    public void setAddr() {
        System.out.print("Enter the Customer address: ");
        addr=sin.nextLine();

    }

    public void setAccNo(int i)
    {
        accno=i;

    }


    public void setBal() {


        do {
            System.out.print("Enter the initial balance :");
            while (!sin.hasNextFloat()) {
                System.out.println("enter the valid amount in numbers");
                sin.next();
            }
            bal = sin.nextFloat();
            if (bal < 0.0) {
                System.out.println("Balance should greater than zero");
                continue;

            } else {
                break;
            }
        } while (true);
    }
    public void displayData()
    {

        System.out.println("Accno:"+accno);
        System.out.println("Customer name:"+cname);
        System.out.println("Customer address:"+addr);
        System.out.println("Balance amount:"+bal);
    }
    public void Deposit(float x)
    {
        bal+=x;
    }
    public int getAccno()
    {
        return accno;
    }
    public void withDraw(float x)
    {
        if(bal>x)
            bal=bal-x;
        else
            System.out.println("Ur balance is only "+bal);
    }
}
