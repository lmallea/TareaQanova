package pages.jumbo;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class GuardarDatos {
    public GuardarDatos() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }
    @FindBy(xpath = "//*[@class = 'product-single-price-container']")
    private WebElement precio;
    public String guardando() {
        String listPrecios;
        esperar(5);
        if (validarObjeto(precio, "Precio del producto")) {
            String precio1 = precio.getText();
            String[] parts = precio1.split("\\(");
            String part1 = parts[0];
            String precioBien = part1.replace("$", "").replace(".", "").trim();
            listPrecios = precioBien;
        } else {
            listPrecios = "0";
        }
        return listPrecios;
    }
}
