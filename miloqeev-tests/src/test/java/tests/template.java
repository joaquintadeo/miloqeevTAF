package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class template {
    @Given("<some initial context>")
    public void someInitialContext() {
        createTest("<Test Name>", "<Scenario Name>", "<some initial context>");
    }

    @When("<something happens>")
    public void somethingHappens() {
        createTestStep("When", "<something happens>");
    }

    @And("<something else happens>")
    public void somethingElseHappens() {
        createTestStep("And", "<something else happens>");
    }

    @Then("<some expectation>")
    public void someExpectation() {
        createTestStep("Then", "<some expectation>");
    }
}
