package BE;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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

import static java.nio.charset.StandardCharsets.US_ASCII;
import static testListeners.extentReportListener.backendTestStepHandle;
import static testListeners.extentReportListener.logInfo;

public class xml {

    private static HttpPost httpPost;
    private static HttpGet httpGet;
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

    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Send a GET request on the session object found in the cache using the given ``label``.
     * @param url
     */
    public static void getXmlRequest(String url) {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();  //creates one connection
            httpGet = new HttpGet(url);
            CloseableHttpResponse getResponse = httpClient.execute(httpGet);
            respCode = getResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            logInfo.pass("To be determined");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void postXmlRequest(String url) {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();  //creates one connection
            httpPost = new HttpPost(url);
            CloseableHttpResponse postResponse = httpClient.execute(httpPost);
            respCode = postResponse.getStatusLine().getStatusCode();
            responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
            responseXml = formatXml(responseString);
            logInfo.pass("To be determined");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void logXmlToConsole(Object xml) {
        try{
            System.out.println(xml);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void saveXmlToFile(String fileName, Object fileToSave) throws IOException {
        try{
            File folder = new File(System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/xml/");
            folder.mkdir();
            String xmlLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-reports/test-results/responses/xml/" + fileName + ".xml";
            FileWriter file = new FileWriter(xmlLocation);
            file.write(fileToSave.toString());
            file.flush();
        }  catch (AssertionError | IOException e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void setXmlRequestHeader(String name, String value) {
        try{
            httpPost.addHeader(name, value);
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void responseXmlShouldBe(String expected){
        Object expectedResponse = loadXmlResponseFromFile(expected);
        Assert.assertEquals(responseXml, expectedResponse);
    }

    public static void loadXmlFromFile(String fileName) {
        try{
            String xmlLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/requests/xml/" + fileName + ".xml";
            requestXml = formatXml(readFile(xmlLocation, US_ASCII));
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static Object loadXmlResponseFromFile(String fileName) {
        Object loadedXml = null;
        try{
            String xmlLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "miloqeev-tests/src/test/resources/responses/xml/" + fileName + ".xml";
            loadedXml = formatXml(readFile(xmlLocation, US_ASCII));
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
        return loadedXml;
    }

    public static void logXmlRespStatusToConsole() {
        try{
            System.out.println(respCode);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }

    public static void statusXmlShouldBe(int expectedStatus) {
        try{
            Assert.assertEquals(respCode, expectedStatus, "Response status should have been " + expectedStatus + "but instead was " + respCode);
        } catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("Response status should have been " + expectedStatus + "but instead was " + respCode), e);
        }
    }
}
