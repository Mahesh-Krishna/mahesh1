package inher_1;
import java.util.Scanner;

public class Base {
    private String name, num;
    public int max, count;
    public String[] list;

    Base() {
        max = 5;
        count = 0;
        list = new String[max];
    }

    Base(int h) {
        max = h;
        count = 0;
        list = new String[max];
    }

    Scanner sc = new Scanner(System.in);

    public void add() {
        if (count < max) {
            System.out.println("enter the name ");
            name = sc.nextLine();
            System.out.println("enter the number ");
            num = sc.nextLine();
            list[count] = name + " " + num;
            count++;
        } else
            System.out.println("sorry, max contact already filled ");
    }




    public String toString() {
        System.out.println("name    num");
        String temp = "";
        for (int i = 0; i < count; i++) {
            temp = temp + " " + list[i]+"\n";
        }
        return temp;
    }


}
