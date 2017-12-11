import com.epam.bdd.core.ui.CustomFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;

public class BasePage {

    private static final int DRIVER_TIMEOUT = 25;

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        waitForJSLoadComplete();
    }

    protected boolean waitForJSLoadComplete() {
        WebDriverWait wait = new WebDriverWait(getDriver(CHROME), getDriverTimeout());

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) (getJSExecutor(driver)).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (getJSExecutor(driver)).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        boolean jQuery = wait.until(jQueryLoad);
        boolean js = wait.until(jsLoad);
        return jQuery && js;
    }

    protected long getDriverTimeout() {
        return DRIVER_TIMEOUT;
    }

    protected JavascriptExecutor getJSExecutor(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    protected void waitElementToBeClickable(WebDriver driver, WebElement element) {
        waitForJSLoadComplete();
        (new WebDriverWait(driver, getDriverTimeout()))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void moveToMyElement(WebDriver driver, WebElement element) {
        waitForJSLoadComplete();
        new Actions(driver).moveToElement(element).perform();
    }
}
