package tests.backend;

import cucumber.api.java.en.Given;
import org.apache.http.Header;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static BE.json.*;
import static testListeners.extentReportListener.*;

public class getDummy {

//    @Given("User sends get request")
//    public void userSendsGetRequest() throws IOException {
//        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
//        getRequest("http://dummy.restapiexample.com/api/v1/employees");
//        logJsonToConsole(responseJson);
//        statusShouldBe(300);
//    }

    @Given("User sends get request")
    public void userSendsGetRequest() throws IOException, ParseException {
        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
        loadJsonFromFile("postDummy");
        setRequestHeader("Content-Type", "application/json");
        postRequest("http://dummy.restapiexample.com/api/v1/create");
        logRespStatusToConsole();
        saveJsonToFile("postDummyResponse2", responseJson);
    }
}
