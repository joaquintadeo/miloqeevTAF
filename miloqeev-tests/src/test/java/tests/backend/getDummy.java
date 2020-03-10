package tests.backend;

import BE.*;
import testListeners.extentReportListener;
import cucumber.api.java.en.Given;

import java.io.IOException;

public class getDummy {

    @Given("User sends get request")
    public void userSendsGetRequest() throws IOException {
        extentReportListener.createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
        json.getRequest("http://dummy.restapiexample.com/api/v1/employees");
    }
}
