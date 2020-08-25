package tests.prestashop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.*;
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
        clickElement2(SIGN_IN_A);
        pageShouldContainElement2(LOGIN_FORM);
        inputText2(EMAIL_INP, "miloqeevtaf@framework.com");
        inputText2(PASS_INP, "Automation123!");
        clickElement2(SIGN_IN_BTN);
    }

    @Then("Login should be successful")
    public void loginShouldBeSuccessful() {
        createTestStep("Then", "Login should be successful");
        pageShouldContainElement2(SIGN_OUT_A);
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
        clickElement2(SIGN_IN_A);
        pageShouldContainElement2(LOGIN_FORM);
        inputText2(EMAIL_INP, "miloqeevtaf@framework.com");
        inputText2(PASS_INP, "Fail123!");
        clickElement2(SIGN_IN_BTN);
    }

    @Then("Login should be unsuccessful")
    public void loginShouldBeUnsuccessful() {
        createTestStep("Then", "Login should be unsuccessful");
        pageShouldContainElement2(AUTH_FAIL_TXT);
        closeBrowser();
    }
}
