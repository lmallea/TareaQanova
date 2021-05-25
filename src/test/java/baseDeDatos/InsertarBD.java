package baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarBD {
    ConexionJumbo conexion = new ConexionJumbo();
    //METODO PARA HACER INSERCIONES Y CAMBIOS EN UNA BASE DE DATOS
    public void insetarDatos(String queryInsertar){
        try{
            Connection con = ConexionJumbo.conectar();
            PreparedStatement pst = con.prepareStatement(queryInsertar);
            pst.executeUpdate(queryInsertar);
            con.close();
            pst.close();
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
