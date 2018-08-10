//import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import  java.util.logging.Level;


public class connectJDBC {


    public boolean insert(Object o) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass()).addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();


            //  System.out.println("done!!");
            return true;
        }

        catch (Exception e) {
           // System.out.println("Error while connecting");
            e.printStackTrace();
            return false;
        }

        finally {
            factory.close();

        }

    }

    public Details retrive(Object o,String accountNumber) {



        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            Details d=new Details();
            d=(Details)session.get(o.getClass(),accountNumber);
            // session.save(o);

            session.getTransaction().commit();

            //System.out.println("done!!");
            return d;
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        finally {
            factory.close();
        }

    }

    public void statement(String acconum,Object o) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query =  session.createQuery("Select t FROM Transaction t where accountNumber=?1").setParameter(1,acconum);
            List<Transaction> results = ((org.hibernate.query.Query) query).list();
            System.out.println("--------------------------STATEMENT------------------------------------------");
            System.out.println("Date       | Transaction Type |  Amount  | NewBalance ");
            for (Transaction t: results
            ) {

                System.out.println(t.getTransactionDate()+"\t\t"+t.getTransactionType()+"\t\t"+String.format("%.2f",t.getTransactionAmount()) +"\t\t"+String.format("%.2f",t.getBalance()) );
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }

    }

    public void showAllRD(String accountNumber,Object o) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query =  session.createQuery("Select rd FROM RecurringAccount  rd where accountNumber=?1").setParameter(1,accountNumber);
            List<RecurringAccount> results = ((org.hibernate.query.Query) query).list();

            System.out.println("--------------------------YOUR RD DETAILS----------------------------------------");
            System.out.println("ReferenceNumnber | CreationDate | DepositePerios | initialDeposite | NewBalance ");
            for (RecurringAccount rd: results
                 ) {

                System.out.println(rd.getReferenceNumber()+"\t\t"+rd.getCreationDate()+"\t\t"+rd.getDepositPeriod()+"\t\t"+rd.getInitialDeposit()+"\t\t"+rd.getBalance());
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }

    }

    public void showAllFD(String accountNumber,Object o) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Query query =  session.createQuery("Select fd FROM FixedAccount fd where accountNumber=?1").setParameter(1,accountNumber);
            List<FixedAccount> results = ((org.hibernate.query.Query) query).list();

            System.out.println("--------------------------YOUR RD DETAILS----------------------------------------");
            System.out.println("ReferenceNumnber | CreationDate | DepositePeriod | DepositeAmount ");
            for (FixedAccount fd: results
                 ) {

                System.out.println("\t"+fd.getRefNum()+"\t\t\t"+fd.getDepositDate()+"\t\t"+fd.getDepositPeriod()+"\t\t\t\t"+fd.getAccountBalance());
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }

    }

    public RecurringAccount retriveRD(Object o,int accountNumber) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            RecurringAccount d=new RecurringAccount();
            d=(RecurringAccount) session.get(o.getClass(),accountNumber);
            // session.save(o);
            session.getTransaction().commit();
            //System.out.println("done!!");
            return d;
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        finally {
            factory.close();
        }

    }

    public FixedAccount retriveFD(Object o,int accountNumber) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            FixedAccount d=new FixedAccount();
            d=(FixedAccount) session.get(o.getClass(),accountNumber);
            // session.save(o);
            session.getTransaction().commit();
            //System.out.println("done!!");
            return d;
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        finally {
            factory.close();
        }

    }

    public Details update(Object o,String accountNumber) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Details d=new Details();
            session.update(o);
            session.getTransaction().commit();
            //System.out.println("done!!");
            return d;
        }

        catch (Exception e) {
             e.printStackTrace();
            //System.out.println("error");
            return null;
        }

        finally {
            factory.close();

        }

    }

    public RecurringAccount update(Object o,int accountNumber) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(o.getClass())
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            RecurringAccount d=new RecurringAccount();
            session.update(o);
            session.getTransaction().commit();
            //System.out.println("done!!");
            return d;
        }

        catch (Exception e) {
             e.printStackTrace();
            //System.out.println("error");
            return null;
        }

        finally {
            factory.close();

        }

    }


}