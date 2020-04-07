package tests.facet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.*;
import static UI.window.*;
import static facetPage.facetLandingPage.*;
import static facetPage.facetIngresoPage.*;
import static testListeners.extentReportListener.*;

public class facetIngresoLogo {

    @Given("User opens browser and goes to facet web page")
    public void userOpensBrowserAndGoesToFacetWebPage() throws Throwable{
        createTest("Ingreso logo validation", "Ingreso logo should appear on Facet Web Page", "User opens browser and goes to facet web page");
        openBrowser("chrome");
        setBrowserImplicitWait(600);
        maximizeBrowserWindow();
        goTo(FACET_URL);
    }

    @When("User clicks on Ingreso button")
    public void userClicksOnIngresoButton() throws Throwable{
        createTestStep("When", "User clicks on Ingreso button");
        clickElement("xpath", INGRESO_BTN);
        waitUntilPageContains(INGRESO_TXT, 20);
    }

    @Then("User must see ingreso logo")
    public void userMustSeeIngresoLogo() throws Throwable{
        createTestStep("Then", "User must see ingreso logo");
        pageShouldContainElement("xpath", INGRESO_IMG);
        closeBrowser();
    }
}
