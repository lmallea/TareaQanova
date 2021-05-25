package baseDeDatos;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultaID {
    //METODO PARA HACER UNA CONSULTA A LA BASE DE DATOS
    public static ArrayList<String> consultaId(String query) {
        ArrayList<String> id = new ArrayList();
        Connection connection = null;
        try {
            Connection con = ConexionJumbo.conectar();
            Statement statement = con.createStatement();
            statement.setQueryTimeout(35);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                id.add(rs.getString("ID"));
                System.out.println(id);
            }
            con.close();
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
}

