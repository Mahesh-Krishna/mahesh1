import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Security security=new Security();
        String en=security.encryption("12@xM");
        System.out.println(en);

        String en1=security.decryption("45C{P");
        System.out.println(en1);




        Scanner sc = new Scanner(System.in);
        int choice;
        Validation v = new Validation();
        BankOperation b = new BankOperation();
        RecurringAccount r=new RecurringAccount();
        FixedAccount f=new FixedAccount();

        while (true) {
            System.out.println("Press 1-CreateAccount 2-Existing_account 3-exit");

            String str = sc.next();
            choice = v.choiceValidation(str);
            switch (choice) {
                case 1:
                    b.createAccount();
                    break;

                case 2:
                    boolean flag = true;
                    while (flag) {
                        System.out.println("\n\n******Slect Account Type******");
                        System.out.println("1-Savings_account 2-Current_account 3-Reccuring_account 4-Fixed_account 5-Go_back 6-exit");

                        str = sc.next();
                        choice = v.choiceValidation(str);
                        switch (choice) {
                            case 1:
                            case 2:
                                String accountnum = b.checkAccount();
                                if (accountnum != null) {
                                    b.functionality(accountnum);
                                    flag = false;
                                }
                                break;
                            case 3:
                                accountnum = b.checkAccount();
                                if (accountnum != null) {
                                    r.recurringAccount(accountnum);
                                    flag = false;
                                }
                                break;
                            case 4:
                                accountnum = b.checkAccount();
                                if (accountnum != null) {
                                    f.fixedAccount(accountnum);
                                    flag = false;
                                }
                                break;

                            case 5:
                                flag = false;
                                break;
                            case 6:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid Choice\n");
                                break;
                        }
                    }

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice\n");
                    break;
            }
        }
    }
}

