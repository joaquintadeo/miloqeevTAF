package tests;

import UI.browserManagement;
import UI.window;
import UI.functions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testListeners.extentReportListener;

public class youTubeLogo{
    @Given("User opens browser")
    public void user_opens_browser() throws Throwable{
        extentReportListener.createTest("YouTube logo validation", "YouTube logo should appear on YouTube Web Page", "User opens browser");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
    }

    @When("User navigates to YouTube Web Page")
    public void user_navigates_to_YouTube_Web_Page() throws Throwable{
        extentReportListener.createTestStep("When","User navigates to YouTube Web Page");
        browserManagement.goTo("http://youtube.com");
    }

    @Then("User must see YouTube logo")
    public void user_must_see_YouTube_logo() throws Throwable{
        extentReportListener.createTestStep("Then", "User must see YouTube logo");
        functions.PageShouldContainElement(0, "logo-icon-container");
        browserManagement.closeBrowser();
    }
}
