package tests.crud;

import BE.restCustomExceptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static BE.restJsonUtilities.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class readUser {
    @Given("User sends get request to read user")
    public void userSendsGetRequestToReadUser() throws IOException, restCustomExceptions {
        createTest("Read User", "Read User", "User sends get request to read user");
        getRequest("http://localhost:8080/users", 200);
    }

    @Then("User should see all users")
    public void UserShouldSeeAllUsers() {
        createTestStep("Then", "User should see all users");
        statusShouldBe(200);
        responseShouldBe("readUser");
    }
}
