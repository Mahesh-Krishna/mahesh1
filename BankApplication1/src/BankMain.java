import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class BankMain extends Customer {
    public static void main(String arg[]) {
        Random rand = new Random();
        //Customer customer=new Customer();
        SavingAccount savingAccount = new SavingAccount();
        //FixedAccount fixedAccount=new FixedAccount();

        int n, accountNo = 0, ch, type;
        float amount;

        //customer.details();
        Scanner sin = new Scanner(System.in);


        try {
            System.out.println("Enter the type of account do you want to create \n 1.saving \n 2.fixed deposit");
            while (!sin.hasNextInt()) {
                System.out.println("enter valid number \n 1.saving \n 2.fixed deposit");
                sin.next();
            }
            type = sin.nextInt();

            System.out.println("enter the number of account you want to create");
            while(!sin.hasNextInt()){
                System.out.println("enter number");
                sin.next();
            }
            n = sin.nextInt();
            Customer customer[] = new Customer[n];
            FixedAccount fixedAccount[] = new FixedAccount[n];


            for (int i = 0; i < n; i++) {
                customer[i] = new Customer();
                System.out.println("enter your name");
                String name = sin.next();
                customer[i].setName(name);
                System.out.println("Enter your address");
                String address = sin.next();
                customer[i].setAddress(address);

                customer[i].validateAdharNo();


                customer[i].validateMobileNo();//takes mobile number

                customer[i].validatePan();//takes pan card number


                if (type == 1) {
                    savingAccount.setBalance();
                    savingAccount.setSavingAccountNumber(rand.nextInt(100000));
                    savingAccount.getSavingsAccountNumber();
                    do {

                        System.out.println("1.Deposit");
                        System.out.println("2.WithDraw");
                        System.out.println("3.Display all data");
                        System.out.println("4.exit");
                        System.out.print("Enter ur choice:");
                        ch = sin.nextInt();
                        switch (ch) {
                            case 1:

                                System.out.print("Enter the amount:");
                                while (!sin.hasNextFloat()) {
                                    System.out.println("enter valid amount");
                                    sin.next();

                                }
                                amount = sin.nextFloat();
                                if (amount <= 0) {
                                    System.out.println("Invalid amount");
                                    break;
                                }
                                //   amount=savingAccount.validateAmount(amount);
                                savingAccount.deposit(amount);
                                break;

                            case 2:

                                System.out.print("Enter the amount to be withdraw:");
                                while (!sin.hasNextFloat()) {
                                    System.out.println("invalid amount\n Enter valid amount");
                                    sin.next();
                                }
                                amount = sin.nextFloat();
                                if (amount <= 0) {
                                    System.out.println("invalid amount");
                                    break;
                                }
                                savingAccount.withDraw(amount);
                                break;
                            case 3:
                                savingAccount.displayData();
                                break;


                            case 4:
                                break;
                        }

                        System.out.print("Do you want to continue press '1' else press any other number to exit):");
                        while (!sin.hasNextInt()) {
                            System.out.println("enter the valid number ");
                            sin.next();
                        }

                        ch = sin.nextInt();

                    } while (ch == 1);


                } else if (type == 2) {


                        fixedAccount[i] = new FixedAccount();
                        fixedAccount[i].setFixedAmount();
                        fixedAccount[i].setTime();
                        fixedAccount[i].setFixedAccountNumber(rand.nextInt(10000000));
                        fixedAccount[i].calculate();

                    System.out.println("fixed deposit details are \n");


                        System.out.println("Account number= " + fixedAccount[i].getFixedAccountNumber());
                        System.out.println("Rate of interest=" + fixedAccount[i].getRateOfInterest());
                        System.out.println("interest=" + fixedAccount[i].getInterest());
                        System.out.println("Final amount =" + fixedAccount[i].getFinalAmount());

                } else {
                    System.out.println("entered account type is not exist \n enter valid account type");
                }
            }
        }


       catch (Exception e)
       {
           System.out.println(e);
       }

       }


}

