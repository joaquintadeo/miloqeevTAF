package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testListeners.extentReportListener.*;
import static UI.browserManagement.driver;

public class alert {

    /**
     * Waits for alert to appear on current page.
     * Fails if `timeout` expires.
     * @param timeout
     */
    public static void waitAlert(int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            logInfo.pass("Successfully waited for alert to appear'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Alert not found in '" + timeout + " seconds'"), e);
        }
    }

    /**
     * Types the given `text` into an input field in an alert.
     * Fails if `timeout` expires.
     * @param text
     * @param timeout
     */
    public static void inputTextIntoAlert(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            waitAlert(timeout);
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
            logInfo.pass("Entered 'text=" + text + "' and accepted alert");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Unable to enter 'text=" + text + "' and accept alert"), e);
        }
    }
}
