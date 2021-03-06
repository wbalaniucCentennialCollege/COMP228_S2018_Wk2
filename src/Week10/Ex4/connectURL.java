package Week10.Ex4;

import java.sql.*;

public class connectURL {
    public static void main(String[] args) {
        String connectionURL = "jdbc:sqlserver://localhost:1433;database=Games;integratedSecurity=true"; // Using windows authentication

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establishing a connection to your database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionURL);

            // Create and execute an SQL statement that returns some data
            String SQL = "SELECT * FROM Game";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while(rs.next()) {
                System.out.println(rs.getString("game_name") + " " + rs.getString("game_desc") + " $" + rs.getDouble("game_price"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                }
                catch (Exception e) { }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {}
            }
            if(con != null) {
                try {
                    con.close();
                }
                catch (Exception e) {}
            }
        }
    }
}
