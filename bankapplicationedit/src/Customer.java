
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public  class Customer extends Bank {
    String name, address, panNo,mobileNo;
    String adharNo,dateOfBirth;
    boolean temp3=false,temp1=false,temp2=false,temp4=false;
    Scanner in = new Scanner(System.in);

    public  void setName(String name)
    {
        this.name=name;

    }

    public void setAddress(String address1,String address2,String adress3) {
        this.address = address1 + "  " +address2+"  "+adress3;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNo()
    {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPanNo() {
        return panNo;
    }

    public String getAdharNo() {
        return adharNo;
    }


public void validatePan() {
    do {
        System.out.println("Enter PAN card number");
        Pattern pattern = Pattern.compile("[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}");
        String panNo = in.next();
        Matcher matcher = pattern.matcher(panNo);
        if (matcher.matches()) {
            setPanNo(panNo);
            temp3 = true;
        } else
            System.out.println("enter valid pan number");
    } while (!temp3);
}
public void validateMobileNo(){
    do {
        System.out.println("Enter valid 10 digit Mobile number ");
        Pattern pattern = Pattern.compile("\\d{10}");

        String mobileNo = in.next();
        Matcher matcher = pattern.matcher(mobileNo);

        if (matcher.matches()) {
            setMobileNo(mobileNo);
            temp1 = true;

        }
        else
            System.out.println("invalid mobile number");
    }while(!temp1);
}

    public void validateAdharNo(){
        do {
            System.out.println("Enter valid 12 digit adhar number ");
            Pattern pattern = Pattern.compile("\\d{12}");

            String adharNo = in.next();
            Matcher matcher = pattern.matcher(adharNo);

            if (matcher.matches()) {
                setAdharNo(adharNo);
                temp2 = true;

            }
            else
                System.out.println("invalid adhar number");
        }while(!temp2);
    }

    public  void validateDateOfBirth()
    {
      int date,year,month;

      System.out.println("enter date of birth ");
        do {
            System.out.println("enter year of born");
            while (!in.hasNextInt()) {
                System.out.println("invalid year \n enter born year");
                in.next();
            }
            year = in.nextInt();
        }while(year<1910 || year>=2018);


      do {
          System.out.println("enter born month");
          while (!in.hasNextInt())
          {
              System.out.println("invalid month enter month number");
              in.next();
          }

          month = in.nextInt();
      } while(month<=0 || month>12);


       do {
           System.out.println("enter date ");
           while (!in.hasNextInt()) {
               System.out.println("invalid date");
               in.next();
           }
           date = in.nextInt();
       }while (date<0 || date>31 || (date>30 && (month==2 || month==4 || month==6 || month==9 || month==11)) || (date>29 && month==2) || (date>28 && month==2 && year%4!=0));



        dateOfBirth=Integer.toString(date)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        setDateOfBirth(dateOfBirth);
        int age=2018-year;
        System.out.println("age="+age);


        }



}