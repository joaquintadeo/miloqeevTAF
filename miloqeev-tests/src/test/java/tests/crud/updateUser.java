package tests.crud;

import BE.restCustomExceptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static BE.restJsonUtilities.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class updateUser {
    @Given("User sends put request to update user")
    public void userSendsPutRequestToUpdateUser() throws IOException, restCustomExceptions{
        createTest("Update User", "Update User", "User sends put request to update user");
        loadJsonFromFile("createUser");
        postRequest("http://localhost:8080/users", 201);
        loadJsonFromFile("updateUser");
        putRequest("http://localhost:8080/users/camnewton", 200);
    }

    @Then("User should be updated")
    public void newUserShouldBeCreated() throws IOException, restCustomExceptions{
        createTestStep("Then", "User should be updated");
        statusShouldBe(204);
        deleteRequest("http://localhost:8080/users/camnewton", 204);
    }
}
