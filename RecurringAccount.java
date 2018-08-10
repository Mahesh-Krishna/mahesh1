import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

@Entity
@Table(name="ReccurringDeposite")
public class RecurringAccount {

    @Id
    @Column(name="refferenceNumber")
    private int referenceNumber;


    @Column(name="creationDate")
    private LocalDate creationDate;

    @Column(name="accountNumber")
    private String accountNumber;

    @Column(name="depositPeriod")
    private int depositPeriod;

    @Column(name="initialDeposit")
    private float initialDeposit;

    @Column(name="balance")
    private float balance;

    @Column(name="nominee")
    private String nominee;

  //  private HashMap<Integer, RecurringAccount> buffer = new HashMap();

    @Column(name="relationship")
    private String relationship;

    @Column(name="installmentCount")
    private int installmentCount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setInitialDeposit(float initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public String getRelationship() {
        return relationship;
    }


    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getDepositPeriod() {
        return depositPeriod;
    }

    public void setDepositPeriod(int depositPeriod) {
        this.depositPeriod = depositPeriod;
    }

    public float getInitialDeposit() {
        return initialDeposit;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }


    public void createRD(String accno) {
        connectJDBC con=new connectJDBC();
        RecurringAccount rd=new RecurringAccount();

        Random random = new Random();
        int randomPin;

        randomPin = random.nextInt(9000) + 1000;

        rd.setReferenceNumber(randomPin);
        rd.setAccountNumber(accno);

        Validation v=new Validation();
        Scanner input = new Scanner(System.in);
        String nominee;
        do {
            System.out.println("Who is your nominee?");
             nominee= input.next();
        }while (!v.nameValidation(nominee));
        rd.setNominee(nominee);

        String rel;
        do {
            System.out.println("What is the relationship with the nominee?");
            rel = input.next();
        }while (!v.nameValidation(rel));
        rd.setRelationship(rel);

        System.out.println("Choose the deposit period between 1 to 10 years");
        String depositPeriod = input.next();

        while (!Pattern.matches("[1-9]|[1][0]", depositPeriod)) {
            System.out.println("Invalid deposit period");
            depositPeriod = input.next();
        }

        rd.setCreationDate(LocalDate.now());
        rd.setDepositPeriod(Integer.parseInt(depositPeriod));

        rd.setInstallmentCount((rd.getDepositPeriod()*365)/31);

//        System.out.println("Number of installments : "+buffer.get(randomPin).getInstallmentCount());

        deposit(1,randomPin,rd);

        con.insert(rd);
    }

    public void deposit(int firstTransaction,int random,RecurringAccount rd) {
        float deposit;
        if (firstTransaction == 1) {
            //buffer.get(random).transaction.setTransactionType("Deposit");
            //buffer.get(random).transaction.setTransactionDate(LocalDate.now());

            // transaction.setTransactionDate(LocalDate.of(2018, Month.JULY, 7));

            System.out.println("\nhow much you want to deposit");
            try {
                Scanner input=new Scanner(System.in);
                deposit = input.nextFloat();
                while (deposit <=0 ||  deposit > 100000) {
                    System.out.println("Enter proper amount.");
                    deposit = input.nextFloat();
                }


                rd.setBalance(deposit);

                rd.setInitialDeposit(deposit);

                rd.setInstallmentCount(rd.getInstallmentCount() - 1);
                System.out.println("Remaining installments : " + rd.getInstallmentCount());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        else {
            RecurringAccount obj=new RecurringAccount();
                    obj=checkPin();
            if (obj!=null) {
                /*if (DAYS.between(buffer.get(random).transaction.getTransactionDate(), LocalDate.now()) != 31) {
                    System.out.println("Deposit the amount after a month");
                } else */{
                    System.out.println("How much you want to deposit?");
                    try {
                        Scanner input=new Scanner(System.in);
                        deposit = input.nextFloat();
                        while (deposit <= 0 && deposit >= 100000 && deposit != obj.getInitialDeposit()) {
                            System.out.println("Enter proper amount.");
                            deposit = input.nextFloat();
                        }

                     //   buffer.get(random).transaction.setTransactionDate(LocalDate.now());
                       // System.out.println("Next deposit on : " + buffer.get(random).transaction.getTransactionDate().plusDays(31));
                       // buffer.get(random).setBalance(buffer.get(random).getBalance() + deposit);
                           //RecurringAccount r=new RecurringAccount();
                            obj.setBalance(obj.getBalance()+deposit);

                        obj.setInstallmentCount(obj.getInstallmentCount() - 1);
                        connectJDBC con=new connectJDBC();
                        con.update(obj,obj.getReferenceNumber());
                        System.out.println("Remaining installments : " + obj.getInstallmentCount());
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
            } else {
                System.out.println("RD doesnt exist");
            }
        }
    }


    public void withdraw() {
             RecurringAccount random=checkPin();
        if(random!=null) {
            if (YEARS.between(random.getCreationDate(), LocalDate.now()) == random.getDepositPeriod()) {
                random.interest(random);
                System.out.println("Your Final Amount" + random.getBalance());
            } else {
                System.out.println("You cannot withdraw!");
            }
        }
        else{
            System.out.println("RD doesnt exist");
        }
    }

    public void interest(RecurringAccount random) {
        random.setBalance(random.getBalance() + (random.getBalance() * random.getDepositPeriod() * (6/100)));
    }


    public void showAll(String accountNumber) {
        connectJDBC con=new connectJDBC();
        RecurringAccount rd=new RecurringAccount();

        con.showAllRD(accountNumber,rd);

    }

    public void viewDetails() {
        RecurringAccount random=new RecurringAccount();
                random=checkPin();
        if(random!=null) {
            System.out.println("--------------------------Your Details----------------------------");
            System.out.println("Your Reference Number    : " + random.getReferenceNumber());
            System.out.println("Your nominee             : " + random.getNominee());
            System.out.println("Relationship with nomine : " + random.getRelationship());
            System.out.println("Your RD lifetime         : " + random.getDepositPeriod());
            System.out.println("Your initial Deposit     : " + random.getInitialDeposit());
            System.out.println("Balance                  : " + random.getBalance());
            System.out.println("Remaining Installment    : " + random.getInstallmentCount());
            System.out.println("Your RD creation Date    : " + random.getCreationDate());
            System.out.println("-----------------------------------------------------------------");
        }
        else{
            System.out.println("RD doesnt exist");
        }
    }


    public void recurringAccount(String accountnum) {
        while (true) {
            System.out.println("Press 1-Create RD 2-Deposit into existing RD 3-Show All Deposit 4-View Details 5-Withdraw 6-logout");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            //choice validation
            switch (choice) {
                case 1:
                    createRD(accountnum);
                    break;
                case 2:
                    deposit(2,0,null);
                    break;
                case 3: showAll(accountnum);
                    break;
                case 4:
                    viewDetails();
                    break;

                case 5:withdraw();
                    break;
                case 6:
                    System.out.println("\n\n####----Logged out Successfully----####");
                    return;

                default:
                    System.out.println("\n\nInvalid choice");
            }
        }
    }

    public RecurringAccount checkPin(){
        connectJDBC con=new connectJDBC();
        RecurringAccount rd=new RecurringAccount();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the reference number : ");
        String random = input.nextLine();
        while (!Pattern.matches("[0-9]{4}", random)) {
            System.out.println("Invalid Refference : ");
            random = input.nextLine();
        }

        rd=con.retriveRD(rd,Integer.parseInt(random));

        if (rd==null)
        {
            System.out.println("RD doesnot exxit");
            return null;
        }
        else {return rd;}
    }

}