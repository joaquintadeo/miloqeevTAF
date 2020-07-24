package BE;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static BE.json.checkException;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static testListeners.extentReportListener.backendTestStepHandle;
import static testListeners.extentReportListener.logInfo;

public class xml {

    private static HttpPost httpPost;
    private static HttpGet httpGet;
    private static HttpDelete httpDelete;
    private static HttpPatch httpPatch;
    private static HttpPut httpPut;
    private static String responseString;
    private static Object responseXml;
    private static int respCode;
    private static Object requestXml;

    public static Object getResponseXml() {
        return responseXml;
    }

    public static String getResponseString() {
        return responseString;
    }

    public static int getRespCode() {
        return respCode;
    }

    /**
     * Format String into XML file.
     * @param unformattedXml
     * @return
     */
    public static String formatXml(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);
            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parses String into XML Object.
     */
    public static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads characters from encoded file.
     * @param path
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Logs given XML into console.
     * @param xml
     */
    public static void logXmlToConsole(Object xml) {
        try{
            System.out.println(xml);
            logInfo.pass("Logged XML to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log XML to console"), e);
        }
    }

    /**
     * Logs the json inside response payload into console.
     */
    public static void logRespXmlToConsole() {
        try{
            System.out.println(getResponseXml());
            logInfo.pass("Logged Response XML to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Response XML to console"), e);
        }
    }

    /**
     * Logs the XML inside response payload into console.
     */
    public static void logXmlRespStatusToConsole() {
        try{
            System.out.println(respCode);
            logInfo.pass("Logged Response XML to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Response XML to console"), e);
        }
    }

    /**
     * Logs XML request status code to console.
     */
    public static void logXMLRespStatusToConsole() {
        try{
            System.out.println(getRespCode());
            logInfo.pass("Logged XML Status Code to console");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log XML Status Code to console"), e);
        }
    }

    /**
     * Logs XML request status code.
     */
    public static void logXMLRespStatus() {
        try{
            logInfo.pass("XML Status Code: '" + getRespCode() + "'");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log XML Status Code"), e);
        }
    }

    /**
     * Logs the XML inside response payload.
     */
    public static void logRespXml() {
        try{
            logInfo.pass("Json Response: '" + getResponseXml() + "'");
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to log Response Json"), e);
        }
    }

    /**
     * Compares the XML request status code to a given expected status code.
     * @param expectedStatus
     */
    public static void statusXmlShouldBe(int expectedStatus) {
        try{
            Assert.assertEquals(respCode, expectedStatus, "Response status should have been " + expectedStatus + "but instead was " + respCode);
            logInfo.pass("Response status should have been " + expectedStatus + "but instead was " + getRespCode());
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Response status should have been " + expectedStatus + "but instead was " + respCode), e);
        }
    }

    /**
     * Sends a GET XML request on the session to the given url.
     * @param url
     */
    public static void getXmlRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            CloseableHttpResponse getResponse = httpClient.execute(httpGet);
            respCode = getResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            checkException(getRespCode(), 200);
            logInfo.pass("Sent XML GET request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send XML GET request to url '" + url + "'"), ex);
        }
    }

    /**
     * Sends a POST XML request on the session to the given url.
     * @param url
     */
    public static void postXmlRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPost);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            checkException(getRespCode(), 200);
            logInfo.pass("Sent XML POST request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send XML POST request to url '" + url + "'"), ex);
        }
    }

    /**
     * Sends a DELETE XML request on the session to the given url.
     * @param url
     */
    public static void deleteXmlRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpDelete = new HttpDelete(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpDelete);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            checkException(getRespCode(), 202);
            logInfo.pass("Sent XML DELETE request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send XML DELETE request to url '" + url + "'"), ex);
        }
    }

    /**
     * Sends a PATCH XML request on the session to the given url.
     * @param url
     */
    public static void patchXmlRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPatch = new HttpPatch(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPatch);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            checkException(getRespCode(), 200);
            logInfo.pass("Sent XML PATCH request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send XML PATCH request to url '" + url + "'"), ex);
        }
    }

    /**
     * Sends a PUT XML request on the session to the given url.
     * @param url
     */
    public static void putXmlRequest(String url) throws restCustomExceptions, IOException{
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpPut = new HttpPut(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPut);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            checkException(getRespCode(), 200);
            logInfo.pass("Sent XML PUT request to url '" + url + "'");
        }  catch (restCustomExceptions ex){
            System.out.println("ex = " + ex.getMessage());
            backendTestStepHandle("FAIL", logInfo.fail("Failed to send XML PUT request to url '" + url + "'"), ex);
        }
    }

    /**
     * Saves XML object to the given file.
     * @param fileName
     * @param fileToSave
     * @throws IOException
     */
    public static void saveXmlToFile(String fileName, Object fileToSave) throws IOException {
        try{
            String xmlLocationFolder = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/xml/";
            File folder = new File(xmlLocationFolder);
            folder.mkdirs();
            String xmlLocation = xmlLocationFolder + fileName + ".xml";
            File json = new File(xmlLocation);
            json.createNewFile();
            FileWriter file = new FileWriter(xmlLocation);
            file.write(fileToSave.toString());
            file.flush();
            logInfo.pass("Saved XML to file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed to save XML to file '" + fileName + "'"), e);
        }
    }

    /**
     * Sets XML request desired headers.
     * @param name
     * @param value
     */
    public static void setXmlRequestHeader(String name, String value) {
        try{
            httpPost.addHeader(name, value);
            logInfo.pass("Set XML Request header " + name + " to: " + value);
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not set XML Request header " + name + " to: " + value), e);
        }
    }

    /**
     * Validates content of the XML request response.
     * @param expected
     */
    public static void responseXmlShouldBe(String expected){
        try{
            Object expectedResponse = loadXmlResponseFromFile(expected);
            Assert.assertEquals(responseXml, expectedResponse);
            logInfo.pass("Validated response content");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Failed because XML content was different"), e);
        }
    }

    /**
     * Loads XML content from a given file.
     * @param fileName
     */
    public static void loadXmlFromFile(String fileName) {
        try{
            String xmlLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/requests/xml/" + fileName + ".xml";
            requestXml = formatXml(readFile(xmlLocation, US_ASCII));
            logInfo.pass("Successfully loaded XML from file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not load XML from file '" + fileName + "'"), e);
        }
    }

    /**
     * Loads XML content from a given file.
     * @param fileName
     * @return
     */
    public static Object loadXmlResponseFromFile(String fileName) {
        Object loadedXml = null;
        try{
            String xmlLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/responses/xml/" + fileName + ".xml";
            loadedXml = formatXml(readFile(xmlLocation, US_ASCII));
            logInfo.pass("Successfully loaded XML from file '" + fileName + "'");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Could not load XML from file '" + fileName + "'"), e);
        }
        return loadedXml;
    }
}
