
public class Date
{

    int date;
    int month;
    int year;

   /* Date()
    {
        date=1;
        month=2;
        year=2000;
    }*/

    Date(int d,int m,int y)
    {
        date=d;
        month=m;
        year=y;



        if(month<1 || month >12)
        {
            System.out.println("invalid month");
        }
        else
        {
        if((month ==1) || (month ==3) || month==5 || month==7 || month==8 || month==10 || month==12)
        {
            if(date<1 || date>31)
            {
                System.out.println("inavalid date");
            }
        }
        else if(month==4 || month==6 || month==9 || month==11)
        {
            if(date<1 || date>30)
            {
                System.out.println("invalid date");
            }
        }
        else
        {
            if((year%4==0)&& date<1 || date>29)
            {
                System.out.println("invalid date");
            }

            else if(date<1 || date>28)
           {
                System.out.println("invalid date");
            }
        }
    }

    }
void change(int a)
{
  int dd=date+a;
  if(dd>30 &&  month==4 || month==6 || month==9 || month==11)
  {
      month++;
      date=dd% 30;
  }
  else if(dd>31 && month ==1 || (month ==3) || month==5 || month==7 || month==8 || month==10 )
    {
        month++;
        date=dd% 31;
    }

    else if(dd>31 && month==12)
  {
      month=1;
      year++;
      date=date% 31;
  }

/*  else if((dd>28) && (month=2))
  {
      month++;
      date=date% 28;
  }

  else if(dd>29 && month=2)
  {
      month++;
      date=date %29;
  }
*/

  else
      {
      date = dd;

  }
  System.out.println(date+" "+month+" "+year);
}


}
