package com.epam.bdd.steps;

import com.epam.bdd.pages.CartPage;
import com.epam.bdd.pages.HomePage;
import com.epam.bdd.pages.ProductPage;
import com.epam.bdd.pages.ResultPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.bdd.core.drivers.DriverManager.closeDriver;
import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;


public class AddToCartStep {
    private HomePage homepage;
    private ResultPage resultpage;
    private ProductPage productpage;
    private CartPage cartpage;

    @Given("^User navigates to Ebay page$")
    public void givenUserNavigatesToEbayPage() {
        homepage = new HomePage(getDriver());
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

    @And("^User add the product to cart$")
    public void userAddToCartTheProduct() {
        cartpage = productpage.addToCart();
    }

    @Then("^Product count in cart should be (\\d+)$")
    public void productCountInCartShouldBe(int count) {
        assertTrue(cartpage.getCartCount().contains(String.valueOf(count)));
    }

    @After
    public void terrDown() {
        closeDriver();
    }
}
