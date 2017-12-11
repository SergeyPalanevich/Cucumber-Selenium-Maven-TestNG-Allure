import com.epam.bdd.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "isCartBtn_btn")
    public Element addToCartButton;

    @FindBy(id = "gh-cart-i")
    public Element Cart;


    public void addToCart() {
        waitElementToBeClickable(getDriver(CHROME) , addToCartButton);
        addToCartButton.click();
    }

    public CartPage openCart() {
        waitElementToBeClickable(getDriver(CHROME) , Cart);
        Cart.click();
        return new CartPage(getDriver(CHROME));

    }
}
