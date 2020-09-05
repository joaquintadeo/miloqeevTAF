package UI;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static UI.browserManagement.getDriver;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class element {

    private static String locatorType;
    private static String locatorValue;

    public static String getLocatorType() {
        return locatorType;
    }

    public static String getLocatorValue() {
        return locatorValue;
    }

    public static void separateElementLocatorTypeFromValue(String element){
        locatorType = StringUtils.substringBefore(element, "=");
        locatorValue = StringUtils.substringAfter(element, "=");
    }
    /**
     * Finds and return `element` by given locator.
     * @param locator
     * @return
     */
    public static WebElement findElementBy(String locator){
        separateElementLocatorTypeFromValue(locator);
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
            logInfo.pass("Found element located by '" + locator + "' and saved to variable");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find element located by '" + locator + "'"), e);
        }
        return tmp;
    }

    /**
     * Finds all `elements` by given locator.
     * @param locator
     */
    public static void findElementsBy(String locator){
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
            logInfo.pass("Found all elements located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find elements located by '" + locator + "'"), e);
        }
    }

    /**
     * Submits a `form` identified by locator.
     * @param locator
     */
    public static void submitForm(String locator){
        try{
            WebElement element = findElementBy(locator);
            element.submit();
            logInfo.pass("Submitted form located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not submit form located by '" + locator + "'"), e);
        }
    }

    /**
     * Types the given `text` into text field identified by `locator`.
     * @param locator
     * @param text
     */
    public static void inputText(String locator, String text){
        try {
            WebElement element = findElementBy(locator);
            element.sendKeys(text);
            logInfo.pass("Entered '" + text + "' in element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter text in element located by '" + locator + "'"), e);
        }
    }

    /**
     * Types the given `text` into text field identified by `locator` and submits form.
     * @param locator
     * @param text
     */
    public static void inputTextAndSubmit(String locator, String text){
        try {
            WebElement element = findElementBy(locator);
            element.sendKeys(text);
            element.submit();
            logInfo.pass("Entered '" + text + "' and submitted form in element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter 'text=" + text + "' and submit form in element located by '" + locator + "'"), e);
        }
    }

    /**
     * Types the given `password` into password field identified by `locator`.
     * @param locator
     * @param password
     */
    public static void inputPassword(String locator, String password){
        try {
            WebElement element = findElementBy(locator);
            element.sendKeys(password);
            logInfo.pass("Entered 'password' in element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not enter password in element located by '" + locator + "'"), e);
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
     * @param locator
     */
    public static void selectCheckbox(String locator) {
        try {
            WebElement checkbox = findElementBy(locator);
            checkbox.click();
            logInfo.pass("Checkbox clicked");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not click checkbox"), e);
        }
    }

    /**
     * Selects radio button identified by `locator`.
     * @param locator
     */
    public static void selectRadioButton(String locator) {
        try {
            WebElement checkbox = findElementBy(locator);
            checkbox.click();
            logInfo.pass("Radio button clicked");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not click radio button"), e);
        }
    }

    /**
     * Returns value of `element` identified by `locator`.
     * @param locator
     * @return
     */
    public static String getValue(String locator) {
        String value = null;
        try {
            WebElement element = findElementBy(locator);
            value = element.getAttribute("value");
            logInfo.pass("Saved element's value='" + value + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save element's value to variable"), e);
        }
        return value;
    }

    /**
     * Clicks `element` identified by `locator`.
     * @param locator
     */
    public static void clickElement(String locator){
        try {
            WebElement element = findElementBy(locator);
            element.click();
            logInfo.pass("Clicked element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' was not clickable"), e);
        }
    }

    /**
     * Verifies that element `locator` is found on the current page.
     * @param locator
     */
    public static void pageShouldContainElement(String locator){
        try {
            int numberOfElements = getElementCount(locator);
            int actualNumberOfElements = numberOfElements;
            Assert.assertNotEquals(0, actualNumberOfElements, "Page does not contain element located by '" + locator + "'");
            logInfo.pass("Validated presence of element located by '" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page does not contain element located by '" + locator + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that element `locator` is not found on the current page.
     * @param locator
     */
    public static void pageShouldNotContainElement(String locator){
        try {
            int numberOfElements = getElementCount(locator);
            Assert.assertEquals(0, numberOfElements);
            logInfo.pass("Validated no presence of element located by '" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Page contains element located by '" + locator + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns number of elements matching `locator`.
     * @param locator
     * @return
     */
    public static int getElementCount(String locator){
        int elementCount = 0;
        try {
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
            logInfo.pass("Element located by '" + locator + "' was found " + elementCount + " time(s)");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' was not found"), e);
        }
        return elementCount;
    }

    /**
     * Verifies that element identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedValue
     */
    public static void elementShouldContain(String locator, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locator);
            actualValue = element.getText();
            Assert.assertEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locator + "' contained expected value '" + expectedValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' did not contain expected value '" + expectedValue + "', instead was '" + actualValue + "'"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` does not contain text `expected`.
     * @param locator
     * @param expectedValue
     */
    public static void elementShouldNotContain(String locator, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locator);
            actualValue = element.getText();
            Assert.assertNotEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locator + "' did not contain expected value '" + expectedValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' contained expected value '" + expectedValue + "'"), e);
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
            int elementCount = getDriver().findElements(By.xpath("//*[text()='" + text + "']")).size();
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

    /**
     * Assigns given Id to element identified by `locator`.
     * @param locator
     * @param newId
     */
    public static void assignIdToElement(String locator, String newId){
        try {
            String id = "id";
            WebElement element = findElementBy(locator);
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, id, newId);
            logInfo.pass("Set element id='" + newId + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",getDriver(),logInfo.fail("Could not set element id='" + newId + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Assigns given Attribute to element identified by `locator`.
     * @param locator
     * @param attrName
     * @param attrValue
     */
    public static void setElementAttribute(String locator, String attrName, String attrValue){
        try {
            WebElement element = findElementBy(locator);
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
     * @param locator
     */
    public static void elementShouldBeDisabled(String locator){
        try {
            WebElement element = findElementBy(locator);
            Assert.assertFalse(element.isEnabled());
            logInfo.pass("Element located by '" + locator + "' is disabled");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' is enabled"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is enabled.
     * @param locator
     */
    public static void elementShouldBeEnabled(String locator){
        try {
            WebElement element = findElementBy(locator);
            Assert.assertTrue(element.isEnabled());
            logInfo.pass("Element located by '" + locator + "' is enabled");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' is disabled"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is focused.
     * @param locator
     */
    public static void elementShouldBeFocused(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.moveToElement(element).perform();
            logInfo.pass("Element located by '" + locator + "' is focused");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' is not focused"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is visible.
     * @param locator
     */
    public static void elementShouldBeVisible(String locator) {
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
                logInfo.pass("Element located by '" + locator + "' is visible");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' is not visible"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedValue
     */
    public static void elementTextShouldBe(String locator, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locator);
            actualValue = element.getText();
            Assert.assertEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locator + "' contained expected text '" + expectedValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' did not contain expected text '" + expectedValue + "'"), e);
        }
    }

    /**
     * Verifies that element identified by `locator` not contains text `expected`.
     * @param locator
     * @param expectedValue
     */
    public static void elementTextShouldNotBe(String locator, String expectedValue){
        String actualValue = null;
        try {
            WebElement element = findElementBy(locator);
            actualValue = element.getText();
            Assert.assertNotEquals(actualValue, expectedValue);
            logInfo.pass("Element located by '" + locator + "' did not contain expected text '" + expectedValue + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' contained expected text '" + expectedValue + "'"), e);
        }
    }

    /**
     * Returns attribute of `element` identified by `locator`.
     * @param locator
     * @return
     */
    public static String getElementAttribute(String locator){
        String attribute = null;
        try {
            WebElement element = findElementBy(locator);
            attribute = element.getAttribute("attribute");
            logInfo.pass("Saved element's attribute='" + attribute + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save element's attribute to variable"), e);
        }
        return attribute;
    }

    /**
     * Verifies element identified by `locator` contains expected attribute value.
     * @param locator
     * @return
     */
    public static void elementAttributeShouldBe(String locator, String expectedAttribute){
        String actualAttribute = null;
        try {
            WebElement element = findElementBy(locator);
            actualAttribute = element.getAttribute("attribute");
            Assert.assertEquals(actualAttribute, expectedAttribute);
            logInfo.pass("Element attribute located by '" + locator + "' contains value: '" + expectedAttribute + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element attribute should have been: '" + expectedAttribute + "' but it was: '" + actualAttribute + "'"), e);
        }
    }

    /**
     * Returns horizontal position of element identified by `locator`.
     * @param locator
     * @return
     */
    public static int getHorizontalPosition(String locator){
        int horizontalPosition = 0;
        try {
            WebElement element = findElementBy(locator);
            horizontalPosition = element.getLocation().getX();
            logInfo.pass("Saved to variable horizontal position of element located by" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable horizontal position of element located by" + locator + "'"), e);
        }
        return horizontalPosition;
    }

    /**
     * Returns vertical position of element identified by `locator`.
     * @param locator
     * @return
     */
    public static int getVerticalPosition(String locator){
        int varticalPosition = 0;
        try {
            WebElement element = findElementBy(locator);
            varticalPosition = element.getLocation().getY();
            logInfo.pass("Saved to variable vertical position of element located by" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable vertical position of element located by" + locator + "'"), e);
        }
        return varticalPosition;
    }

    /**
     * Returns width and height of element identified by `locator`.
     * @param locator
     * @return
     */
    public static Dimension getElementSize(String locator){
        Dimension elementSize = null;
        try {
            WebElement element = findElementBy(locator);
            elementSize = element.getSize();
            logInfo.pass("Saved to variable dimension of element located by " + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable dimension of element located by" + locator + "'"), e);
        }
        return elementSize;
    }

    /**
     * Returns value of element identified by `locator`.
     * @param locator
     * @return
     */
    public static String getElementValue(String locator){
        String elementValue = null;
        try {
            WebElement element = findElementBy(locator);
            elementValue = element.getAttribute("value");
            logInfo.pass("Saved to variable value of element located by" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable value of element located by " + locator + "'"), e);
        }
        return elementValue;
    }

    /**
     * Returns text of element identified by `locator`.
     * @param locator
     * @return
     */
    public static String getElementText(String locator){
        String elementText = null;
        try {
            WebElement element = findElementBy(locator);
            elementText = element.getText();
            logInfo.pass("Saved to variable text of element located by" + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable text of element located by " + locator + "'"), e);
        }
        return elementText;
    }

    /**
     * Returns text of element identified by `locator`.
     * @param locator
     */
    public static void clearElementText(String locator){
        try {
            WebElement element = findElementBy(locator);
            element.clear();
            logInfo.pass("Saved to variable text of element located by " + locator + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save to variable text of element located by " + locator + "'"), e);
        }
    }

    /**
     * Clicks button identified by `locator`.
     * @param locator
     */
    public static void clickButton(String locator){
        try {
            WebElement element = getDriver().findElement(By.xpath("//button[@" + locator + "']"));
            element.click();
            logInfo.pass("Clicked element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Element located by '" + locator + "' was not clickable"), e);
        }
    }

    /**
     * Click element `locator` at `xoffset/yoffset`.
     * @param locator
     * @param xoffset
     * @param yoffset
     */
    public static void clickElementAtCoordinates(String locator, int xoffset, int yoffset){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.moveToElement(element);
            actions.moveByOffset(xoffset,yoffset).click().perform();
            logInfo.pass("Clicked element located by '" + locator + "' at coordinates '" + xoffset + ", " + yoffset + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to click element located by '" + locator + "' at coordinates '" + xoffset + ", " + yoffset + "'"), e);
        }
    }

    /**
     * Double click element identified by `locator`.
     * @param locator
     */
    public static void doubleClickElement(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.moveToElement(element).doubleClick().perform();
            logInfo.pass("Double clicked element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to double click element located by '" + locator + "'"), e);
        }
    }

    /**
     * Sets focus to element identified by `locator`.
     * @param locator
     */
    public static void setFocusToElement(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.moveToElement(element).perform();
            logInfo.pass("Set focus on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to focus element located by '" + locator + "'"), e);
        }
    }

    /**
     * Drags element identified by `locator` into `target` element.
     * @param locator
     * @param locatorTarget
     */
    public static void dragAndDrop(String locator, String locatorTarget){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            WebElement target = findElementBy(locatorTarget);
            actions.dragAndDrop(element, target).perform();
            logInfo.pass("Drag element located by '" + locator + "' and dropped into target located by '" + locatorTarget + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to drag element located by '" + locator + "' and dropped into target located by '" + locatorTarget + "'"), e);
        }
    }

    /**
     * Drags element identified with `locator` by `xoffset/yoffset`.
     * @param locator
     * @param xoffset
     * @param yoffset
     */
    public static void dragAndDropByOffset(String locator, int xoffset, int yoffset){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.dragAndDropBy(element, xoffset, yoffset).perform();
            logInfo.pass("Drag element located by '" + locator + "' and dropped at coordinates '" + xoffset + ", " + yoffset + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to drag element located by '" + locator + "' and dropped at coordinates '" + xoffset + ", " + yoffset + "'"), e);
        }
    }

    /**
     * Simulates pressing the left mouse button on the element identified by `locator`.
     * @param locator
     */
    public static void mouseDown(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.clickAndHold(element).perform();
            logInfo.pass("Simulating Mouse Down on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Down on element located by '" + locator + "'"), e);
        }
    }

    /**
     * Simulates mouse over the element identified by `locator`.
     * @param locator
     */
    public static void mouseOver(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.moveToElement(element).perform();
            logInfo.pass("Simulating Mouse Over on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Over on element located by '" + locator + "'"), e);
        }
    }

    /**
     * Simulates releasing the left mouse button on the element identified by `locator`.
     * @param locator
     */
    public static void mouseUp(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.release(element).perform();
            logInfo.pass("Simulating Mouse Up on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to simulate Mouse Up on element located by '" + locator + "'"), e);
        }
    }

    /**
     * Opens context menu on element identified by `locator`.
     * @param locator
     */
    public static void openContextMenu(String locator){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.contextClick(element).perform();
            logInfo.pass("Context menu opened on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to open context menu on element located by '" + locator + "'"), e);
        }
    }

    /**
     * Simulates preesing `key` on element identified by `locator`.
     * @param locator
     * @param key
     */
    public static void pressKey(String locator, String key){
        Actions actions = new Actions(getDriver());
        try {
            WebElement element = findElementBy(locator);
            actions.sendKeys(element, key);
            logInfo.pass("Pressing key '" + key + "' on element located by '" + locator + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to press key '" + key + "' on element located by '" + locator + "'"), e);
        }
    }
}
