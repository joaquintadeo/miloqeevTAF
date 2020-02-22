package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class element extends browserManagement{

    /**
     * Finds and return `element` by given locator.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static WebElement findElementBy(String locatorType, String locatorValue){
        WebElement tmp = null;
        try{
            switch (locatorType){
                case "id": tmp = driver.findElement(By.id(locatorValue));
                    break;
                case "name": tmp = driver.findElement(By.name(locatorValue));
                    break;
                case "class": tmp = driver.findElement(By.className(locatorValue));
                    break;
                case "xpath": tmp = driver.findElement(By.xpath(locatorValue));
                    break;
                default: break;
            }
            logInfo.pass("Found element located by '" + locatorType + "=" + locatorValue + "' and saved to variable");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not find element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
        return tmp;
    }

    /**
     * Finds all `elements` by given locator.
     * @param locatorType
     * @param locatorValue
     */
    public static void findElementsBy(String locatorType, String locatorValue){
        try{
            switch (locatorType){
                case "id": driver.findElements(By.id(locatorValue));
                    break;
                case "name": driver.findElements(By.name(locatorValue));
                    break;
                case "class": driver.findElements(By.className(locatorValue));
                    break;
                case "xpath": driver.findElements(By.xpath(locatorValue));
                    break;
                default: break;
            }
            logInfo.pass("Found all elements located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not find elements located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Submits a `form` identified by locator.
     * @param locatorType
     * @param locatorValue
     */
    public static void submitForm(String locatorType, String locatorValue){
        try{
            WebElement element = findElementBy(locatorType, locatorValue);
            element.submit();
            logInfo.pass("Submitted form located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not submit form located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Types the given `text` into text field identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param text
     */
    public static void inputText(String locatorType, String locatorValue, String text){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            element.sendKeys(text);
            logInfo.pass("Entered '" + text + "' in element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not enter text in element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Types the given `text` into text field identified by `locator` and submits form.
     * @param locatorType
     * @param locatorValue
     * @param text
     */
    public static void inputTextAndSubmit(String locatorType, String locatorValue, String text){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            element.sendKeys(text);
            element.submit();
            logInfo.pass("Entered '" + text + "' and submitted form in element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not enter 'text=" + text + "' and submit form in element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Types the given `password` into password field identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param password
     */
    public static void inputPassword(String locatorType, String locatorValue, String password){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            element.sendKeys(password);
            logInfo.pass("Entered 'password' in element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Could not enter password in element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Verifies checkbox `locator` is found from current page.
     */
    public static void pageShouldContainCheckbox() {
        try {
            WebElement checkbox = driver.findElement(By.xpath("//*[@type='checkbox']"));
            checkbox.isDisplayed();
            logInfo.pass("Page contains checkbox");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Page does not contain checkbox"), e);
        }
    }

    /**
     * Verifies radio button `locator` is found from current page.
     */
    public static void pageShouldContainRadioButton() {
        try {
            WebElement checkbox = driver.findElement(By.xpath("//*[@type='radio']"));
            checkbox.isDisplayed();
            logInfo.pass("Page contains radio button");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Page does not contain radio button"), e);
        }
    }

    /**
     * Selects checkbox identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void selectCheckbox(String locatorType, String locatorValue) {
        try {
            WebElement checkbox = findElementBy(locatorType, locatorValue);
            checkbox.click();
            logInfo.pass("Checkbox clicked");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Could not click checkbox"), e);
        }
    }

    /**
     * Selects radio button identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void selectRadioButton(String locatorType, String locatorValue) {
        try {
            WebElement checkbox = findElementBy(locatorType, locatorValue);
            checkbox.click();
            logInfo.pass("Radio button clicked");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Could not click radio button"), e);
        }
    }

    /**
     * Returns value of `element` identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static String getValue(String locatorType, String locatorValue) {
        String value = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            value = element.getAttribute("value");
            logInfo.pass("Saved element's value='" + value + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo.fail("Could not save element's value to variable"), e);
        }
        return value;
    }

    /**
     * Clicks `element` identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void clickElement(String locatorType, String locatorValue){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            element.click();
            logInfo.pass("Clicked element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + "=" + locatorValue + "' was not clickable"), e);
        }
    }

    /**
     * Verifies that element `locator` is found on the current page.
     * @param locatorType
     * @param locatorValue
     */
    public static void PageShouldContainElement(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            int expectedNumberOfElements = 0;
            int actualNumberOfElements = numberOfElements;
            Assert.assertNotEquals(expectedNumberOfElements, actualNumberOfElements, "Page does not contain element located by '" + locatorType + "=" + locatorValue + "'");
            logInfo.pass("Validated presence of element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page does not contain element located by '" + locatorType + "=" + locatorValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that element `locator` is not found on the current page.
     * @param locatorType
     * @param locatorValue
     */
    public static void PageShouldNotContainElement(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            Assert.assertEquals(0, numberOfElements);
            logInfo.pass("Validated no presence of element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page contains element located by '" + locatorType + "=" + locatorValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns number of elements matching `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static int getElementCount(String locatorType, String locatorValue){
        int elementCount = 0;
        switch (locatorType){
            case "id": elementCount = driver.findElements(By.id(locatorValue)).size();
                break;
            case "name": elementCount = driver.findElements(By.name(locatorValue)).size();
                break;
            case "class": elementCount = driver.findElements(By.className(locatorValue)).size();
                break;
            case "xpath": elementCount = driver.findElements(By.xpath(locatorValue)).size();
                break;
            default: break;
        }
        return elementCount;
    }
}
