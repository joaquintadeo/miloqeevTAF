package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait extends browserManagement{

    /**
     * Waits until `element` appears on current page.
     * Fails if `timeout` expires before element appears.
     * @param selectorType
     * @param selectorValue
     * @param timeout
     */
    public static void waitUntilPageContainsElement(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            switch (selectorType){
                case "id": wait.until(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)));
                    break;
                case "name": wait.until(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)));
                    break;
                case "class": wait.until(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)));
                    break;
                case "xpath": wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)));
                    break;
                default: break;
            }
            logInfo.pass("Successfully waited for page to contain element located by '" + selectorType + " = " + selectorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail("Element located by '" + selectorType + " = " + selectorValue + "'" + " did not appear in " + timeout + " seconds");
            logInfo.fail(e.getCause());
        }
    }

    public static void waitUntilPageDoesNotContainElement(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue))));
                break;
            case "name": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue))));
                break;
            case "class": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue))));
                break;
            case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue))));
                break;
            default: break;
        }
    }

    public static void waitUntilPageContains(String text, int timeout) throws Throwable{
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
            logInfo.pass("Successful wait for page to contain 'text = " + text + "'");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo,e);
            logInfo.fail(e.getCause());
        }
    }

    public static void waitUntilPageDoesNotContain(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text)));
    }

    public static void waitUntilElementIsVisible(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selectorValue)));
                break;
            case "name": wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(selectorValue)));
                break;
            case "class": wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(selectorValue)));
                break;
            case "xpath": wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotVisible(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(selectorValue)));
                break;
            case "name": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(selectorValue)));
                break;
            case "class": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(selectorValue)));
                break;
            case "xpath": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsEnabled(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.elementToBeSelected(By.id(selectorValue)));
                break;
            case "name": wait.until(ExpectedConditions.elementToBeSelected(By.name(selectorValue)));
                break;
            case "class": wait.until(ExpectedConditions.elementToBeSelected(By.className(selectorValue)));
                break;
            case "xpath": wait.until(ExpectedConditions.elementToBeSelected(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotEnabled(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(selectorValue))));
                break;
            case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.name(selectorValue))));
                break;
            case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.className(selectorValue))));
                break;
            case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(selectorValue))));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsClickable(String selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case "id": wait.until(ExpectedConditions.elementToBeClickable(By.id(selectorValue)));
                break;
            case "name": wait.until(ExpectedConditions.elementToBeClickable(By.name(selectorValue)));
                break;
            case "class": wait.until(ExpectedConditions.elementToBeClickable(By.className(selectorValue)));
                break;
            case "xpath": wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotClickable(String selectorType, String selectorValue, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case "id": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(selectorValue))));
                break;
            case "name": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.name(selectorValue))));
                break;
            case "class": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className(selectorValue))));
                break;
            case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(selectorValue))));
                break;
            default:
                break;
        }
    }

    public static void waitUntilElementContains(String selectorType, String selectorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case "id": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(selectorValue), text));
                break;
            case "name": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(selectorValue), text));
                break;
            case "class": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(selectorValue), text));
                break;
            case "xpath": wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(selectorValue), text));
                break;
            default:
                break;
        }
    }

    public static void waitUntilElementDoesNotContain(String selectorType, String selectorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case "id": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id(selectorValue), text)));
                break;
            case "name": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.name(selectorValue), text)));
                break;
            case "class": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.className(selectorValue), text)));
                break;
            case "xpath": wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(selectorValue), text)));
                break;
            default:
                break;
        }
    }
}
