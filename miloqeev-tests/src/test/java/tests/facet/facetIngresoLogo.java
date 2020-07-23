package tests.facet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static UI.browserManagement.*;
import static UI.browserManagement.closeBrowser;
import static UI.browserManagement.goTo;
import static UI.browserManagement.openBrowser;
import static UI.browserManagement.setBrowserImplicitWait;
import static UI.element.*;
import static UI.element.clickElement;
import static UI.element.pageShouldContainElement;
import static UI.wait.*;
import static UI.wait.waitUntilPageContains;
import static UI.window.*;
import static UI.window.maximizeBrowserWindow;
import static facetPage.facetIngresoPage.*;
import static facetPage.facetIngresoPage.INGRESO_IMG;
import static facetPage.facetIngresoPage.INGRESO_TXT;
import static facetPage.facetLandingPage.*;
import static facetPage.facetLandingPage.FACET_URL;
import static facetPage.facetLandingPage.INGRESO_BTN;
import static testListeners.extentReportListener.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

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
