package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static testListeners.extentReportListener.*;
import static UI.browserManagement.getDriver;

public class element {

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
                case "id": tmp = getDriver().findElement(By.id(locatorValue));
                    break;
                case "name": tmp = getDriver().findElement(By.name(locatorValue));
                    break;
                case "class": tmp = getDriver().findElement(By.className(locatorValue));
                    break;
                case "xpath": tmp = getDriver().findElement(By.xpath(locatorValue));
                    break;
                default: break;
            }
            logInfo.pass("Found element located by '" + locatorType + "=" + locatorValue + "' and saved to variable");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find element located by '" + locatorType + "=" + locatorValue + "'"), e);
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
                case "id": getDriver().findElements(By.id(locatorValue));
                    break;
                case "name": getDriver().findElements(By.name(locatorValue));
                    break;
                case "class": getDriver().findElements(By.className(locatorValue));
                    break;
                case "xpath": getDriver().findElements(By.xpath(locatorValue));
                    break;
                default: break;
            }
            logInfo.pass("Found all elements located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find elements located by '" + locatorType + "=" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not submit form located by '" + locatorType + "=" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter text in element located by '" + locatorType + "=" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter 'text=" + text + "' and submit form in element located by '" + locatorType + "=" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter password in element located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
    }

    /**
     * Verifies checkbox `locator` is found from current page.
     */
    public static void pageShouldContainCheckbox() {
        try {
            WebElement checkbox = getDriver().findElement(By.xpath("//*[@type='checkbox']"));
            checkbox.isDisplayed();
            logInfo.pass("Page contains checkbox");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Page does not contain checkbox"), e);
        }
    }

    /**
     * Verifies radio button `locator` is found from current page.
     */
    public static void pageShouldContainRadioButton() {
        try {
            WebElement checkbox = getDriver().findElement(By.xpath("//*[@type='radio']"));
            checkbox.isDisplayed();
            logInfo.pass("Page contains radio button");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Page does not contain radio button"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not click checkbox"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not click radio button"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save element's value to variable"), e);
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
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + "=" + locatorValue + "' was not clickable"), e);
        }
    }

    /**
     * Verifies that element `locator` is found on the current page.
     * @param locatorType
     * @param locatorValue
     */
    public static void pageShouldContainElement(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            int expectedNumberOfElements = 0;
            int actualNumberOfElements = numberOfElements;
            Assert.assertNotEquals(expectedNumberOfElements, actualNumberOfElements, "Page does not contain element located by '" + locatorType + "=" + locatorValue + "'");
            logInfo.pass("Validated presence of element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page does not contain element located by '" + locatorType + "=" + locatorValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that element `locator` is not found on the current page.
     * @param locatorType
     * @param locatorValue
     */
    public static void pageShouldNotContainElement(String locatorType, String locatorValue){
        try {
            int numberOfElements = getElementCount(locatorType, locatorValue);
            Assert.assertEquals(0, numberOfElements);
            logInfo.pass("Validated no presence of element located by '" + locatorType + "=" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page contains element located by '" + locatorType + "=" + locatorValue + "'"),e);
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
            case "id": elementCount = getDriver().findElements(By.id(locatorValue)).size();
                break;
            case "name": elementCount = getDriver().findElements(By.name(locatorValue)).size();
                break;
            case "class": elementCount = getDriver().findElements(By.className(locatorValue)).size();
                break;
            case "xpath": elementCount = getDriver().findElements(By.xpath(locatorValue)).size();
                break;
            default: break;
        }
        return elementCount;
    }

    /**
     * Verifies that element identified by `locator` contains text `expected`.
     * @param locatorType
     * @param locatorValue
     * @param expectedValue
     */
    public static void elementShouldContain(String locatorType, String locatorValue, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actualValue = element.getText();
            Assert.assertEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' contained expected value '" + expectedValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected value '" + expectedValue + "'"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` does not contain text `expected`.
     * @param locatorType
     * @param locatorValue
     * @param expectedValue
     */
    public static void elementShouldNotContain(String locatorType, String locatorValue, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actualValue = element.getText();
            Assert.assertNotEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected value '" + expectedValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' contained expected value '" + expectedValue + "'"), e);
        }
    }

    /**
     * Verifies that current page contains `link text`.
     * @param linkText
     */
    public static void pageShouldContainLink(String linkText){
        try {
            int elementCount = getDriver().findElements(By.linkText(linkText)).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Page contains link text='" + linkText + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page did not contain link text='" + linkText + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page does not contain `link text`.
     * @param linkText
     */
    public static void pageShouldNotContainLink(String linkText){
        try {
            int elementCount = getDriver().findElements(By.linkText(linkText)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Page does not contain link text='" + linkText + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page contains link text='" + linkText + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page contains `text`.
     * @param text
     */
    public static void pageShouldContain(String text){
        try {
            int elementCount = getDriver().findElements(By.xpath("//*[@text()='" + text + "']")).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Page contains text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page did not contain text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page does not contain `text`.
     * @param text
     */
    public static void pageShouldNotContain(String text){
        try {
            int elementCount = getDriver().findElements(By.xpath("//*[@text()='" + text + "']")).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Page does not contain text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page contains text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    public static void assignIdToElement(String locatorType, String locatorValue, String newId){
        try {
            String id = "id";
            WebElement element = findElementBy(locatorType, locatorValue);
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, id, newId);
            logInfo.pass("Set element id='" + newId + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Could not set element id='" + newId + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    public static void setElementAttribute(String locatorType, String locatorValue, String attrName, String attrValue){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attrName, attrValue);
            logInfo.pass("Set element " + attrName + "='" + attrValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Could not set element " + attrName + "='" + attrValue + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that element identified with `locator` is disabled.
     * @param locatorType
     * @param locatorValue
     */
    public static void elementShouldBeDisabled(String locatorType, String locatorValue){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            Assert.assertFalse(element.isEnabled());
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is disabled");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is enabled"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is enabled.
     * @param locatorType
     * @param locatorValue
     */
    public static void elementShouldBeEnabled(String locatorType, String locatorValue){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            Assert.assertTrue(element.isEnabled());
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is enabled");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is disabled"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is focused.
     * @param locatorType
     * @param locatorValue
     */
    public static void elementShouldBeFocused(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element).perform();
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is focused");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is not focused"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is visible.
     * @param locatorType
     * @param locatorValue
     */
    public static void elementShouldBeVisible(String locatorType, String locatorValue) {
        boolean tmp = false;
        try {
            switch (locatorType) {
                case "id":
                    tmp = getDriver().findElement(By.id(locatorValue)).isDisplayed();
                    break;
                case "name":
                    tmp = getDriver().findElement(By.name(locatorValue)).isDisplayed();
                    break;
                case "class":
                    tmp = getDriver().findElement(By.className(locatorValue)).isDisplayed();
                    break;
                case "xpath":
                    tmp = getDriver().findElement(By.xpath(locatorValue)).isDisplayed();
                    break;
                default:
                    break;
            }
            if (tmp)
                logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is not visible"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` contains text `expected`.
     * @param locatorType
     * @param locatorValue
     * @param expectedValue
     */
    public static void elementTextShouldBe(String locatorType, String locatorValue, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actualValue = element.getText();
            Assert.assertEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' contained expected text '" + expectedValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected text '" + expectedValue + "'"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` not contains text `expected`.
     * @param locatorType
     * @param locatorValue
     * @param expectedValue
     */
    public static void elementTextShouldNotBe(String locatorType, String locatorValue, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actualValue = element.getText();
            Assert.assertNotEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected text '" + expectedValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' contained expected text '" + expectedValue + "'"), e);
        }
    }

    /**
     * Returns attribute of `element` identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static String getElementAttribute(String locatorType, String locatorValue){
        String attribute = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            attribute = element.getAttribute("attribute");
            logInfo.pass("Saved element's attribute='" + attribute + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save element's attribute to variable"), e);
        }
        return attribute;
    }

    /**
     * Verifies element identified by `locator` contains expected attribute value.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static void elementAttributeShouldBe(String locatorType, String locatorValue, String expectedAttribute){
        String actualAttribute = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actualAttribute = element.getAttribute("attribute");
            Assert.assertEquals(actualAttribute, expectedAttribute);
            logInfo.pass("Element attribute located by '" + locatorType + "=" + locatorValue + "' contains value: '" + expectedAttribute + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element attribute should have been: '" + expectedAttribute + "' but it was: '" + actualAttribute + "'"), e);
        }
    }

    /**
     * Returns horizontal position of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static int getHorizontalPosition(String locatorType, String locatorValue){
        int horizontalPosition = 0;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            horizontalPosition = element.getLocation().getX();
            logInfo.pass("Saved to variable horizontal position of element located by" + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable horizontal position of element located by" + locatorType + "='" + locatorValue + "'"), e);
        }
        return horizontalPosition;
    }

    /**
     * Returns vertical position of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static int getVerticalPosition(String locatorType, String locatorValue){
        int varticalPosition = 0;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            varticalPosition = element.getLocation().getY();
            logInfo.pass("Saved to variable vertical position of element located by" + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable vertical position of element located by" + locatorType + "='" + locatorValue + "'"), e);
        }
        return varticalPosition;
    }

    /**
     * Returns width and height of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static Dimension getElementSize(String locatorType, String locatorValue){
        Dimension elementSize = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            elementSize = element.getSize();
            logInfo.pass("Saved to variable dimension of element located by " + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable dimension of element located by" + locatorType + "='" + locatorValue + "'"), e);
        }
        return elementSize;
    }

    /**
     * Returns value of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static String getElementValue(String locatorType, String locatorValue){
        String elementValue = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            elementValue = element.getAttribute("value");
            logInfo.pass("Saved to variable value of element located by" + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable value of element located by " + locatorType + "='" + locatorValue + "'"), e);
        }
        return elementValue;
    }

    /**
     * Returns text of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @return
     */
    public static String getElementText(String locatorType, String locatorValue){
        String elementText = null;
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            elementText = element.getText();
            logInfo.pass("Saved to variable text of element located by" + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable text of element located by " + locatorType + "='" + locatorValue + "'"), e);
        }
        return elementText;
    }

    /**
     * Returns text of element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void clearElementText(String locatorType, String locatorValue){
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            element.clear();
            logInfo.pass("Saved to variable text of element located by " + locatorType + "='" + locatorValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable text of element located by " + locatorType + "='" + locatorValue + "'"), e);
        }
    }

    /**
     * Clicks button identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void clickButton(String locatorType, String locatorValue){
        try {
            WebElement element = getDriver().findElement(By.xpath("//button[@" + locatorType + "='" + locatorValue + "']"));
            element.click();
            logInfo.pass("Clicked element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locatorType + "=" + locatorValue + "' was not clickable"), e);
        }
    }

    /**
     * Click element `locator` at `xoffset/yoffset`.
     * @param locatorType
     * @param locatorValue
     * @param xoffset
     * @param yoffset
     */
    public static void clickElementAtCoordinates(String locatorType, String locatorValue, int xoffset, int yoffset){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element);
            actions.moveByOffset(xoffset,yoffset).click().perform();
            logInfo.pass("Clicked element located by '" + locatorType + " = " + locatorValue + "' at coordinates '" + xoffset + ", " + yoffset + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to click element located by '" + locatorType + " = " + locatorValue + "' at coordinates '" + xoffset + ", " + yoffset + "'"), e);
        }
    }

    /**
     * Double click element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void doubleClickElement(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element).doubleClick().perform();
            logInfo.pass("Double clicked element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to double click element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Sets focus to element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void setFocusToElement(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element).perform();
            logInfo.pass("Set focus on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to focus element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Drags element identified by `locator` into `target` element.
     * @param locatorType
     * @param locatorValue
     * @param targetType
     * @param targetValue
     */
    public static void dragAndDrop(String locatorType, String locatorValue, String targetType, String targetValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            WebElement target = findElementBy(targetType, targetValue);
            actions.dragAndDrop(element, target).perform();
            logInfo.pass("Drag element located by '" + locatorType + " = " + locatorValue + "' and dropped into target located by '" + targetType + "=" + targetValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to drag element located by '" + locatorType + " = " + locatorValue + "' and dropped into target located by '" + targetType + "=" + targetValue + "'"), e);
        }
    }

    /**
     * Drags element identified with `locator` by `xoffset/yoffset`.
     * @param locatorType
     * @param locatorValue
     * @param xoffset
     * @param yoffset
     */
    public static void dragAndDropByOffset(String locatorType, String locatorValue, int xoffset, int yoffset){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.dragAndDropBy(element, xoffset, yoffset).perform();
            logInfo.pass("Drag element located by '" + locatorType + " = " + locatorValue + "' and dropped at coordinates '" + xoffset + ", " + yoffset + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to drag element located by '" + locatorType + " = " + locatorValue + "' and dropped at coordinates '" + xoffset + ", " + yoffset + "'"), e);
        }
    }

    /**
     * Simulates pressing the left mouse button on the element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void mouseDown(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.clickAndHold(element).perform();
            logInfo.pass("Simulating Mouse Down on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Down on element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Simulates mouse over the element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void mouseOver(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element).perform();
            logInfo.pass("Simulating Mouse Over on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Over on element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Simulates releasing the left mouse button on the element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void mouseUp(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.release(element).perform();
            logInfo.pass("Simulating Mouse Up on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Up on element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Opens context menu on element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void openContextMenu(String locatorType, String locatorValue){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.contextClick(element).perform();
            logInfo.pass("Context menu opened on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to open context menu on element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }

    /**
     * Simulates preesing `key` on element identified by `locator`.
     * @param locatorType
     * @param locatorValue
     * @param key
     */
    public static void pressKey(String locatorType, String locatorValue, String key){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.sendKeys(element, key);
            logInfo.pass("Pressing key '" + key + "' on element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to press key '" + key + "' on element located by '" + locatorType + " = " + locatorValue + "'"), e);
        }
    }
}
