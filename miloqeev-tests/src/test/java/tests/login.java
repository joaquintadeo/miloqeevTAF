package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.*;
import static UI.window.*;
import static loginPage.loginLandingPage.*;
import static testListeners.extentReportListener.*;

public class login {

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage(){
        createTest("Testing successful login", "Login With Valid Credentials", "User navigates to login page");
        openBrowser("chrome");
        setBrowserImplicitWait(600);
        maximizeBrowserWindow();
        goTo(LOGIN_URL);
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials(){
        createTestStep("When", "User enters valid credentials");
        inputText("name", USERNAME_INP, "test");
        inputText("name", PASSWORD_INP, "pass");
    }

    @Then("User should see success message")
    public void userShouldSeeSuccessMessage(){
        createTestStep("Then", "User should see success message");
        waitUntilPageContains("**Successful Login**");
        closeBrowser();
    }

    @Given("User navigates to login site")
    public void userNavigatesToLoginSite(){
        createTest("Testing successful login", "Login With Invalid Credentials", "User navigates to login page");
        openBrowser("chrome");
        setBrowserImplicitWait(600);
        maximizeBrowserWindow();
        goTo(LOGIN_URL);
    }

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentials(){
        createTestStep("When", "User enters invalid credentials");
        inputText("name", USERNAME_INP, "test");
        inputText("name", PASSWORD_INP, "test");
    }

    @Then("User should see failure message")
    public void userShouldSeeFailureMessage(){
        createTestStep("Then", "User should see failure message");
        waitUntilPageContains("**Failed Login**", 5);
        closeBrowser();
    }

    @And("User clicks login button")
    public void clicksLoginButton(){
        createTestStep("And", "User clicks login button");
        clickElement("name", LOGIN_BTN);
    }
}
