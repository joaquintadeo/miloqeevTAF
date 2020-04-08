package BE;


import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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

public class json{

    public static HttpPost httpPost;
    public static HttpGet httpGet;
    public static String responseString;
    public static Object responseJson;
    public static int respCode;
    public static Object requestJson;

    public static Object parseJson() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            responseJson = mapper.readValue(responseString, Object.class);
            responseJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseJson);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
        return responseJson;
    }

    public static void logJsonToConsole(Object json) {
        try{
            System.out.println(json);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void logRespStatusToConsole() {
        try{
            System.out.println(respCode);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void statusShouldBe(int expectedStatus) {
        try{
            Assert.assertEquals(respCode, expectedStatus, "Response status should have been " + expectedStatus + "but instead was " + respCode);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Response status should have been " + expectedStatus + "but instead was " + respCode), e);
        }
    }

    /**
     * Send a GET request on the session object found in the cache using the given ``label``.
     * @param url
     */
    public static void getRequest(String url) {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();  //creates one connection
            httpGet = new HttpGet(url);
            CloseableHttpResponse getResponse = httpClient.execute(httpGet);
            respCode = getResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            logInfo.pass("To be determined");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    /**
     * Send a POST request on the session object found in the cache using the given ``label``.
     * @param url
     */
    public static void postRequest(String url) {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();  //creates one connection
            httpPost = new HttpPost(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPost);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseJson = parseJson();
            logInfo.pass("To be determined");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void loadJsonFromFile(String fileName) {
        try{
            String jsonLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/requests" + fileName + ".json";
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(jsonLocation);
            requestJson = jsonParser.parse(reader);
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void setRequestHeader(String name, String value) {
        try{
            httpPost.addHeader(name, value);
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void saveJsonToFile(String fileName, Object fileToSave) throws IOException {
        try{
            File folder = new File(System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/");
            folder.mkdir();
            String jsonLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/" + fileName + ".json";
            FileWriter file = new FileWriter(jsonLocation);
            file.write(fileToSave.toString());
            file.flush();
        }  catch (AssertionError | IOException e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }
}
