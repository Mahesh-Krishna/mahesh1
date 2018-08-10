import java.util.Random;
public class TestMedicine {
    public static void main(String args[])
    {
        Medicine medicine[]=new Medicine[10];
        Random rand=new Random();
        int n=rand.nextInt(3)+1;
        System.out.println("random number generated= "+n);

        if(n==1)
        {
            medicine[1]=new Tablet();
        }
        else if(n==2)
        {
            medicine[2]=new Syrup();
        }
        if(n==3)
        {
            medicine[3]=new Ointment();
        }

        medicine[n].displayLabel();
    }
}
