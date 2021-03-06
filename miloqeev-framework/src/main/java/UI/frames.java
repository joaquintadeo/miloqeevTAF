package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static UI.browserManagement.getDriver;
import static UI.element.findElementBy;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class frames {

    /**
     * Sets frame identified by `locator` as the current frame.
     * @param locator
     */
    public static void selectFrame(String locator){
        try{
            WebElement element = findElementBy(locator);
            getDriver().switchTo().frame(element);
            logInfo.pass("Selecting frame located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to select frame located by '" + locator + "'"), e);
        }
    }

    /**
     * Sets the main frame as the current frame.
     */
    public static void unselectFrame(){
        try{
            getDriver().switchTo().defaultContent();
            logInfo.pass("Switched to default frame");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to switch to default frame"), e);
        }
    }

    /**
     * Verifies that current frame contains `text`.
     * @param text
     */
    public static void currentFrameShouldContain(String text){
        try {
            int elementCount = getDriver().findElements(By.tagName(text)).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Current frame contains text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Current frame did not contain text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current frame does not contain `text`.
     * @param text
     */
    public static void currentFrameShouldNotContain(String text){
        try {
            int elementCount = getDriver().findElements(By.tagName(text)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Current frame does not contain text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Current frame contained text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that frame identified by `locator` contains `text`.
     * @param locator
     * @param text
     */
    public static void frameShouldContain(String locator, String text){
        try{
            WebElement element = findElementBy(locator);
            getDriver().switchTo().frame(element);
            int elementCount = getDriver().findElements(By.tagName(text)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Frame located by '" + locator + "' contains text='" + text + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Frame located by '" + locator + "' did not contain text='" + text + "'"), e);
        }
    }
}
