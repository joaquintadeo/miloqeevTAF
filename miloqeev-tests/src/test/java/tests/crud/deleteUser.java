package tests.crud;

import BE.restCustomExceptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static BE.restJsonUtilities.*;
import static testListeners.extentReportListener.createTest;
import static testListeners.extentReportListener.createTestStep;

public class deleteUser {
    @Given("User sends request to delete user")
    public void userSendsRequestToDeleteUser() throws IOException, restCustomExceptions {
        createTest("Delete User", "Delete User", "User sends request to delete user");
        deleteRequest("http://localhost:8080/users/camnewton", 204);
    }

    @Then("User should be deleted")
    public void UserShouldSeeAllUsers() {
        createTestStep("Then", "User should be deleted");
        statusShouldBe(204);
    }
}
