package Handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    public static String dburl = "jdbc:mysql://mysql59.unoeuro.com:3306/vampire_live_dk_db_g16cdio1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String dbusername = "vampire_live_dk";
    public static String dbpassword = "b2h4k9gc";

    public static Connection connect() throws SQLException {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            return DriverManager.getConnection(dburl, dbusername, dbpassword);
    }
}
