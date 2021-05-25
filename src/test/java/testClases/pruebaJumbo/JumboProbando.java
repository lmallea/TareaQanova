package testClases.pruebaJumbo;

import Utils.DriverContext;
import Utils.ReadProperties;
import baseDeDatos.InsertarBD;
import pages.jumbo.GuardarDatos;
import pages.jumbo.RecopilacionDeDatos;

import java.util.ArrayList;

import static baseDeDatos.ConsultaID.consultaId;
import static baseDeDatos.ConsutaSku.consulta;

public class
JumboProbando {
    String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url7");
    ArrayList<String> sku1 = new ArrayList();
    ArrayList<String> skuId = new ArrayList();
    String precios;
    ArrayList<String> preciosTodos = new ArrayList();
    public void ejcutandoBusqueda() {
        RecopilacionDeDatos recopilacionDeDatos = new RecopilacionDeDatos();
        GuardarDatos guardarDatos = new GuardarDatos();
        sku1 = consulta("SELECT \n" + "ti.Nombre, ti.Web , prod.Nombre , s.SKU, s.ID from glowecoi_test.producto prod, glowecoi_test.tienda ti, glowecoi_test.sku s\n" + "where\n" + "s.Tienda = ti.ID AND \n" + "s.Producto = prod .ID AND \n" + "ti.ID = 2");
        for (int i = 0; i < sku1.size(); i++) {
            recopilacionDeDatos.buscando(sku1.get(i));
            precios = guardarDatos.guardando();
            preciosTodos.add(String.valueOf(precios));
            System.out.println(precios);
            DriverContext.getDriver().navigate().to(url);
        }
    }
    public void insertando(){
        InsertarBD insertarBD = new InsertarBD();
        skuId = consultaId("SELECT \n" + "ti.Nombre, ti.Web , prod.Nombre , s.SKU, s.ID from glowecoi_test.producto prod, glowecoi_test.tienda ti, glowecoi_test.sku s\n" + "where\n" + "s.Tienda = ti.ID AND \n" + "s.Producto = prod .ID AND \n" + "ti.ID = 2");
        for (int i = 0; i<7; i++) {
            insertarBD.insetarDatos("insert into precio(SKU, Precio) values (" + skuId.get(i) + ", " + preciosTodos.get(i) + ")");
        }

    }

}
