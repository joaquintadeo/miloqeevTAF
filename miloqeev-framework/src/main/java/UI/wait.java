package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait extends browserManagement{

    public static void waitUntilPageContainsElement(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilPageDoesNotContainElement(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue))));
                break;
            case utils.NAME: wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue))));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue))));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue))));
                break;
            default: break;
        }
    }

    public static void waitUntilPageContains(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }

    public static void waitUntilPageDoesNotContain(String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text)));
    }

    public static void waitUntilElementIsVisible(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotVisible(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsEnabled(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.elementToBeSelected(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.elementToBeSelected(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.elementToBeSelected(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.elementToBeSelected(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotEnabled(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id(selectorValue))));
                break;
            case utils.NAME: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.name(selectorValue))));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.className(selectorValue))));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.xpath(selectorValue))));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsClickable(int selectorType, String selectorValue, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.elementToBeClickable(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.elementToBeClickable(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.elementToBeClickable(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }

    public static void waitUntilElementIsNotClickable(int selectorType, String selectorValue, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case utils.ID: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id(selectorValue))));
                break;
            case utils.NAME: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.name(selectorValue))));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className(selectorValue))));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(selectorValue))));
                break;
            default:
                break;
        }
    }

    public static void waitUntilElementContains(int selectorType, String selectorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case utils.ID: wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(selectorValue), text));
                break;
            case utils.NAME: wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(selectorValue), text));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(selectorValue), text));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(selectorValue), text));
                break;
            default:
                break;
        }
    }

    public static void waitUntilElementDoesNotContain(int selectorType, String selectorValue, String text, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (selectorType) {
            case utils.ID: wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id(selectorValue), text)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.name(selectorValue), text)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.className(selectorValue), text)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(selectorValue), text)));
                break;
            default:
                break;
        }
    }
}
