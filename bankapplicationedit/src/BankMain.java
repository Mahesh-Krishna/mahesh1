import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class BankMain extends Customer {
    public static void main(String arg[]) {
        Random rand = new Random();
        //Customer customer=new Customer();
        // SavingAccount savingAccount = new SavingAccount();
        //FixedAccount fixedAccount=new FixedAccount();
        int n=10, accountNo = 0, ch, type,key=0,i=0,j=0;
        float amount;
         LinkedHashMap<Integer,Customer>a=new LinkedHashMap<Integer, Customer>();
         LinkedHashMap<Integer,FixedAccount>b=new LinkedHashMap<Integer , FixedAccount>();
         LinkedHashMap<Integer,SavingAccount>c=new LinkedHashMap<Integer, SavingAccount>();

         Bank bank=new Bank();
        bank.details();
        Scanner sin = new Scanner(System.in);


        try {

            Customer customer[] = new Customer[n];
            FixedAccount fixedAccount[] = new FixedAccount[n];
            SavingAccount savingAccount[] = new SavingAccount[n];


         //  loop: for (int i = 0; i < n; i++) {


                do {
                    System.out.println("1.Create account");
                    System.out.println("2.Deposit");
                    System.out.println("3.WithDraw");
                    System.out.println("4.Display all data");
                    System.out.println("5.exit");
                    System.out.println("6.Transfer money");
                    System.out.print("Enter your choice:");
                    ch = sin.nextInt();
                    int index = 0, index1 = 0;

                    switch (ch)
                    {

                        case 1:

                            do {
                                System.out.println("Enter the type of account do you want to create \n 1.saving \n 2.fixed deposit");
                                while (!sin.hasNextInt()) {
                                    System.out.println("enter valid number \n 1.saving \n 2.fixed deposit");
                                    sin.next();
                                }
                                type = sin.nextInt();
                            } while (type != 1 && type != 2);
                            if (type == 1) {

                                customer[i] = new Customer();
                                System.out.println("enter your name");
                                String name = sin.next();
                                customer[i].setName(name);
                                System.out.println("Enter your address");
                                System.out.println("flat number/home:");
                                String address1=sin.next();
                                System.out.println("post:");
                                String address2=sin.next();
                                System.out.println("enter taluk:");
                                String address3 = sin.next();
                                customer[i].setAddress(address1,address2,address3);

                                customer[i].validateAdharNo();

                                customer[i].validateMobileNo();//takes mobile number

                                customer[i].validatePan();//takes pan card number

                                savingAccount[i] = new SavingAccount();
                                savingAccount[i].setBalance();
                                savingAccount[i].setSavingAccountNumber(rand.nextInt(100000));
                                savingAccount[i].getSavingsAccountNumber();
                                System.out.println("your saving account number=" + savingAccount[i].getSavingsAccountNumber());
                                a.put(savingAccount[i].getSavingsAccountNumber(), customer[i]);
                                c.put(savingAccount[index].getSavingsAccountNumber(), savingAccount[index]);
                                i++;
                            } else
                                {
                                    customer[j] = new Customer();
                                    System.out.println("enter your name");
                                    String name = sin.next();
                                    customer[j].setName(name);
                                    System.out.println("Enter your address");
                                    System.out.println("flat number/home:");
                                    String address1=sin.next();
                                    System.out.println("post/street name:");
                                    String address2=sin.next();
                                    System.out.println("enter taluk:");
                                    String address3 = sin.next();
                                    customer[j].setAddress(address1,address2,address3);

                                    customer[j].validateAdharNo();

                                    customer[j].validateMobileNo();//takes mobile number

                                    customer[j].validatePan();//takes pan card number

                                fixedAccount[j] = new FixedAccount();
                                fixedAccount[j].setFixedAmount();
                                fixedAccount[j].setTime();
                                fixedAccount[j].setFixedAccountNumber(rand.nextInt(10000000));
                                fixedAccount[j].calculate();
                                b.put(fixedAccount[j].getFixedAccountNumber(), fixedAccount[i]);
                                a.put(fixedAccount[j].getFixedAccountNumber(), customer[i]);


                                System.out.println("fixed deposit details are \n");


                                System.out.println("Account number= " + fixedAccount[j].getFixedAccountNumber());
                                System.out.println("Rate of interest=" + fixedAccount[j].getRateOfInterest());
                                System.out.println("interest=" + fixedAccount[j].getInterest());
                                System.out.println("Final amount =" + fixedAccount[j].getFinalAmount());
                                j++;

                                }
                            break;

                        case 2:
                            System.out.println("enter the account number");
                            while (!sin.hasNextInt()) {
                                System.out.println("Invalid input enter valid account number");
                                sin.next();
                            }

                            int accNo = sin.nextInt();

                            for (Map.Entry<Integer, Customer> entry : a.entrySet()) {

                                key = entry.getKey();
                                if (accNo == key)
                                    break;
                                //Customer a1=entry.getValue();
                                index++;
                                //  System.out.println(key+" Details:");
                                // System.out.println(a1.name+" "+a1.address+" "+a1.adharNo+" "+a1.mobileNo+" "+a1.panNo);
                            }
                            if (accNo != key)
                            {
                                System.out.println("invalid account number");
                            }
                            else {
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
                                System.out.println("index="+index);
                                savingAccount[index].deposit(amount);
                                c.put(savingAccount[index].getSavingsAccountNumber(), savingAccount[index]);
                                }
                            break;

                        case 3:
                            System.out.println("enter the account number");
                            while (!sin.hasNextInt()) {
                                System.out.println("Invalid input enter valid account number");
                                sin.next();
                            }
                            int acNo = sin.nextInt();

                            for (Map.Entry<Integer, Customer> entry : a.entrySet()) {

                                key = entry.getKey();
                                if (acNo == key)
                                    break;
                                //  Customer a1=entry.getValue();
                                index++;
                            }
                            if (acNo != key) {
                                System.out.println("invalid account number");
                            } else {

                                System.out.print("Enter the amount to be withdraw:");
                                while (!sin.hasNextFloat()) {
                                    System.out.println("invalid amount \n Enter valid amount");
                                    sin.next();
                                }
                                amount = sin.nextFloat();
                                if (amount <= 0) {
                                    System.out.println("invalid amount");
                                    break;
                                }
                                savingAccount[index].withDraw(amount);
                                c.put(savingAccount[index].getSavingsAccountNumber(), savingAccount[index]);

                            }
                            break;
                        case 4:
                            System.out.println("enter the account number");
                            while (!sin.hasNextInt()) {
                                System.out.println("Invalid input enter valid account number");
                                sin.next();
                            }
                            int aNo = sin.nextInt();

                            for (Map.Entry<Integer, Customer> entry : a.entrySet()) {

                                key = entry.getKey();
                                if (aNo == key) {
                                    Customer a1 = entry.getValue();
                                    System.out.println("account number=" + key + " Details:");
                                    System.out.println("name: " + a1.name + " adress: " + a1.address + "  adhar number: " + a1.adharNo + " Mobile number: " + a1.mobileNo + " pan number: " + a1.panNo);
                                }
                            }
                            for (Map.Entry<Integer, SavingAccount> entry : c.entrySet()) {

                                key = entry.getKey();
                                if (aNo == key) {
                                    SavingAccount c1 = entry.getValue();
                                    System.out.println(" Balance:");
                                    System.out.println(c1.getBalance());
                                }
                            }

                            //  System.out.println("index="+index);
                            //  savingAccount[index].displayData();
                            break;


                        case 5:
                            break;

                        case 6:
                            System.out.println("enter the account number");
                            while (!sin.hasNextInt()) {
                                System.out.println("Invalid input enter valid account number");
                                sin.next();
                            }
                            int accoNo = sin.nextInt();

                            for (Map.Entry<Integer, Customer> entry : a.entrySet()) {

                                key = entry.getKey();
                                if (accoNo == key) {
                                    System.out.println("enter the account number of the person who you want to transform money");
                                    while (!sin.hasNextInt()) {
                                        System.out.println("Invalid input enter valid account number");
                                        sin.next();
                                    }
                                    int accounNo = sin.nextInt();

                                    for (Map.Entry<Integer, Customer> entry1 : a.entrySet()) {

                                        key = entry1.getKey();
                                        if (accounNo == key) {
                                            System.out.println("enter the amount");
                                            amount = sin.nextFloat();
                                            savingAccount[index1].deposit(amount);
                                            savingAccount[index].withDraw(amount);
                                            c.put(savingAccount[index1].getSavingsAccountNumber(), savingAccount[index1]);
                                            c.put(savingAccount[index].getSavingsAccountNumber(), savingAccount[index]);

                                            break;

                                        }

                                        index1++;
                                    }

                                }

                                //  Customer a1=entry.getValue();
                                index++;
                            }
                            break;

                    }
                    // c.put(savingAccount[i].getSavingsAccountNumber(),savingAccount[i]);

                    System.out.print("Do you want to continue press '1' else press any other number to exit):");
                    while (!sin.hasNextInt()) {
                        System.out.println("enter the valid number ");
                        sin.next();
                    }

                    ch = sin.nextInt();
                    //if(ch!=1)
                   // {
                  //      break loop;
                  //  }

                } while (ch == 1);


           // }
        }


       catch (Exception e)
       {
           System.out.println(e);
       }

       }


}

