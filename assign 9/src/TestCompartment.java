import java.util.Random;
public class TestCompartment {
public static void main(String args[])
{
    Compartment a[]=new Compartment[10];

    Random rand = new Random();

    int  n = rand.nextInt(4)+1 ;
    System.out.println(("random number generated="+n));
    if(n==1)
    {
        a[1]=new FirstClass();
    }
    else if (n==2)
    {
        a[2]=new Ladies();
    }
    else if(n==3)
    {
        a[3]=new General();
    }
    else if (n==4)
    {
        a[4]=new Luggage();
    }
    a[n].notice();
}
}
