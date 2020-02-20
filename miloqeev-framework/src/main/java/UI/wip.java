package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class wip extends browserManagement{

    public static void inputText(String selectorType, String selectorValue, String text) throws Throwable{
        try {
            WebElement element = findElementBy(selectorType, selectorValue);
            element.sendKeys(text);
            logInfo.pass("Entered '" + text + "' in element selected by '" + selectorType + " = " + selectorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e);
        }
    }

    public static void inputTextAndSubmit(String selectorType, String selectorValue, String text){
        WebElement element = findElementBy(selectorType, selectorValue);
        element.sendKeys(text);
        element.submit();
    }

    public static WebElement findElementBy(String selectorType, String selectorValue){
        WebElement tmp = null;
        switch (selectorType){
            case "id": tmp = driver.findElement(By.id(selectorValue));
                break;
            case "name": tmp = driver.findElement(By.name(selectorValue));
                break;
            case "class": tmp = driver.findElement(By.className(selectorValue));
                break;
            case "xpath": tmp = driver.findElement(By.xpath(selectorValue));
                break;
            default: break;
        }
        return tmp;
    }

    public static void findElementsBy(String selectorType, String selectorValue){
        switch (selectorType){
            case "id": driver.findElements(By.id(selectorValue));
                break;
            case "name": driver.findElements(By.name(selectorValue));
                break;
            case "class": driver.findElements(By.className(selectorValue));
                break;
            case "xpath": driver.findElements(By.xpath(selectorValue));
                break;
            default: break;
        }
    }

    public static void clickElement(String selectorType, String selectorValue)throws Throwable{
        try {
            WebElement element = findElementBy(selectorType, selectorValue);
            element.click();
            logInfo.pass("Clicked element selected by '" + selectorType + " = " + selectorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e);
        }
    }

    public static void PageShouldContainElement(String selectorType, String selectorValue) throws Throwable{
        try {
            int numberOfElements = getElementCount(selectorType, selectorValue);
            int expectedNumberOfElements = 0;
            int actualNumberOfElements = numberOfElements;
            Assert.assertNotEquals(expectedNumberOfElements, actualNumberOfElements, "Page does not contain element");
            logInfo.pass("Validated presence of element");

        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo,e);
            logInfo.fail(e.getCause());
        }
    }

    public static void PageShouldNotContainElement(String selectorType, String selectorValue){
        int numberOfElements = getElementCount(selectorType, selectorValue);
        Assert.assertEquals(0, numberOfElements);
    }

    public static int getElementCount(String selectorType, String selectorValue){
        int elementCount = 0;
        switch (selectorType){
            case "id": elementCount = driver.findElements(By.id(selectorValue)).size();
                break;
            case "name": elementCount = driver.findElements(By.name(selectorValue)).size();
                break;
            case "class": elementCount = driver.findElements(By.className(selectorValue)).size();
                break;
            case "xpath": elementCount = driver.findElements(By.xpath(selectorValue)).size();
                break;
            default: break;
        }
        return elementCount;
    }
}
