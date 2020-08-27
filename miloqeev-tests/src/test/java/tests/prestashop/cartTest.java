package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.browserManagement.goTo;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.login.BASE_URL;
import static testListeners.extentReportListener.createTest;
import static prestashop.cart.*;
import static testListeners.extentReportListener.createTestStep;

public class cartTest {
    @Given("User finds product on quick view")
    public void userFindsProductOnQuickView() {
        createTest("Add product to cart", "From quick view", "User finds product on quick view");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        inputTextAndSubmit(SEARCH_INP, "The best is yet to come' Framed poster");
        waitUntilPageContainsElement(FIRST_ELEMENT_IMG);
    }

    @When("User attempts to add to cart")
    public void userAttemptsToAddToCart() {
        createTestStep("When", "User attempts to add to cart");
        mouseOver(FIRST_ELEMENT_IMG);
        clickElement(QUICK_VIEW_A);
        waitUntilPageContainsElement(ADD_TO_CART_DIV);
        clickElement(ADD_TO_CART_DIV);
    }

    @Then("Product should be added to cart")
    public void productShouldBeAddedToCart() {
        createTestStep("Then", "Product should be added to cart");
        waitUntilPageContainsElement(PROD_ADDED_TXT, 10);
        pageShouldContainElement(PROD_ADDED_TXT);
        closeBrowser();
    }

    @Given("User finds product")
    public void userFindsProduct() {
        createTest("Add product to cart", "From full view", "User finds product");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        inputTextAndSubmit(SEARCH_INP, "The best is yet to come' Framed poster");
        waitUntilPageContainsElement(FIRST_ELEMENT_IMG);
    }

    @When("User selects and adds to cart")
    public void userSelectsAndAddsToCart() {
        createTestStep("When", "User selects and adds to cart");
        clickElement(FIRST_PRODUCT_A);
        waitUntilPageContainsElement( ADD_TO_CART_BTN);
        clickElement(ADD_TO_CART_BTN);
    }
}
