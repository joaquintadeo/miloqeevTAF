package tests.crud;

import BE.restCustomExceptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static BE.restJsonUtilities.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class createUser {
    @Given("User sends post request to create user")
    public void userSendsPostRequestToCreateUser() throws IOException, restCustomExceptions {
        createTest("Create User", "Create User", "User sends post request to create user");
        loadJsonFromFile("createUser");
        postRequest("http://localhost:8080/users", 201);
    }

    @Then("New user should be created")
    public void newUserShouldBeCreated() {
        createTestStep("Then", "New user should be created");
        statusShouldBe(201);
        responseShouldBe("createUser");
    }
}
