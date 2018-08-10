
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.exit;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

@Entity
public class FixedAccount
{
    @Column
    private String accountNumber;

    @Column
    private String nominee;

    @Column
    private String relation;

    @Column
    private int depositPeriod;

    @Column
    @Id
    private int refNum;

    @Column
    private float accountBalance;

    @Column
    private LocalDate depositDate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }

    public int getDepositPeriod() {
        return depositPeriod;
    }

    public void setDepositPeriod(int depositPeriod) {
        this.depositPeriod = depositPeriod;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRefNum() {
        return refNum;
    }

    public void setRefNum(int refNum) {
        this.refNum = refNum;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void withdraw() {
        FixedAccount random=checkPin();
        if(random!=null) {
            if (YEARS.between(random.getDepositDate(), LocalDate.now()) == random.getDepositPeriod()) {
                random.interest(random);
                System.out.println("Your Final Amount" + random.getAccountBalance());
            } else {
                System.out.println("You cannot withdraw!");
            }
        }
        else{
            System.out.println("RD doesnt exist");
        }
    }

    public float interest(FixedAccount fd) {

        float intrest;
        intrest=(fd.getAccountBalance()*fd.getDepositPeriod()*(float)0.06);
        return intrest;
    }

    public void deposit(int random, FixedAccount fd) {

        Scanner input = new Scanner(System.in);
        System.out.println("\nhow much you want to deposit");
        try {
            float deposit = input.nextFloat();
            while (deposit <= 0 || deposit > 100000) {
                System.out.println("Enter proper amount.");
                deposit = input.nextFloat();
            }

            fd.setAccountBalance(deposit);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    public void CreateFd(String accountnum) {

        FixedAccount fd = new FixedAccount();
        refNum = (int) ((Math.random() * 9000) + 1000);
        fd.setRefNum(refNum);
        fd.setAccountNumber(accountnum);
        //System.out.println(refNum);

        System.out.println("enter your nominee name");
        Scanner sc = new Scanner(System.in);
        nominee = sc.nextLine();
        //validation for nominee
        fd.setNominee(nominee);

        System.out.println("relationship between the nominee");
        relation = sc.nextLine();
        //validation for
        fd.setRelation(relation);

        Scanner input = new Scanner(System.in);
        System.out.println("Choose the deposit period between 1 to 10 years");
        String depositPeriod = input.next();
        while (!Pattern.matches("[1-9]|[1][0]", depositPeriod)) {
            System.out.println("Invalid deposit period");
            depositPeriod = input.next();
        }
        fd.setDepositPeriod(Integer.parseInt(depositPeriod));
        fd.setDepositDate(LocalDate.now());

        deposit(refNum, fd);

        connectJDBC con = new connectJDBC();
        con.insert(fd);
        //interest();
    }

    public void showAll(String accountNumber) {
        connectJDBC con = new connectJDBC();
        FixedAccount fd = new FixedAccount();

        con.showAllFD(accountNumber, fd);

    }

    public FixedAccount checkPin() {
        connectJDBC con = new connectJDBC();
        FixedAccount fd = new FixedAccount();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Reference number : ");
        String random = input.nextLine();
        while (!Pattern.matches("[0-9]{4}", random)) {
            System.out.println("Invalid refference number : ");
            random = input.nextLine();
        }

        fd = con.retriveFD(fd, Integer.parseInt(random));

        if (fd == null) {
            System.out.println("RD doesnot exxit");
            return null;
        } else {
            return fd;
        }
    }

    public void fixedAccount(String accountnum) {
        while (true) {
            System.out.println("Press 1-Create FD 2-Show All Deposit 3-View Details 4-Withdraw 5-logout");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            //choice validation
            switch (choice) {
                case 1:
                    CreateFd(accountnum);
                    break;
                case 2:
                    showAll(accountnum);
                    break;
                case 3:
                    viewDetails();
                    break;

                case 4:withdraw();
                    break;
                case 5:
                    System.out.println("\n\n####----Logged out Successfully----####");
                    return;

                default:
                    System.out.println("\n\nInvalid choice");
            }
        }
    }


    public void viewDetails() {
        FixedAccount random = new FixedAccount();
        random = checkPin();
        if (random != null) {
            System.out.println("--------------------------Your Details----------------------------");
            System.out.println("Your Reference Number         : " + random.getRefNum());
            System.out.println("Your FD creation Date         : " + random.getDepositDate());
            System.out.println("Your nominee                  : " + random.getNominee());
            System.out.println("Relationship with nomine      : " + random.getRelation());
            System.out.println("Your RD lifetime              : " + random.getDepositPeriod());
            System.out.println("Your initial Deposit          : " + random.getAccountBalance());
            System.out.println("Your intrest on Deposit       : " + interest(random));
            System.out.println("Your total amount(onMaturity) : " + (float)(random.getAccountBalance()+interest(random)));
            System.out.println("-----------------------------------------------------------------");
        }
    }
}

