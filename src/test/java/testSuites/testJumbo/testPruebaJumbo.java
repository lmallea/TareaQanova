package testSuites.testJumbo;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.pruebaJumbo.JumboProbando;

public class testPruebaJumbo {
    @BeforeMethod
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("propiedades.properties").getProperty("url7"));
    }
    @AfterMethod
    public void tearDown() {
        DriverContext.closeDriver();
    }
    @Test
    public void ejecutando() {
        JumboProbando jumboProbando = new JumboProbando();
        jumboProbando.ejcutandoBusqueda();
        jumboProbando.insertando();
    }
}
