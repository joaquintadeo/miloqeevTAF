package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.clickElement;
import static UI.element.pageShouldContainElement;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.cart.*;
import static prestashop.login.BASE_URL;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class emptyCartTest {
    @Given("User adds product")
    public void userAddsProduct() {
        createTest("Empty cart", "Empty cart with one product", "User adds product");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        addProductToCart(FRAMED_POSTER);
    }

    @When("User attempts to empty cart")
    public void userAttemptsToEmptyCart() {
        createTestStep("When", "User attempts to empty cart");
        goTo(CART_URL);
        waitUntilPageContainsElement(DELETE_BTN, 10);
        emptyCart();
    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        createTestStep("Then", "Cart should be empty");
        pageShouldContainElement(NO_ITEMS);
        closeBrowser();
    }

    @Given("User adds multiple products")
    public void userAddsMultipleProducts() {
        createTest("Empty cart", "Empty cart with one product", "User adds product");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        addProductToCart(FRAMED_POSTER);
        clickElement(CONTINUE_SHOPPING_BTN);
        addProductToCart(MUG);
    }
}
