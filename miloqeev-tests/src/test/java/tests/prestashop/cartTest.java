package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.closeBrowser;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static testListeners.extentReportListener.createTest;
import static prestashop.cart.*;
import static testListeners.extentReportListener.createTestStep;

public class cartTest {
    @Given("User finds product on quick view")
    public void userFindsProductOnQuickView() {
        createTest("Add product to cart", "From quick view", "User finds product on quick view");
        userLogIn();
        inputTextAndSubmit("name", SEARCH_INP, "The best is yet to come' Framed poster");
        waitUntilPageContainsElement("xpath", FIRST_ELEMENT_IMG);
    }

    @When("User attempts to add to cart")
    public void userAttemptsToAddToCart() {
        createTestStep("When", "User attempts to add to cart");
        mouseOver("xpath", FIRST_ELEMENT_IMG);
        clickElement("xpath", QUICK_VIEW_A);
        waitUntilPageContainsElement("xpath", ADD_TO_CART_DIV);
        clickElement("xpath", ADD_TO_CART_DIV);
    }

    @Then("Product should be added to cart")
    public void productShouldBeAddedToCart() {
        createTestStep("Then", "Product should be added to cart");
        waitUntilPageContainsElement("xpath", PROD_ADDED_TXT);
        pageShouldContainElement("xpath", PROD_ADDED_TXT);
        closeBrowser();
    }

    @Given("User finds product")
    public void userFindsProduct() {
        createTest("Add product to cart", "From full view", "User finds product");
        userLogIn();
        inputTextAndSubmit("name", SEARCH_INP, "The best is yet to come' Framed poster");
        waitUntilPageContainsElement("xpath", FIRST_ELEMENT_IMG);
    }

    @When("User selects and adds to cart")
    public void userSelectsAndAddsToCart() {
        createTestStep("When", "User selects and adds to cart");
        clickElement("xpath", FIRST_PRODUCT_A);
        waitUntilPageContainsElement("xpath", ADD_TO_CART_BTN);
        clickElement("xpath", ADD_TO_CART_BTN);
    }
}
