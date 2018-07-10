package inher_1;
import java.util.Scanner;

public class Derived extends Base{

    Derived  (int n){
        super(n);
    }

    public void search(String z){
        for(int e=0 ;e<count;e++){

            String[] arr=list[e].split(" ");
            if(z.equalsIgnoreCase(arr[0])){
                System.out.println("contact found \nname : " + arr[0] + " num : " + arr[1]);
                return;
            }
        }
        System.out.println("contact not found");
    }

}