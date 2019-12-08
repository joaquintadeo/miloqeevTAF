package tests;

import UI.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testListeners.extentReportListener;

public class template {
    @Given("<some initial context>")
    public void someInitialContext() throws Throwable {
        extentReportListener.createTest("<Test Name>", "<Scenario Name>", "<some initial context>");
    }

    @When("<something happens>")
    public void somethingHappens() throws Throwable {
        extentReportListener.createTestStep("When", "<something happens>");
    }

    @And("<something else happens>")
    public void somethingElseHappens() throws Throwable {
        extentReportListener.createTestStep("And", "<something else happens>");
    }

    @Then("<some expectation>")
    public void someExpectation() throws Throwable {
        extentReportListener.createTestStep("Then", "<some expectation>");
    }
}
