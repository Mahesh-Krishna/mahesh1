import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class BankMain extends Customer {
    public static void main(String arg[]) {
        Random rand = new Random();
        //Customer customer=new Customer();
        // SavingAccount savingAccount = new SavingAccount();
        //FixedAccount fixedAccount=new FixedAccount();
        int n, accountNo = 0, ch, type,key=0;
        float amount;
         LinkedHashMap<Integer,Customer>a=new LinkedHashMap<Integer, Customer>();
         LinkedHashMap<Integer,FixedAccount>b=new LinkedHashMap<Integer , FixedAccount>();
         LinkedHashMap<Integer,SavingAccount>c=new LinkedHashMap<Integer, SavingAccount>();

         Bank bank=new Bank();
        bank.details();
        Scanner sin = new Scanner(System.in);


        try {
            do {
                System.out.println("Enter the type of account do you want to create \n 1.saving \n 2.fixed deposit");
                while (!sin.hasNextInt()) {
                    System.out.println("enter valid number \n 1.saving \n 2.fixed deposit");
                    sin.next();
                }
                type = sin.nextInt();
            }while(type!=1 && type!=2);

            do {
                System.out.println("enter the number of account you want to create");
                while (!sin.hasNextInt()) {
                    System.out.println("Invalid number  \n enter number");
                    sin.next();
                }
                n = sin.nextInt();
            }while (n<=0);
            Customer customer[] = new Customer[n];
            FixedAccount fixedAccount[] = new FixedAccount[n];
            SavingAccount savingAccount[]=new SavingAccount[n];


            for (int i = 0; i < n; i++) {
                customer[i] = new Customer();
                System.out.println("enter your name");
                String name = sin.next();
                customer[i].setName(name);
                System.out.println("Enter your address");
                System.out.println("flat number/home:");
                sin.next();
                System.out.println("post:");
                sin.next();
                System.out.println("enter taluk:");
                String address = sin.next();
                customer[i].setAddress(address);

                customer[i].validateAdharNo();

                customer[i].validateMobileNo();//takes mobile number

                customer[i].validatePan();//takes pan card number



                if (type == 1) {
                    savingAccount[i]=new SavingAccount();
                    savingAccount[i].setBalance();
                    savingAccount[i].setSavingAccountNumber(rand.nextInt(100000));
                    savingAccount[i].getSavingsAccountNumber();
                    System.out.println("your saving account number="+savingAccount[i].getSavingsAccountNumber());
                    a.put(savingAccount[i].getSavingsAccountNumber(),customer[i]);

                    do {

                        System.out.println("1.Deposit");
                        System.out.println("2.WithDraw");
                        System.out.println("3.Display all data");
                        System.out.println("4.exit");
                        System.out.println("5.Transfer money");
                        System.out.print("Enter your choice:");
                        ch = sin.nextInt();
                        int index=0,index1=0;
                        c.put(savingAccount[i].getSavingsAccountNumber(),savingAccount[i]);
                        switch (ch) {
                            case 1:
                                System.out.println("enter the account number");
                               while (!sin.hasNextInt())
                               {
                                    System.out.println("Invalid input enter valid account number");
                                    sin.next();
                                    }

                                int accNo=sin.nextInt();

                                for(Map.Entry<Integer, Customer> entry:a.entrySet()){

                                    key=entry.getKey();
                                     if(accNo==key)
                                         break;
                                    //Customer a1=entry.getValue();
                                    index++;
                                  //  System.out.println(key+" Details:");
                                   // System.out.println(a1.name+" "+a1.address+" "+a1.adharNo+" "+a1.mobileNo+" "+a1.panNo);
                                }
                                if(accNo!=key){
                                    System.out.println("invalid account number");
                                }
                                else {
                                    System.out.print("Enter the amount:");
                                    while (!sin.hasNextFloat())
                                    {
                                        System.out.println("enter valid amount");
                                        sin.next();
                                        }
                                    amount = sin.nextFloat();
                                    if (amount <= 0) {
                                        System.out.println("Invalid amount");
                                        break;
                                    }
                                    //   amount=savingAccount.validateAmount(amount);
                                    //System.out.println("index="+index);
                                    savingAccount[index].deposit(amount);
                                    c.put(savingAccount[index].getSavingsAccountNumber(),savingAccount[index]);

                                    }
                                break;

                            case 2:
                                System.out.println("enter the account number");
                                while (!sin.hasNextInt()){
                                    System.out.println("Invalid input enter valid account number");
                                    sin.next();
                                }
                                int acNo=sin.nextInt();

                                for(Map.Entry<Integer, Customer> entry:a.entrySet()){

                                    key=entry.getKey();
                                    if(acNo==key)
                                        break;
                                  //  Customer a1=entry.getValue();
                                    index++;
                                }
                                if(acNo!=key)
                                {
                                    System.out.println("invalid account number");
                                }
                                else {

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
                                    c.put(savingAccount[index].getSavingsAccountNumber(),savingAccount[index]);

                                }
                                break;
                            case 3:
                                System.out.println("enter the account number");
                                while (!sin.hasNextInt()){
                                    System.out.println("Invalid input enter valid account number");
                                    sin.next();
                                }
                                int aNo=sin.nextInt();

                                for(Map.Entry<Integer, Customer> entry:a.entrySet()){

                                    key=entry.getKey();
                                    if(aNo==key) {
                                        Customer a1=entry.getValue();
                                        System.out.println("account number="+key+" Details:");
                                    System.out.println("name: "+a1.name+" adress: "+a1.address+"  adhar number: "+a1.adharNo+" Mobile number: "+a1.mobileNo+" pan number: "+a1.panNo);
                                    }
                                    }
                                for(Map.Entry<Integer, SavingAccount> entry:c.entrySet()){

                                    key=entry.getKey();
                                    if(aNo==key) {
                                        SavingAccount c1=entry.getValue();
                                        System.out.println(" Balance:");
                                        System.out.println(c1.getBalance());
                                    }
                                }

                              //  System.out.println("index="+index);
                              //  savingAccount[index].displayData();
                                break;


                            case 4:
                                break;

                            case 5:
                                System.out.println("enter the account number");
                                while (!sin.hasNextInt()){
                                    System.out.println("Invalid input enter valid account number");
                                    sin.next();
                                }
                                int accoNo=sin.nextInt();

                                for(Map.Entry<Integer, Customer> entry:a.entrySet()){

                                    key=entry.getKey();
                                    if(accoNo==key){
                                        System.out.println("enter the account number of the person who you want to transform money");
                                        while (!sin.hasNextInt()){
                                            System.out.println("Invalid input enter valid account number");
                                            sin.next();
                                        }
                                        int accounNo=sin.nextInt();

                                        for(Map.Entry<Integer, Customer> entry1:a.entrySet()) {

                                            key = entry1.getKey();
                                            if (accounNo == key) {
                                                System.out.println("enter the amount");
                                                amount = sin.nextFloat();
                                                savingAccount[index1].deposit(amount);
                                                savingAccount[index].withDraw(amount);
                                                c.put(savingAccount[index1].getSavingsAccountNumber(),savingAccount[index1]);
                                                c.put(savingAccount[index].getSavingsAccountNumber(),savingAccount[index]);

                                                break;

                                            }

                                            index1++;
                                        }

                                    }

                                    //  Customer a1=entry.getValue();
                                    index++;
                                }

                        }
                       // c.put(savingAccount[i].getSavingsAccountNumber(),savingAccount[i]);

                        System.out.print("Do you want to continue press '1' else press any other number to exit):");
                        while (!sin.hasNextInt()) {
                            System.out.println("enter the valid number ");
                            sin.next();
                        }

                        ch = sin.nextInt();

                    } while (ch == 1);


                } else if (type == 2) {


                        System.out.println("1.Deposit fixed amount");
                        System.out.println("2.get details");
                        System.out.print("Enter your choice:");
                        ch = sin.nextInt();
                    do {
                        switch (ch) {
                            case 1:

                                fixedAccount[i] = new FixedAccount();
                                fixedAccount[i].setFixedAmount();
                                fixedAccount[i].setTime();
                                fixedAccount[i].setFixedAccountNumber(rand.nextInt(10000000));
                                fixedAccount[i].calculate();
                                b.put(fixedAccount[i].getFixedAccountNumber(), fixedAccount[i]);
                                a.put(fixedAccount[i].getFixedAccountNumber(), customer[i]);


                                System.out.println("fixed deposit details are \n");


                                System.out.println("Account number= " + fixedAccount[i].getFixedAccountNumber());
                                System.out.println("Rate of interest=" + fixedAccount[i].getRateOfInterest());
                                System.out.println("interest=" + fixedAccount[i].getInterest());
                                System.out.println("Final amount =" + fixedAccount[i].getFinalAmount());
                                break;
                            case 2:
                                System.out.println("enter the account number");
                                while (!sin.hasNextInt()){
                                    System.out.println("Invalid input enter valid account number");
                                    sin.next();
                                }
                                int aNo=sin.nextInt();

                                for(Map.Entry<Integer, Customer> entry:a.entrySet()){

                                    key=entry.getKey();
                                    if(aNo==key) {
                                        Customer a1=entry.getValue();
                                        System.out.println("account number="+key+" Details:");
                                        System.out.println("name: "+a1.name+" adress: "+a1.address+"  adhar number: "+a1.adharNo+" Mobile number: "+a1.mobileNo+" pan number: "+a1.panNo);
                                    }
                                }
                                for(Map.Entry<Integer, FixedAccount> entry:b.entrySet()){

                                    key=entry.getKey();
                                    if(aNo==key) {
                                        FixedAccount b1=entry.getValue();
                                        System.out.println("deposited amount:"+b1.getFixedAmount());
                                        System.out.println("rate of interest:"+b1.getRateOfInterest());
                                        System.out.println("interest:"+b1.getInterest());
                                        System.out.println("duration in years:"+b1.getTime());
                                        System.out.println("Amount after "+b1.getTime()+" years:"+b1.getFinalAmount());

                                    }
                                }

                        }
                        System.out.print("Do you want to get details press '2' else press any other number to exit):");
                        while (!sin.hasNextInt()) {
                            System.out.println("enter the valid number ");
                            sin.next();
                        }

                        ch = sin.nextInt();

                    }while(ch==2);


                }

                else
                    {
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

