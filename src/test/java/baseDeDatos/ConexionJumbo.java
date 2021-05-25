package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJumbo {
    private static Connection con = null;
    public static Connection conectar() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://201.148.104.54:3306/glowecoi_test", "glowecoi_user", "jp}w+uMqc4n+");

        } catch (ClassNotFoundException | SQLException e) {
            throw new ClassNotFoundException(e.getMessage());
        }
        return con;
    }
}
