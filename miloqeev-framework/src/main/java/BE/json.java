package BE;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;
import static testListeners.extentReportListener.backendTestStepHandle;
import static testListeners.extentReportListener.logInfo;

public class json{

    /**
     * Send a GET request on the session object found in the cache using the given ``label``.
     * @param url
     */
    public static void getRequest(String url) throws IOException {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();  //creates one connection
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("statusCode = " + statusCode);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseJson = new JSONObject(responseString);
            System.out.println("responseJson = " + responseJson);
            logInfo.pass("To be determined");
        }  catch (AssertionError | Exception e){
            backendTestStepHandle("FAIL", logInfo.fail("To be determined"), e);
        }
    }
}
