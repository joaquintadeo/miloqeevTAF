package tests.backend;

import BE.restCustomExceptions;
import cucumber.api.java.en.Given;

import java.io.IOException;
import static BE.json.*;;
import static testListeners.extentReportListener.*;

public class getDummy {

//    @Given("User sends get request")
//    public void userSendsGetRequest2() throws IOException {
//        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
//        getRequest("http://dummy.restapiexample.com/api/v1/employees");
//        logJsonToConsole(getResponseJson());
//        saveJsonToFile("getDummyResponse", getResponseJson());
//        statusShouldBe(300);
//    }
//
    @Given("User sends get request")
    public void userSendsGetRequest() throws IOException, restCustomExceptions {
        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
        loadJsonFromFile("postDummy");
        postRequest("http://dummy.restapiexample.com/api/v1/create");
        logRespStatusToConsole();
        logJsonToConsole(getResponseJson());
        saveJsonToFile("dummyResp", getResponseJson());
    }

//    @Given("User sends get request")
//    public void userSendsGetRequest2() throws IOException {
//        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
//        getRequest("http://dummy.restapiexample.com/api/v1/employees");
//        logJsonToConsole(getResponseJson());
//    }
//
//    @Given("User sends get request")
//    public void userSendsGetRequest3() throws IOException {
//        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
//        setXmlRequestHeader("Content-Type", "application/xml");
//        setXmlRequestHeader("Accept", "application/xml");
//        getXmlRequest("https://reqbin.com/echo/get/xml");
//        responseShouldBe("getDummy");
//        saveXmlToFile("test", getResponseXml());
//    }

//        @Given("User sends get request")
//    public void userSendsGetRequest() throws IOException, ParseException {
//        createTest("Testing get request", "Get Dummy Endpoint", "User sends get request");
//        loadXmlFromFile("postDummy");
//        setRequestHeader("Content-Type", "application/xml");
//        setXmlRequestHeader("Accept", "application/xml");
//        postXmlRequest("https://reqbin.com/echo/post/xml");
//        logXmlRespStatusToConsole();
//        saveXmlToFile("postDummyResponse2", getResponseXml());
//    }
}
