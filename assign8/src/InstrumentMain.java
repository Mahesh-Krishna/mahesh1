
//import javax.sound.midi.Instrument;
import java.util.*;
public class InstrumentMain {
    public static void main(String args[]) {
        Instrument a[] = new Instrument[10];


        for (int i = 0; i < 10; i++) {
            if(i==1 || i==3 || i==5)
            {
                a[i] = new Piano();

            }
            else if(i==0 || i==2 || i==4)
            {
                a[i] = new Flute();

            }
            else
            {
                a[i] = new Guitar();
            }
            a[i].play();


           if(a[i] instanceof Piano)
           {
               System.out.println("index "+i+ "is instance of Piano");
           }
            else if(a[i] instanceof Flute)
            {
                System.out.println("index "+i+" is instance of Flute");
            }
            else if(a[i] instanceof Guitar)
            {
                System.out.println("index "+i+" is instance of Guitar");
            }

        }
    }
}