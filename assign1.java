import java.util.Scanner;
 
class assign1
{
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n= in.nextInt();
        System.out.println("entered value "+n);
        int i;
        System.out.println("even numbers are");
        for(i=0;i<n;i=i+2)
        {
          System.out.println(" "+i);

        }
      
        
        
        
    }
}

