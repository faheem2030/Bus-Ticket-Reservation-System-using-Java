package BusReservUsingJDBC;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws ParseException, SQLException {
        Scanner sc = new Scanner(System.in);
        boolean repeat=true;
        //Title
        System.out.println("\t\t\t\t*****************");
        System.out.println("\t\t\t\t*Bus Reservation*");
        System.out.println("\t\t\t\t*****************");
        System.out.println();
        System.out.println("\t\t\t\tWelcome to MFBus ");
        System.out.println();
        //Bus Object
        BusDAO busDao = new BusDAO();
        busDao.displayBusInfo();




        //Booking details



        do{
            System.out.println();
            System.out.println("1.Book Ticket....");
            System.out.println("2.Exit...........");
            System.out.println("Enter: ");
            int userOpt = sc.nextInt();
            if(userOpt==1){
                Booking book = new Booking();
                if (book.isAvailable()){
                    BookingDao bookdao = new BookingDao();
                    bookdao.addBooking(book);
                    System.out.println("Booking has been done successfully");
                }
                else{
                    System.out.println("oops!Sorry, The bus is full");
                }
                System.out.println();
            }
            else{
                System.out.println("Thanking for using MF bus.Have a safe and beautiful journey");
                repeat=false;
            }
        }while(repeat);
        sc.close();

    }
}
