import model.ReceiptModel;
import model.RentModel;
import model.ReservationModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public ReceiptModel rentVehicle(RentModel model) {
        //TODO: figure out types
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO rent VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, model.getRid());
            ps.setInt(2, model.getVid());
            ps.setString(3, model.getCellNum());
            ps.setString(4, model.getFromDate());
            ps.setString(5, model.getToDate());
            ps.setString(6, model.getFromTime());
            ps.setString(7, model.getToDate());
            ps.setString(8, model.getToTime());
            ps.setString(9, model.getOdometer());
            ps.setString(10, model.getCardName());
            ps.setString(11, model.getExpDate());
            ps.setString(12, model.getConfNo());
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public ReservationModel getReservation(int confNo) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FROM reservation WHERE confNo = ?");
            if (rs.next()) {
                return new ReservationModel(   rs.getInt("confNo"),
                                                rs.getString("vtname"),
                                                rs.getString("cellphone"),
                                                rs.getString("fromDate"),
                                                rs.getString("fromTime"),
                                                rs.getString("toDate"),
                                                rs.getString("toTime"));
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return null;
    }

    public ReservationModel getReservation(String cellNum) {

    }

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

}
