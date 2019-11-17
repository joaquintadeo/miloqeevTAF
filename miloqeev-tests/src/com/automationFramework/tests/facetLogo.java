package com.automationFramework.tests;

import UI.browserManagement;
import UI.functions;
import UI.utils;
import UI.window;
import com.automationFramework.testListeners.extentReportListener;
import facetPage.facetLandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class facetLogo extends extentReportListener {
    private static int classname = utils.CLASSNAME;
    private static String facetLogo = facetLandingPage.facetLogo;
    private static String facetUrl = facetLandingPage.facetUrl;

    @Given("^User opens a browser$")
    public void user_opens_a_browser() throws Throwable{
        extentReportListener.createTest("Facet logo validation", "Facet logo should appear on Facet Web Page", "User opens a browser");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
    }
    @When("^User navigates to Facet Web Page$")
    public void user_navigates_to_facet_web_page() throws Throwable{
        extentReportListener.createTestStep("User navigates to Facet Web Page");
        browserManagement.goTo(facetUrl);
    }
    @Then("^User must see facet logo$")
    public void user_must_see_facet_logo() throws Throwable{
            extentReportListener.createClosingStep("User must see facet logo");
            functions.PageShouldContainElement(classname, facetLogo);
            browserManagement.closeBrowser();
    }
}

