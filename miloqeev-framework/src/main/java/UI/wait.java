package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static UI.browserManagement.getDriver;
import static UI.element.*;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class wait {

    private static WebDriverWait wait;

    private static String setWebDriverWait(int... timeout){
        String msg;
        if(timeout.length > 0) {
            wait = new WebDriverWait(getDriver(), timeout[0]);
            msg = timeout[0] + " seconds";
        } else{
            wait = new WebDriverWait(getDriver(), 5);
            msg = 5 + " seconds";
        }
        return msg;
    }
    /**
     * Waits until `element` appears on current page.
     * Fails if `timeout` expires before element appears.
     * @param locator
     */
    public static void waitUntilPageContainsElement(String locator, int... timeout){
        separateElementLocatorTypeFromValue(locator);
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.presenceOfElementLocated(By.id(getLocatorValue())));
                    break;
                case "name": wait.until(ExpectedConditions.presenceOfElementLocated(By.name(getLocatorValue())));
                    break;
                case "class": wait.until(ExpectedConditions.presenceOfElementLocated(By.className(getLocatorValue())));
                    break;
                case "xpath": wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getLocatorValue())));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for page to contain element located by '" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " did not appear after " + msg), e);
        }
    }

    /**
     * Waits until `element` disappears on current page.
     * Fails if `timeout` expires before element disappears.
     * @param locator
     * @param timeout
     */
    public static void waitUntilPageDoesNotContainElement(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id(getLocatorValue()))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.name(getLocatorValue()))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className(getLocatorValue()))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(getLocatorValue()))));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for page to not contain element located by '" + locator + "'");
        } catch (AssertionError | Exception e) {
                testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " appeared after " + msg), e);
        }
    }

    /**
     * Waits until `text` appears on current page.
     * Fails if `timeout` expires before text appears.
     * `timeout` is optional; if not provided, will set to 5 seconds by default.
     * @param text
     * @param timeout
     * @throws Throwable
     */
    public static void waitUntilPageContains(String text, int... timeout){
        String msg = setWebDriverWait(timeout);
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
            logInfo.pass("Successfully wait for page to contain 'text = " + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Text: '" + text + "' did not appear after " + msg),e);
        }
    }

    /**
     * Waits until `text` disappears on current page.
     * Fails if `timeout` expires before text disappears.
     * @param text
     * @param timeout
     */
    public static void waitUntilPageDoesNotContain(String text, int... timeout){
        String msg = setWebDriverWait(timeout);
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
            logInfo.pass("Successfully wait for page to not contain 'text = " + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Text '" + text + "' appeared after " + msg),e);
        }
    }

    /**
     * Waits until `element` is visible on current page.
     * Fails if `timeout` expires before element is visible.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsVisible(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getLocatorValue())));
                    break;
                case "name": wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(getLocatorValue())));
                    break;
                case "class": wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(getLocatorValue())));
                    break;
                case "xpath": wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getLocatorValue())));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to be visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was not visible after " + msg), e);
        }
    }

    /**
     * Waits until `element` is not visible on current page.
     * Fails if `timeout` expires before element is not visible.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsNotVisible(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(getLocatorValue())));
                    break;
                case "name": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(getLocatorValue())));
                    break;
                case "class": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(getLocatorValue())));
                    break;
                case "xpath": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(getLocatorValue())));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to not be visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was visible after " + msg), e);
        }
    }

    /**
     * Waits until `element` is enabled on current page.
     * Fails if `timeout` expires before element is enabled.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsEnabled(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.elementToBeSelected(By.id(getLocatorValue())));
                    break;
                case "name": wait.until(ExpectedConditions.elementToBeSelected(By.name(getLocatorValue())));
                    break;
                case "class": wait.until(ExpectedConditions.elementToBeSelected(By.className(getLocatorValue())));
                    break;
                case "xpath": wait.until(ExpectedConditions.elementToBeSelected(By.xpath(getLocatorValue())));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to be enabled");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was not enabled after " + msg), e);
        }
    }

    /**
     * Waits until `element` is not enabled on current page.
     * Fails if `timeout` expires before element is not enabled.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsNotEnabled(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(getLocatorValue()))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.name(getLocatorValue()))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.className(getLocatorValue()))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(getLocatorValue()))));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to not be enabled");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was enabled after " + msg), e);
        }
    }

    /**
     * Waits until `element` is clickable on current page.
     * Fails if `timeout` expires before element is clickable.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsClickable(String locator, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()){
                case "id": wait.until(ExpectedConditions.elementToBeClickable(By.id(getLocatorValue())));
                    break;
                case "name": wait.until(ExpectedConditions.elementToBeClickable(By.name(getLocatorValue())));
                    break;
                case "class": wait.until(ExpectedConditions.elementToBeClickable(By.className(getLocatorValue())));
                    break;
                case "xpath": wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getLocatorValue())));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to be clickable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was not clickable after " + msg), e);
        }
    }

    /**
     * Waits until `element` is not clickable on current page.
     * Fails if `timeout` expires before element is not clickable.
     * @param locator
     * @param timeout
     */
    public static void waitUntilElementIsNotClickable(String locator, int... timeout) {
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(getLocatorValue()))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.name(getLocatorValue()))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className(getLocatorValue()))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(getLocatorValue()))));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to not be clickable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " was clickable after " + msg), e);
        }
    }

    /**
     * Waits until `element` contains `text` on current page.
     * Fails if `timeout` expires before element contains `text`.
     * @param locator
     * @param text
     * @param timeout
     */
    public static void waitUntilElementContains(String locator, String text, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()) {
                case "id": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(getLocatorValue()), text));
                    break;
                case "name": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(getLocatorValue()), text));
                    break;
                case "class": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(getLocatorValue()), text));
                    break;
                case "xpath": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(getLocatorValue()), text));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to contain 'text=" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " did not contain 'text=" + text + "' after " + msg), e);
        }
    }

    /**
     * Waits until `element` does not contain `text` on current page.
     * Fails if `timeout` expires before element does not contain `text`.
     * @param locator
     * @param text
     * @param timeout
     */
    public static void waitUntilElementDoesNotContain(String locator, String text, int... timeout){
        String msg = setWebDriverWait(timeout);
        try{
            switch (getLocatorType()) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id(getLocatorValue()), text)));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.name(getLocatorValue()), text)));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.className(getLocatorValue()), text)));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(getLocatorValue()), text)));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locator + "' to not contain 'text=" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "'" + " contained 'text=" + text + "' after " + msg), e);
        }
    }
}
