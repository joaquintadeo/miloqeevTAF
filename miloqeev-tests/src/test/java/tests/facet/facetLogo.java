package tests.facet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.window.*;
import static facetPage.facetLandingPage.*;
import static testListeners.extentReportListener.*;

public class facetLogo{

    @Given("User opens a browser")
    public void user_opens_a_browser() throws Throwable{
        createTest("Facet logo validation", "Facet logo should appear on Facet Web Page", "User opens a browser");
        openBrowser("chrome");
        setBrowserImplicitWait(600);
        maximizeBrowserWindow();
    }

    @When("User navigates to Facet Web Page")
    public void user_navigates_to_Facet_Web_Page() throws Throwable{
        createTestStep("When", "User navigates to Facet Web Page");
        goTo(FACET_URL);
    }

    @Then("User must see facet logo")
    public void user_must_see_facet_logo() throws Throwable{
        createTestStep("Then", "User must see facet logo");
        pageShouldContainElement("class", FACET_IMG);
        closeBrowser();
    }
}
