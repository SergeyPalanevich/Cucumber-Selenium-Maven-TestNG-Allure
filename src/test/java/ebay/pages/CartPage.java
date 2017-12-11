package ebay.pages;

import com.epam.bdd.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-cart-n")
    public Element summary;

    private static final String itemsInCart = "1";

    public boolean productIsDispayed() {
        return summary.getText().contains(itemsInCart);
    }
}
