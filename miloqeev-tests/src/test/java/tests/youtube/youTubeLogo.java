package tests.youtube;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testListeners.extentReportListener;

import static UI.browserManagement.*;
import static UI.browserManagement.closeBrowser;
import static UI.browserManagement.goTo;
import static UI.browserManagement.openBrowser;
import static UI.browserManagement.setBrowserImplicitWait;
import static UI.element.*;
import static UI.element.pageShouldContainElement;
import static UI.window.*;
import static UI.window.maximizeBrowserWindow;
import static youTubePage.youTubeLandingPage.*;
import static youTubePage.youTubeLandingPage.YOUTUBE_IMG;
import static youTubePage.youTubeLandingPage.YOUTUBE_URL;

public class youTubeLogo extends extentReportListener{

    @Given("User opens browser")
    public void user_opens_browser() throws Throwable{
        createTest("YouTube logo validation", "YouTube logo should appear on YouTube Web Page", "User opens browser");
        openBrowser("chrome");
        setBrowserImplicitWait(600);
        maximizeBrowserWindow();
    }

    @When("User navigates to YouTube Web Page")
    public void user_navigates_to_YouTube_Web_Page() throws Throwable{
        createTestStep("When","User navigates to YouTube Web Page");
        goTo(YOUTUBE_URL);
    }

    @Then("User must see YouTube logo")
    public void user_must_see_YouTube_logo() throws Throwable{
        createTestStep("Then", "User must see YouTube logo");
        pageShouldContainElement("id", YOUTUBE_IMG);
        closeBrowser();
    }
}
