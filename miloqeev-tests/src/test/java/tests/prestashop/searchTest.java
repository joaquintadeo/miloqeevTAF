package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.login.BASE_URL;
import static prestashop.search.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class searchTest {

    private String existingProduct = "The Adventure Begins Framed...";
    private String nonExistingProduct = "Iphone XI";

    @Given("User opens browser")
    public void userOpensBrowser() {
        createTest("Product Search", "Search of existing product", "User opens browser");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
    }

    @When("User searches for existing product")
    public void userSearchesForExistingProduct() {
        createTestStep("When", "User searches for existing product");
        waitUntilPageContainsElement(SEARCH_INP);
        inputTextAndSubmit(SEARCH_INP, existingProduct);
        waitUntilPageContainsElement(FIRST_ELEMENT_IMG);
    }

    @Then("Product should appear")
    public void productShouldAppear() {
        createTestStep("Then", "Product should appear");
        elementShouldContain(FIRST_PRODUCT_A, existingProduct);
        closeBrowser();
    }

    @Given("User opens another browser")
    public void userOpensAnotherBrowser() {
        createTest("Product Search", "Search of non existing product", "User opens another browser");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
    }

    @When("User searches for non existing product")
    public void userSearchesForNonExistingProduct() {
        createTestStep("When", "User searches for non existing product");
        waitUntilPageContainsElement(SEARCH_INP);
        inputTextAndSubmit(SEARCH_INP, nonExistingProduct);
    }

    @Then("Product should not appear")
    public void productShouldNotAppear() {
        createTestStep("Then", "Product should not appear");
        waitUntilPageContainsElement(NO_RESULTS_DIV);
        pageShouldContainElement(NO_RESULTS_DIV);
        closeBrowser();
    }
}
