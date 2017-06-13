package demo.util;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by zhenya.1291813139.com
 * on 2017/6/13.
 * stuentExcel.
 */
public class Db {
    private static final String URL = "jdbc:mysql:///?user=root&password=system";
    public static Connection getConnection(){
        try {
            new Driver();
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(PreparedStatement resultSet, ResultSet preparedStatement, Connection connection){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
