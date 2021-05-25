package baseDeDatos;

import java.sql.*;
import java.util.ArrayList;


public class ConsutaSku {
    //METODO PARA HACER UNA CONSULTA A LA BASE DE DATOS
    public static ArrayList<String> consulta(String query) {
       ArrayList<String> sku = new ArrayList();
       Connection connection = null;
       try {
               Connection con = ConexionJumbo.conectar();
               Statement statement = con.createStatement();
               statement.setQueryTimeout(35);
               ResultSet rs = statement.executeQuery(query);

              while (rs.next()) {
                  sku.add(rs.getString("SKU"));
              System.out.println(sku);
              }
            con.close();
           }catch (SQLException | ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
     return sku;
   }
}
