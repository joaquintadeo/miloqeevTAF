package com.gherkinFeature.stepDefinition;

import UI.browserManagement;
import UI.functions;
import UI.utils;
import UI.window;
import facetPage.facetLandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class facetLogoStepDefinition {
    private static int classname = utils.CLASSNAME;
    private static int xpath = utils.XPATH;
    private static String facetLogo = facetLandingPage.facetLogo;
    private static String facetUrl = facetLandingPage.facetUrl;

    @Given("^User opens a browser$")
    public void user_opens_a_browser() throws Throwable{
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
        Thread.sleep(3000);
    }
    @When("^User navigates to Facet Web Page$")
    public void user_navigates_to_facet_web_page() throws Throwable{
        browserManagement.goTo(facetUrl);
        Thread.sleep(3000);
    }
    @Then("^User must see facet logo$")
    public void user_must_see_facet_logo() throws Throwable{
        functions.PageShouldContainElement(classname, facetLogo);
        browserManagement.closeBrowser();
        Thread.sleep(3000);
    }
}
