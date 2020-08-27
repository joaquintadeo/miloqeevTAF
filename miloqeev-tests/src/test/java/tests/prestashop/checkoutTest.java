package tests.prestashop;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.browserManagement.setBrowserImplicitWait;
import static UI.element.*;
import static UI.listElement.selectFromListByValue;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.cart.MUG;
import static prestashop.cart.addProductToCart;
import static prestashop.checkout.*;
import static prestashop.login.BASE_URL;
import static prestashop.login.userLogIn;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class checkoutTest {
    @Given("User is logged in")
    public void userIsLoggedIn() {
        createTest("User Checkout", "Checkout as a user", "User is logged in");
        userLogIn("miloqeevtaf@framework.com", "Automation123!");
    }

    @When("User attempts checkout")
    public void userAttemptsCheckout() {
        createTestStep("When", "User attempts checkout");
        addProductToCart(MUG);
        goTo(CHECKOUT_URL);
        clickElement(PROCEED_BTN);
        waitUntilPageContainsElement(CONFIRM_ADDRESS_BTN);
        clickElement(CONFIRM_ADDRESS_BTN);
        waitUntilPageContainsElement(CONFIRM_DELIVERY_BTN);
        clickElement(CONFIRM_DELIVERY_BTN);
        waitUntilPageContainsElement(PAY_BANK_OPT);
        clickElement(PAY_BANK_OPT);
        clickElement(AGREE_CHECKBOX);
        clickElement(ORDER_BTN);
        waitUntilPageContainsElement(CONFIRMATION_TXT, 10);
    }

    @Then("Checkout should be successful")
    public void checkoutShouldBeSuccessful() {
        createTestStep("Then", "Checkout should be successful");
        pageShouldContainElement(CONFIRMATION_TXT);
        closeBrowser();
    }

    @Given("User navigates to prestashop")
    public void userNavigatesToPrestashop() {
        createTest("User Checkout", "Checkout as a guest", "User navigates to prestashop");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
    }

    @When("User attempts guest checkout")
    public void userAttemptsGuestCheckout() {
        createTestStep("When", "User attempts guest checkout");
        addProductToCart(MUG);
        goTo(CHECKOUT_URL);
        clickElement(PROCEED_BTN);
        waitUntilPageContainsElement(NAME_INP, 10);
        clickElement(GENDER_RADIO);
        inputText(NAME_INP, "Test");
        inputText(LASTNAME_INP, "Automation");
        inputText(EMAIL_INP, "test@automation.com");
        clickElement(AGREE_INP);
        clickElement(CONTINUE_BTN);
        waitUntilPageContainsElement(CONFIRM_ADDRESS_BTN, 10);
        inputText(ADDRESS_INP, "Mate de Luna 2026");
        inputText(CITY_INP, "Boston");
        selectFromListByValue(STATE_LIST, "24");
        inputTextAndSubmit(POSTAL_INP, "21000");
        waitUntilPageContainsElement(CONFIRM_ADDRESS_BTN, 10);
        clickElement(CONFIRM_ADDRESS_BTN);
        waitUntilPageContainsElement(CONFIRM_DELIVERY_BTN, 10);
        clickElement(CONFIRM_DELIVERY_BTN);
        waitUntilPageContainsElement(ORDER_BTN, 10);
        clickElement(PAY_BANK_OPT);
        clickElement(AGREE_CHECKBOX);
        clickElement(ORDER_BTN);
        waitUntilPageContainsElement(CONFIRMATION_TXT, 10);
    }
}
