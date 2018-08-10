import java.util.Scanner;
public class SimpleCalc {
    public static void main(String args[]) {
        double result = 0;
        char z;

        System.out.println("enter the first number");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()) {
            System.out.println("Invalid input\n Type the double-type number:");
            in.next();
        }
        double a = in.nextDouble();


        System.out.println("enter the second number");
        while (!in.hasNextDouble()) {
            System.out.println("Invalid input\n Type the double-type number:");
            in.next();
        }

        double b = in.nextDouble();
        boolean temp = false;
        char c;

        System.out.println("enter operator +,-,* or /");
        l1:
        do {
            do {
                c = in.next().charAt(0);
                if (c == '*' || c == '+' || c == '-' || c == '/') {
                    temp = true;
                    break;

                } else

                {
                    System.out.println("Invalid operator/n Enter valid operator");
                    continue;

                }

            } while (!temp);





        switch (c) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                try {
                    result = a / b;
                } catch (ArithmeticException e) {
                    System.out.println(e);
                }
                break;
            default:
                System.out.println("invalid operator");

        }
        System.out.println(a + "" + c + "" + b + "=" + result);

        System.out.println("do you want continue operation with same numbers  Y/N");
      l2:  do {
            z = in.next().charAt(0);
            if (z == 'Y' || z=='y' || z=='n' || z=='N') {
                //temp = true;
                break;
            } else

            {
                System.out.println("Invalid Character Enter either y/n");
                continue l2;

            }
        }while(true);


       // char z = in.next().charAt(0);
        if (z == 'Y' || z=='y') {
            System.out.println("enter the operator again +,-,* or /");
            continue l1;
        }
        else
        {
            break;
        }
    }while(true);


    }
}
