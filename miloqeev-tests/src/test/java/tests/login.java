package tests;

import UI.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import loginPage.loginLandingPage;
import testListeners.extentReportListener;

public class login {
    private static int name = utils.NAME;
    private static String loginUrl = loginLandingPage.loginUrl;
    private static String user = loginLandingPage.nameInput;
    private static String password = loginLandingPage.passwordInput;
    private static String loginButton = loginLandingPage.loginButton;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() throws Throwable{
        extentReportListener.createTest("Testing successful login", "Login With Valid Credentials", "User navigates to login page");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
        browserManagement.goTo(loginUrl);
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() throws Throwable{
        extentReportListener.createTestStep("When", "User enters valid credentials");
        functions.inputText(name, user, "test");
        functions.inputText(name, password, "pass");
        functions.clickElement(name, loginButton);
    }

    @Then("User should see success message")
    public void userShouldSeeSuccessMessage() throws Throwable{
        extentReportListener.createTestStep("Then", "User should see success message");
        wait.waitUntilPageContains("**Successful Login**", 5);
        browserManagement.closeBrowser();
    }

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentials() throws Throwable{
        extentReportListener.createTestStep("When", "User enters invalid credentials");
        functions.inputText(name, user, "test");
        functions.inputText(name, password, "test");
        functions.clickElement(name, loginButton);
    }

    @Then("User should see failure message")
    public void userShouldSeeFailureMessage() throws Throwable{
        extentReportListener.createTestStep("Then", "User should see failure message");
        wait.waitUntilPageContains("**Failed Login**", 5);
        browserManagement.closeBrowser();
    }
}
