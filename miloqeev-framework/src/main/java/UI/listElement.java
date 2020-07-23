package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static UI.browserManagement.getDriver;
import static UI.element.findElementBy;
import static UI.element.getElementCount;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class listElement {

    /**
     * Returns all labels of list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void getListItems(String locatorType, String locatorValue){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            List<WebElement> options  = select.getOptions();
            int i = 1;
            for(WebElement item:options)
            {
                logInfo.pass("Dropdown value No. " + i + ": '" + item.getText() + "'");
                i ++;
            }
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find list of element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Selects element by label from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param label
     */
    public static void selectFromListByLabel(String locatorType, String locatorValue, String label){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.selectByVisibleText(label);
            logInfo.pass("Selected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by label='" + label + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list label='" + label + "'"), e);
        }
    }

    /**
     * Selects element by value from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param value
     */
    public static void selectFromListByValue(String locatorType, String locatorValue, String value){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.selectByValue(value);
            logInfo.pass("Selected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by value='" + value + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list value='" + value + "'"), e);
        }
    }

    /**
     * Selects element by index from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param index
     */
    public static void selectFromListByIndex(String locatorType, String locatorValue, int index){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.selectByIndex(index);
            logInfo.pass("Selected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by index='" + index + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list index='" + index + "'"), e);
        }
    }

    /**
     * Deselects element by label from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param label
     */
    public static void deselectFromListByLabel(String locatorType, String locatorValue, String label){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.deselectByVisibleText(label);
            logInfo.pass("Deselected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by label='" + label + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list label='" + label + "'"), e);
        }
    }

    /**
     * Deselects element by value from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param value
     */
    public static void deselectFromListByValue(String locatorType, String locatorValue, String value){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.deselectByValue(value);
            logInfo.pass("Deselected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by value='" + value + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list value='" + value + "'"), e);
        }
    }

    /**
     * Deselects element by index from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param index
     */
    public static void deselectFromListByIndex(String locatorType, String locatorValue, int index){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.deselectByIndex(index);
            logInfo.pass("Deselected item from Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "by index='" + index + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Dropdown located by '" + locatorType + "=" + locatorValue + "' did not contain list index='" + index + "'"), e);
        }
    }

    /**
     * Verifies that list identified by `locator` has no selection.
     * @param locatorType
     * @param locatorValue
     */
    public static void listSelectionShouldBeEmpty(String locatorType, String locatorValue){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            select.deselectAll();
            logInfo.pass("Dropdown located by '" + locatorType + "=" + locatorValue + "' " + "has no selection");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find list of element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Verifies that list identified by `locator` is present.
     * @param locatorType
     * @param locatorValue
     */
    public static void pageShouldContainList(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            int actualNumberOfElements = numberOfElements;
            Assert.assertNotEquals(0, actualNumberOfElements, "Page does not contain list located by '" + locatorType + "=" + locatorValue + "'");
            logInfo.pass("Validated presence of list located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page does not contain list located by '" + locatorType + "=" + locatorValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that list identified by `locator` is not present.
     * @param locatorType
     * @param locatorValue
     */
    public static void pageShouldNotContainList(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            Assert.assertEquals(0, numberOfElements);
            logInfo.pass("Validated no presence of list located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page contains list located by '" + locatorType + "=" + locatorValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Selects all elements from list identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void selectAllFromList(String locatorType, String locatorValue){
        try{
            WebElement list = findElementBy(locatorType, locatorValue);
            Select select = new Select(list);
            List<WebElement> options  = select.getOptions();
            for(WebElement item:options)
            {
                select.selectByVisibleText(item.getText());
            }
            logInfo.pass("Selected all elements from Dropdown located by '" + locatorType + "=" + locatorValue + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find list of element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }
}
