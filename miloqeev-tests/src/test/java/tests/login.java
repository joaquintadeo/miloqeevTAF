package tests;

import UI.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import loginPage.loginLandingPage;
import testListeners.extentReportListener;

public class login {
    private static String loginUrl = loginLandingPage.loginUrl;
    private static String user = loginLandingPage.nameInput;
    private static String password = loginLandingPage.passwordInput;
    private static String loginButton = loginLandingPage.loginButton;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage(){
        extentReportListener.createTest("Testing successful login", "Login With Valid Credentials", "User navigates to login page");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
        browserManagement.goTo(loginUrl);
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials(){
        extentReportListener.createTestStep("When", "User enters valid credentials");
        element.inputText("name", user, "test");
        element.inputText("name", password, "pass");
    }

    @Then("User should see success message")
    public void userShouldSeeSuccessMessage(){
        extentReportListener.createTestStep("Then", "User should see success message");
        wait.waitUntilPageContains("**Successful Login**", 5);
        browserManagement.closeBrowser();
    }

    @Given("User navigates to login site")
    public void userNavigatesToLoginSite(){
        extentReportListener.createTest("Testing successful login", "Login With Invalid Credentials", "User navigates to login page");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
        browserManagement.goTo(loginUrl);
    }

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentials(){
        extentReportListener.createTestStep("When", "User enters invalid credentials");
        element.inputText("name", user, "test");
        element.inputText("name", password, "test");
    }

    @Then("User should see failure message")
    public void userShouldSeeFailureMessage(){
        extentReportListener.createTestStep("Then", "User should see failure message");
        wait.waitUntilPageContains("**Failed Login**", 5);
        browserManagement.closeBrowser();
    }

    @And("User clicks login button")
    public void clicksLoginButton(){
        extentReportListener.createTestStep("And", "User clicks login button");
        element.clickElement("name", loginButton);
    }
}
