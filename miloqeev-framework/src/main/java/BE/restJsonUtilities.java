package BE;


import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static testListeners.extentReportListener.backendTestStepHandle;
import static testListeners.extentReportListener.logInfo;

public class restJsonUtilities {

    private static HttpPost httpPost;
    private static HttpGet httpGet;
    private static HttpDelete httpDelete;
    private static HttpPatch httpPatch;
    private static HttpPut httpPut;
    private static String responseString;
    private static Object responseJson;
    private static int respCode;
    private static Object requestJson;

    public static Object getResponseJson() {
        return responseJson;
    }

    public static int getRespCode() {
        return respCode;
    }

    /**
     * Parses String into JSON Object.
     * @return JSON Object.
     */
    public static Object parseJson() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            checkException(getRespCode(), 200);
            responseJson = mapper.readValue(responseString, Object.class);
            responseJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseJson);
            logInfo.pass("Successfully parsed JSON");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not parse JSON"), e);
        }
        return responseJson;
    }

    /**
     * Logs given JSON into console.
     * @param json
     */
    public static void logJsonToConsole(Object json) {
        try{
            System.out.println(json);
            logInfo.pass("Logged JSON to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log JSON to console"), e);
        }
    }

    /**
     * Logs the JSON inside response payload into console.
     */
    public static void logRespJsonToConsole() {
        try{
            System.out.println(getResponseJson());
            logInfo.pass("Logged Response JSON to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Response JSON to console"), e);
        }
    }

    /**
     * Logs request status code to console.
     */
    public static void logRespStatusToConsole() {
        try{
            System.out.println(getRespCode());
            logInfo.pass("Logged Status Code to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Status Code to console"), e);
        }
    }

    /**
     * Logs request status code.
     */
    public static void logRespStatus() {
        try{
            logInfo.pass("Status Code: '" + getRespCode() + "'");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Status Code"), e);
        }
    }

    /**
     * Logs the JSON inside response payload.
     */
    public static void logRespJson() {
        try{
            logInfo.pass("JSON Response: '" + getResponseJson() + "'");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Response JSON"), e);
        }
    }

    /**
     * Compares the request status code to a given expected status code.
     * @param expectedStatus
     */
    public static void statusShouldBe(int expectedStatus) {
        try{
            Assert.assertEquals(getRespCode(), expectedStatus, "Response status should have been " + expectedStatus + "but instead was " + getRespCode());
            logInfo.pass("Response status should have been " + expectedStatus + "but instead was " + getRespCode());
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Response status should have been " + expectedStatus + "but instead was " + getRespCode()), e);
        }
    }

    /**
     * Sends a GET request on the session to the given url.
     * @param url
     */
    public static void getRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            CloseableHttpResponse getResponse = httpClient.execute(httpGet);
            respCode = getResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            checkException(getRespCode(), 200);
            logInfo.pass("Sent GET request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send GET request to url '" + url + "'"), ex);
        }
    }

    /**
     * Send a POST request on the session to the given url.
     * @param url
     */
    public static void postRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            setRequestHeader("Content-Type", "application/restJsonUtilities");
            CloseableHttpResponse postResponse = httpClient.execute(httpPost);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            checkException(getRespCode(), 200);
            logInfo.pass("Sent POST request to url '" + url + "'");
        } catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send POST request to url '" + url + "'"), ex);
        }
    }

    /**
     * Send a DELETE request on the session to the given url.
     * @param url
     */
    public static void deleteRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpDelete = new HttpDelete(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpDelete);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            checkException(getRespCode(), 202);
            logInfo.pass("Sent DELETE request to url '" + url + "'");
        } catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send DELETE request to url '" + url + "'"), ex);
        }
    }

    /**
     * Send a PATCH request on the session to the given url.
     * @param url
     */
    public static void patchRequest(String url) throws restCustomExceptions, IOException {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPatch = new HttpPatch(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPatch);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            checkException(getRespCode(), 200);
            logInfo.pass("Sent PATCH request to url '" + url + "'");
        } catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send PATCH request to url '" + url + "'"), ex);
        }
    }

    /**
     * Send a PUT request on the session to the given url.
     * @param url
     */
    public static void putRequest(String url) throws restCustomExceptions, IOException {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPut = new HttpPut(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPut);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            checkException(getRespCode(), 200);
            logInfo.pass("Sent PUT request to url '" + url + "'");
        } catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send PUT request to url '" + url + "'"), ex);
        }
    }

    /**
     * Validates the request status code.
     * @param respCode
     * @param expectedCode
     * @throws restCustomExceptions
     */
    public static void checkException(int respCode, int expectedCode) throws restCustomExceptions {
        switch (respCode){
            case 400:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("400 Bad Request");
            case 401:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("401 Unauthorized");
            case 403:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("400 Forbidden");
            case 404:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("404 Not Found");
            case 405:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("405 Method Not Allowed");
            case 408:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("408 Request Timeout");
            case 500:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("500 Internal Server Error");
            case 501:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("501 Not Implemented");
            case 502:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("502 Bad Gateway");
            case 503:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("503 Service Unavailable");
            case 504:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("504 Gateway Timeout");
            case 505:
                Assert.assertEquals(respCode, expectedCode);
                throw new restCustomExceptions("505 HTTP Version Not Supported");
            default: break;
        }
    }

    /**
     * Loads restJsonUtilities content from a given file.
     * @param fileName
     */
    public static void loadJsonFromFile(String fileName) {
        try{
            String jsonLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/requests/restJsonUtilities/" + fileName + ".restJsonUtilities";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(jsonLocation);
            requestJson = jsonParser.parse(reader);
            logInfo.pass("Successfully loaded JSON from file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not load JSON from file '" + fileName + "'"), e);
        }
    }

    /**
     * Sets request desired headers.
     * @param name
     * @param value
     */
    public static void setRequestHeader(String name, String value) {
        try{
            httpPost.addHeader(name, value);
            logInfo.pass("Set Request header " + name + " to: " + value);
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not set Request header " + name + " to: " + value), e);
        }
    }

    /**
     * Saves Json object to the given file.
     * @param fileName
     * @param fileToSave
     * @throws IOException
     */
    public static void saveJsonToFile(String fileName, Object fileToSave) throws IOException {
        try{
            String jsonLocationFolder = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/restJsonUtilities/";
            File folder = new File(jsonLocationFolder);
            folder.mkdirs();
            String jsonLocation = jsonLocationFolder + fileName + ".restJsonUtilities";
            File json = new File(jsonLocation);
            json.createNewFile();
            FileWriter file = new FileWriter(jsonLocation);
            file.write(fileToSave.toString());
            file.flush();
            logInfo.pass("Saved JSON to file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to save JSON to file '" + fileName + "'"), e);
        }
    }

    /**
     * Validates content of the request response.
     * @param expected
     */
    public static void responseShouldBe(String expected){
        try{
            Object expectedResponse = loadJsonResponseFromFile(expected);
            Assert.assertEquals(responseJson, expectedResponse);
            logInfo.pass("Validated response content");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed because JSON content was different"), e);
        }
    }

    /**
     * Loads restJsonUtilities content from a given file.
     * @param fileName
     * @return
     */
    public static Object loadJsonResponseFromFile(String fileName){
        Object loadedJson = null;
        try{
            String jsonLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/responses/restJsonUtilities/" + fileName + ".restJsonUtilities";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(jsonLocation);
            loadedJson = jsonParser.parse(reader);
            logInfo.pass("Successfully loaded JSON from file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not load JSON from file '" + fileName + "'"), e);
        }
        return loadedJson;
    }
}
