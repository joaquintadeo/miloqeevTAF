package com.automationFramework.tests;

import UI.browserManagement;
import UI.functions;
import UI.utils;
import UI.window;
import com.automationFramework.testListeners.extentReportListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import facetPage.facetLandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
        ExtentTest loginfo=null;
        try {
            loginfo = test.createNode(new GherkinKeyword("When"), "User navigates to Facet Web Page");
            browserManagement.goTo(facetUrl);
            Thread.sleep(3000);
            loginfo.pass("Entered Url");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", browserManagement.driver, loginfo, e);
        }
    }
    @Then("^User must see facet logo$")
    public void user_must_see_facet_logo() throws Throwable{
        ExtentTest loginfo=null;
        try {
            loginfo = test.createNode(new GherkinKeyword("Then"), "User must see facet logo");
            functions.PageShouldContainElement(classname, facetLogo);
            loginfo.pass("Verified logo");
            browserManagement.closeBrowser();
            Thread.sleep(3000);
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", browserManagement.driver, loginfo, e);
        }
    }

    @BeforeClass
    public void ella(){
        System.out.println("ellix");
    }

    @BeforeMethod
    public void ellas(){
        System.out.println("ellix");
    }
}

