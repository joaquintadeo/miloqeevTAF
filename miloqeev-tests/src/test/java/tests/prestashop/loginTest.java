package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.login.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class loginTest {
    @Given("User navigates to url scenario 1")
    public void userNavigatesToUrlScenario1() {
        createTest("User Login", "Login with valid credentials", "User navigates to Presta Shop");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
    }

    @When("User attempts to login with valid credentials")
    public void userAttemptsToLoginWithValidCredentials() {
        createTestStep("When", "User attempts to login with valid credentials");
        clickElement(SIGN_IN_A);
        pageShouldContainElement(LOGIN_FORM);
        inputText(EMAIL_INP, "miloqeevtaf@framework.com");
        inputText(PASS_INP, "Automation123!");
        clickElement(SIGN_IN_BTN);
    }

    @Then("Login should be successful")
    public void loginShouldBeSuccessful() {
        createTestStep("Then", "Login should be successful");
        waitUntilPageContainsElement(SIGN_OUT_A, 10);
        pageShouldContainElement(SIGN_OUT_A);
        closeBrowser();
    }

    @Given("User navigates to url scenario 2")
    public void userNavigatesToUrlScenario2() {
        createTest("User Login", "Login with invalid credentials", "User navigates to Presta Shop");
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
    }

    @When("User attempts to login with invalid credentials")
    public void userAttemptsToLoginWithInvalidCredentials() {
        createTestStep("When", "User attempts to login with invalid credentials");
        clickElement(SIGN_IN_A);
        pageShouldContainElement(LOGIN_FORM);
        inputText(EMAIL_INP, "miloqeevtaf@framework.com");
        inputText(PASS_INP, "Fail123!");
        clickElement(SIGN_IN_BTN);
    }

    @Then("Login should be unsuccessful")
    public void loginShouldBeUnsuccessful() {
        createTestStep("Then", "Login should be unsuccessful");
        pageShouldContainElement(AUTH_FAIL_TXT);
        closeBrowser();
    }
}
