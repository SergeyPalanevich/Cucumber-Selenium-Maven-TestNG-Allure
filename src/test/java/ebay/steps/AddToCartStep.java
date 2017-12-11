package ebay.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.pages.CartPage;
import ebay.pages.HomePage;
import ebay.pages.ProductPage;
import ebay.pages.ResultPage;

import static com.epam.bdd.core.drivers.DriverManager.closeDriver;
import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static com.epam.bdd.core.drivers.DriverTypes.CHROME;
import static org.testng.AssertJUnit.assertTrue;


public class AddToCartStep {
    private HomePage homepage;
    private ResultPage resultpage;
    private ProductPage productpage;
    private CartPage cartpage;


    @Given("^User navigates to Ebay page$")
    public void userNavigatesToEbayPage() {
        homepage = new HomePage(getDriver(CHROME));
        homepage.open();
    }

    @When("^User enter search criteria as \"([^\"]*)\"$")
    public void userEnterSearchCriteria(String query) {
        homepage.setCritetia(query);
    }

    @And("^User click on the Search button$")
    public void userClickOnSearchButton() {
        resultpage = homepage.runSearch();
    }

    @And("^User select first product$")
    public void userSelectFirstProduct() {
        productpage = resultpage.selectFirstProduct();
    }

    @And("^User add to cart the product$")
    public void userAddToCartTheProduct(){
        productpage.addToCart();
    }

    @And("^User open cart$")
    public void userOpenCart(){
        cartpage = productpage.openCart();
    }

    @Then("^Product is displayed in cart$")
    public void productIsDisplayedInCart(){
        assertTrue(cartpage.productIsDispayed());
        closeDriver();
    }
}
