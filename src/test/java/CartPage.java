import com.epam.bdd.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='pb15']")
    public Element cart;


    public String getCartCount() {
        waitForJSLoadComplete();
        return cart.getText();
    }
}
