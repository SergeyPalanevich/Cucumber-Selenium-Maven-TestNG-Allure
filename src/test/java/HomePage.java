import com.epam.bdd.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;

public class HomePage extends BasePage{
    private static final String url = "https://www.ebay.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-ac")
    public Element searchField;

    @FindBy(xpath = "//input[@type='submit']")
    public Element searchButton;

    public void open() {
        driver.get(url);
        waitForJSLoadComplete();

    }

    public void setCritetia(String query) {
        searchField.sendKeys(query);
    }

    public ResultPage runSearch() {
        searchButton.click();
        return new ResultPage(getDriver(CHROME));
    }
}
