package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static UI.element.findElementBy;

public class frames extends browserManagement{

    /**
     * Sets frame identified by `locator` as the current frame.
     * @param locatorType
     * @param locatorValue
     */
    public static void selectFrame(String locatorType, String locatorValue){
        try{
            WebElement element = findElementBy(locatorType, locatorValue);
            driver.switchTo().frame(element);
            logInfo.pass("Selecting frame located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Unable to select frame located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Sets the main frame as the current frame.
     */
    public static void unselectFrame(){
        try{
            driver.switchTo().defaultContent();
            logInfo.pass("Switched to default frame");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Unable to switch to default frame"), e);
        }
    }

    /**
     * Verifies that current frame contains `text`.
     * @param text
     */
    public static void currentFrameShouldContain(String text){
        try {
            int elementCount = driver.findElements(By.tagName(text)).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Current frame contains text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Current frame did not contain text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current frame does not contain `text`.
     * @param text
     */
    public static void currentFrameShouldNotContain(String text){
        try {
            int elementCount = driver.findElements(By.tagName(text)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Current frame does not contain text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Current frame contained text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that frame identified by `locator` contains `text`.
     * @param locatorType
     * @param locatorValue
     * @param text
     */
    public static void frameShouldContain(String locatorType, String locatorValue, String text){
        try{
            WebElement element = findElementBy(locatorType, locatorValue);
            driver.switchTo().frame(element);
            int elementCount = driver.findElements(By.tagName(text)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Frame located by '" + locatorType + "=" + locatorValue + "' contains text='" + text + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Frame located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + text + "'"), e);
        }
    }
}
