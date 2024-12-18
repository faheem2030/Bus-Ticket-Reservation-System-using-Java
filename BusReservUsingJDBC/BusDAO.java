package BusReservUsingJDBC;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
    public void displayBusInfo()throws SQLException {
        String query="select * from bus";
       Connection con =  DBConnection.getConnection();
        Statement st =con.createStatement();
        ResultSet re =st.executeQuery(query);
        while(re.next()){
            System.out.println("*----------------------------------------*");
            System.out.print("Bus NO: "+ re.getInt(1));
            if(re.getInt(2)==0){
                System.out.print("  AC: NO");
            }
            else{
                System.out.print(" AC: Yes");
            }
            System.out.println("  Capacity: "+re.getInt(3));
            System.out.println("*----------------------------------------*");
        }
        System.out.println("*-----------------------------------------------------------------------*");
    }
    public int getCapacity(int id ) throws SQLException{
        String query = "Select capacity from bus where id="+id;
        Connection con = DBConnection.getConnection();
        Statement st =con.createStatement();
        ResultSet re =st.executeQuery(query);
        re.next();
        return re.getInt(1);
    }
}
