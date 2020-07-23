package UI;

import org.openqa.selenium.JavascriptExecutor;

import static UI.browserManagement.getDriver;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class javascript {

    /**
     * Executes the given Javascript script as String.
     * @param script
     */
    public static void executeJavaScript(String script){
        try {
            String id = "id";
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript(script);
            logInfo.pass("Executed JavaScript='" + script + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Could not execute JavaScript='" + script + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Executes the given Async Javascript script as String.
     * @param script
     */
    public static void executeAsyncJavaScript(String script){
        try {
            String id = "id";
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeAsyncScript(script);
            logInfo.pass("Executed Async JavaScript='" + script + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Could not execute Async JavaScript='" + script + "'"),e);
            logInfo.fail(e.getCause());
        }
    }
}
