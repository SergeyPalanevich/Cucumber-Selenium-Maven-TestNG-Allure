import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;

public class ResultPage extends BasePage{

    @FindBy(xpath = "//ul[@id='ListViewInner']/li[1]/h3")
    public WebElement firstProduct;

    @FindBy(xpath = "//input[@value='LH_BIN']")
    public WebElement buyNowRadio;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectFirstProduct() {
        moveToMyElement( getDriver(CHROME), buyNowRadio);
        waitForJSLoadComplete();
        buyNowRadio.click();
        moveToMyElement( getDriver(CHROME), firstProduct);
        firstProduct.click();
        return new ProductPage(getDriver(CHROME));
    }
}
