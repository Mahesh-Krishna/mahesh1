import java.util.Scanner;
public class book2 {


    public void createbook(String bookTitle,float price,book c)
    {

            c.setBookTitle(bookTitle);
            c.setPrice(price);


    }

    void showbook(book c)
    {

        //d.get_book_title();
        //2
        //d.get_price();
        System.out.println("book_details  " + c.getBookTitle());
        System.out.println(c.getPrice());


    }


    public static void main(String[] args)
    {
        book2 z=new book2();
        book c=new book();
        //book d=new book();

        Scanner in = new Scanner(System.in);
        System.out.println("enter the number of books");
        int numberOfBooks = in.nextInt();

        book a[]=new book[numberOfBooks];

        for(int i=0;i<=a.length;i++)
        {

            System.out.println("enter the title of book");
            Scanner ino = new Scanner(System.in);
            String m=ino.nextLine();

            System.out.println("enter the price");
            Float n=ino.nextFloat();



           // a[i]=new book();
            z.createbook(m,n,c);
            z.showbook(c);

            }
     //   z.createbook(a,l);
       // z.showbook(a,l);




    }

}





