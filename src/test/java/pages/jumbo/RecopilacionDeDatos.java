package pages.jumbo;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.Validaciones.validarObjeto;

public class RecopilacionDeDatos {
    public RecopilacionDeDatos() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(xpath = "//*[@class = 'new-header-search-input']")
    WebElement lineaDeBuscar;
    @FindBy(xpath = "//*[@class = 'new-header-search-submit']")
    WebElement buscador;

    public void buscando(String sku) {
        validarObjeto(lineaDeBuscar, "Linea donde se coloca lo que desea buscar");
        lineaDeBuscar.clear();
        lineaDeBuscar.sendKeys(sku);
        validarObjeto(buscador, "Click en buscar");
        buscador.click();
    }
}
