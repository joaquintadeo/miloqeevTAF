package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class wait extends browserManagement{

    /**
     * Waits until `element` appears on current page.
     * Fails if `timeout` expires before element appears.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilPageContainsElement(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for page to contain element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " did not appear after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` disappears on current page.
     * Fails if `timeout` expires before element disappears.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilPageDoesNotContainElement(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue))));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for page to not contain element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
                testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " appeared after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `text` appears on current page.
     * Fails if `timeout` expires before text appears.
     * @param text
     * @param timeout
     * @throws Throwable
     */
    public static void waitUntilPageContains(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
            logInfo.pass("Successfully wait for page to contain 'text = " + text + "'");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Text: '" + text + "' did not appear after " + timeout + " seconds"),e);
        }
    }

    /**
     * Waits until `text` disappears on current page.
     * Fails if `timeout` expires before text disappears.
     * @param text
     * @param timeout
     */
    public static void waitUntilPageDoesNotContain(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
            logInfo.pass("Successfully wait for page to not contain 'text = " + text + "'");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Text '" + text + "' appeared after " + timeout + " seconds"),e);
        }
    }

    /**
     * Waits until `element` is visible on current page.
     * Fails if `timeout` expires before element is visible.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsVisible(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to be visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was not visible after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` is not visible on current page.
     * Fails if `timeout` expires before element is not visible.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsNotVisible(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locatorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(locatorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locatorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to not be visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was visible after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` is enabled on current page.
     * Fails if `timeout` expires before element is enabled.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsEnabled(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.elementToBeSelected(By.id(locatorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.elementToBeSelected(By.name(locatorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.elementToBeSelected(By.className(locatorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locatorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to be enabled");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was not enabled after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` is not enabled on current page.
     * Fails if `timeout` expires before element is not enabled.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsNotEnabled(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(locatorValue))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.name(locatorValue))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.className(locatorValue))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(locatorValue))));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to not be enabled");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was enabled after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` is clickable on current page.
     * Fails if `timeout` expires before element is clickable.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsClickable(String locatorType, String locatorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType){
                case "id": wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.elementToBeClickable(By.className(locatorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to be clickable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was not clickable after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` is not clickable on current page.
     * Fails if `timeout` expires before element is not clickable.
     * @param locatorType
     * @param locatorValue
     * @param timeout
     */
    public static void waitUntilElementIsNotClickable(String locatorType, String locatorValue, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(locatorValue))));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.name(locatorValue))));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className(locatorValue))));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue))));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to not be clickable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " was clickable after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` contains `text` on current page.
     * Fails if `timeout` expires before element contains `text`.
     * @param locatorType
     * @param locatorValue
     * @param text
     * @param timeout
     */
    public static void waitUntilElementContains(String locatorType, String locatorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType) {
                case "id": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(locatorValue), text));
                    break;
                case "name": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(locatorValue), text));
                    break;
                case "class": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(locatorValue), text));
                    break;
                case "xpath": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locatorValue), text));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to contain 'text=" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " did not contain 'text=" + text + "' after " + timeout + " seconds"), e);
        }
    }

    /**
     * Waits until `element` does not contain `text` on current page.
     * Fails if `timeout` expires before element does not contain `text`.
     * @param locatorType
     * @param locatorValue
     * @param text
     * @param timeout
     */
    public static void waitUntilElementDoesNotContain(String locatorType, String locatorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (locatorType) {
                case "id": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id(locatorValue), text)));
                    break;
                case "name": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.name(locatorValue), text)));
                    break;
                case "class": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.className(locatorValue), text)));
                    break;
                case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locatorValue), text)));
                    break;
                default:
                    break;
            }
            logInfo.pass("Successfully waited for element located by '" + locatorType + "=" + locatorValue + "' to not contain 'text=" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "'" + " contained 'text=" + text + "' after " + timeout + " seconds"), e);
        }
    }
}
