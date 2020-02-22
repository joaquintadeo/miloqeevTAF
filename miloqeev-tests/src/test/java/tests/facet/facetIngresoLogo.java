package tests.facet;

import UI.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testListeners.extentReportListener;
import facetPage.facetLandingPage;
import facetPage.facetIngresoPage;

public class facetIngresoLogo {
    private static String facetUrl = facetLandingPage.facetUrl;
    private static String ingresoButton = facetLandingPage.ingresoButton;
    private static String ingresoText = facetIngresoPage.ingresoText;
    private static String ingresoLogo = facetIngresoPage.ingresoLogo;

    @Given("User opens browser and goes to facet web page")
    public void userOpensBrowserAndGoesToFacetWebPage() throws Throwable{
        extentReportListener.createTest("Ingreso logo validation", "Ingreso logo should appear on Facet Web Page", "User opens browser and goes to facet web page");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
        browserManagement.goTo(facetUrl);
    }

    @When("User clicks on Ingreso button")
    public void userClicksOnIngresoButton() throws Throwable{
        extentReportListener.createTestStep("When", "User clicks on Ingreso button");
        element.clickElement("xpath", ingresoButton);
        wait.waitUntilPageContains(ingresoText, 20);
    }

    @Then("User must see ingreso logo")
    public void userMustSeeIngresoLogo() throws Throwable{
        extentReportListener.createTestStep("Then", "User must see ingreso logo");
        element.PageShouldContainElement("xpath", ingresoLogo);
        browserManagement.closeBrowser();
    }
}
