public class Employee {
    int number;
    String name;
    String date;


    Employee() {
        number = 1;
        name = "m";
        date = "6/7/18";

    }

    void setNumber(int a) {
        number = a;
    }

    void setName(String b) {
        name = b;
    }

    void setDate(String c) {
        date = c;

    }

    int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }

    String getDate() {
        return date;
    }

}