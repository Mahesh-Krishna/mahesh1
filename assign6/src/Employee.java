
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Employee {
    int number;
    String name;
    String date;


    Employee() {
        this.number = 1;
        this.name = "m";
        this.date = "06.07.2018";

    }

    void setNumber(int a)
    {
        this.number = a;
    }

    void setName(String b)
    {
        this.name = b;
    }

    void setDate(String c)
    {

        this.date = c;

    }

    int getNumber()
    {
        return this.number;
    }

    String getName() {
        return this.name;
    }

    String getDate() {
        return this.date;
    }

}