public class SportCar extends Car {

    void airBallonType()
    {
        double initialSpeed=1;
        int gearStatus=1;


        System.out.println("initial speed in kmph= "+initialSpeed);
        System.out.println("gear status= "+gearStatus);

    }


    void display()
    {
       super.display();

    }
    public static void main(String args[])
    {
        SportCar sportCar=new SportCar();
        sportCar.airBallonType();

        sportCar.drive();
        sportCar.display();

    }
}
