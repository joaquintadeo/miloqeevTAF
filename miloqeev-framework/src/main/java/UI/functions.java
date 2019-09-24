package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class functions extends browserManagement{

    public static void inputText(int selectorType, String selectorValue, String text){
        WebElement element = findElementBy(selectorType, selectorValue);
        element.sendKeys(text);
    }

    public static void inputTextAndSubmit(int selectorType, String selectorValue, String text){
        WebElement element = findElementBy(selectorType, selectorValue);
        element.sendKeys(text);
        element.submit();
    }

    public static WebElement findElementBy(int selectorType, String selectorValue){
        WebElement tmp = null;
        switch (selectorType){
            case utils.ID: tmp = driver.findElement(By.id(selectorValue));
                break;
            case utils.NAME: tmp = driver.findElement(By.name(selectorValue));
                break;
            case utils.CLASSNAME: tmp = driver.findElement(By.className(selectorValue));
                break;
            case utils.XPATH: tmp = driver.findElement(By.xpath(selectorValue));
                break;
            default: break;
        }
        return tmp;
    }

    public static void findElementsBy(int selectorType, String selectorValue){
        switch (selectorType){
            case utils.ID: driver.findElements(By.id(selectorValue));
                break;
            case utils.NAME: driver.findElements(By.name(selectorValue));
                break;
            case utils.CLASSNAME: driver.findElements(By.className(selectorValue));
                break;
            case utils.XPATH: driver.findElements(By.xpath(selectorValue));
                break;
            default: break;
        }
    }

    public static void waitUntilPageContainsElement(int selectorType, String selectorValue){
        WebDriverWait wait = new WebDriverWait(driver,40);
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

    public static void clickElement(int selectorType, String selectorValue){
        WebElement element = findElementBy(selectorType, selectorValue);
        element.click();
    }

    public static void PageShouldContainElement(int selectorType, String selectorValue){
        int numberOfElements = getElementCount(selectorType, selectorValue);
        Assert.assertNotEquals(0, numberOfElements);
    }

    public static void PageShouldNotContainElement(int selectorType, String selectorValue){
        int numberOfElements = getElementCount(selectorType, selectorValue);
        Assert.assertEquals(0, numberOfElements);
    }

    public static int getElementCount(int selectorType, String selectorValue){
        int elementCount = 0;
        switch (selectorType){
            case utils.ID: elementCount = driver.findElements(By.id(selectorValue)).size();
                break;
            case utils.NAME: elementCount = driver.findElements(By.name(selectorValue)).size();
                break;
            case utils.CLASSNAME: elementCount = driver.findElements(By.className(selectorValue)).size();
                break;
            case utils.XPATH: elementCount = driver.findElements(By.xpath(selectorValue)).size();
                break;
            default: break;
        }
        return elementCount;
    }
}
