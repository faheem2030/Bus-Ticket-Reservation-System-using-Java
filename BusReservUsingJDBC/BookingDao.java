package BusReservUsingJDBC;

import java.util.Date;
import java.sql.*;

public class BookingDao {

    public int getBookedCount(int busNo, Date date) throws SQLException {
        // Fixed query: Added = ? for travel_date and removed space in count()
        String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        // Set query parameters
        pst.setInt(1, busNo);
        pst.setDate(2, sqldate);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "insert into booking values(?,?,?)";

        Connection con = DBConnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);

        // Set query parameters
        pst.setString(1, booking.PassengerName);
        pst.setInt(2, booking.Busno);
        pst.setDate(3, sqldate);

        pst.executeUpdate();
    }
}
