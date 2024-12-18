package BusReservUsingJDBC;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Booking {
    String PassengerName;
    int Busno;
    Date date;

    public Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the Passenger: ");
        this.PassengerName=sc.next();
        System.out.print("Enter the Bus No: ");
        this.Busno =sc.nextInt();
        System.out.print("Enter the Date:(dd-mm-yyyy) ");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            this.date=dateFormat.parse(dateInput);
        }catch(ParseException e){
            e.printStackTrace();
        }

    }

    public boolean isAvailable() throws SQLException {
        BusDAO budsdao=new BusDAO();
        BookingDao bookDao = new BookingDao();
        int capacity=budsdao.getCapacity(Busno);
        int count =bookDao.getBookedCount(Busno,date);


        return count<capacity?true:false;
    }
    public String toString() {
        return "Passenger Name: " + PassengerName +
                ", Bus No: " + Busno +
                ", Date: " + new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

}
