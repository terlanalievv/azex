package az.azex.repository;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {

    public static DataSource getDataSource() {
        InitialContext cxt = null;
        DataSource ds = null;
        try {
            cxt = new InitialContext();
            ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting azex datasource");
        }

        return ds;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection connection) {
        try {
            if(rs != null) {
                rs.close();
            }

            if(ps != null) {
                ps.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
