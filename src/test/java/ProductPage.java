import com.epam.bdd.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@role='button' and @vib='vib' and @id='isCartBtn_btn']")
    public Element addToCartButton;


    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(getDriver(CHROME));
    }
}
