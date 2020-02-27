package UI;

import org.openqa.selenium.WebElement;

import static UI.element.findElementBy;

public class frames extends browserManagement{

    /**
     *
     * @param locatorType
     * @param locatorValue
     */
    public static void selectFrame(String locatorType, String locatorValue){
        try{
            WebElement element = findElementBy(locatorType, locatorValue);
            driver.switchTo().frame(element);
            logInfo.pass("Submitted form located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not submit form located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }
}
