package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected value '" + expectedValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' contained expected value '" + expectedValue + "'"), e);
        }
    }

    /**
     * Verifies that current page contains `link text`.
     * @param linkText
     */
    public static void PageShouldContainLink(String linkText){
        try {
            int elementCount = driver.findElements(By.linkText(linkText)).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Page contains link text='" + linkText + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page did not contain link text='" + linkText + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page does not contain `link text`.
     * @param linkText
     */
    public static void PageShouldNotContainLink(String linkText){
        try {
            int elementCount = driver.findElements(By.linkText(linkText)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Page does not contain link text='" + linkText + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page contains link text='" + linkText + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page contains `text`.
     * @param text
     */
    public static void PageShouldContain(String text){
        try {
            int elementCount = driver.findElements(By.tagName(text)).size();
            Assert.assertNotEquals(elementCount, 0);
            logInfo.pass("Page contains text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page did not contain text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page does not contain `text`.
     * @param text
     */
    public static void PageShouldNotContain(String text){
        try {
            int elementCount = driver.findElements(By.tagName(text)).size();
            Assert.assertEquals(elementCount, 0);
            logInfo.pass("Page does not contain text='" + text + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL",driver,logInfo.fail("Page contains text='" + text + "'"),e);
            logInfo.fail(e.getCause());
        }
    }

//    public static void assignIdToElement(String locatorType, String locatorValue, String id){
//        try {
//            WebElement element = findElementBy(locatorType, locatorValue);
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("")
//            logInfo.pass("Page does not contain text='" + text + "'");
//        } catch (AssertionError | Exception e) {
//            testStepHandle("FAIL",driver,logInfo.fail("Page contains text='" + text + "'"),e);
//            logInfo.fail(e.getCause());
//        }
//    }

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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is enabled"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is disabled"), e);
        }
    }

    /**
     * Verifies that element identified with `locator` is focused.
     * @param locatorType
     * @param locatorValue
     */
    public static void elementShouldBeFocused(String locatorType, String locatorValue){
        Actions actions = new Actions(driver);
        try {
            WebElement element = findElementBy(locatorType, locatorValue);
            actions.moveToElement(element).perform();
            logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is focused");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is not focused"), e);
        }
    }

//    /**
//     * Verifies that element identified with `locator` is visible.
//     * @param locatorType
//     * @param locatorValue
//     */
//    public static void elementShouldBeVisible(String locatorType, String locatorValue) {
//        boolean tmp = false;
//        switch (locatorType) {
//            case "id":
//                tmp = driver.findElement(By.id(locatorValue)).isDisplayed();
//                break;
//            case "name":
//                tmp = driver.findElement(By.name(locatorValue)).isDisplayed();
//                break;
//            case "class":
//                tmp = driver.findElement(By.className(locatorValue)).isDisplayed();
//                break;
//            case "xpath":
//                tmp = driver.findElement(By.xpath(locatorValue)).isDisplayed();
//                break;
//            default:
//                break;
//        }
//        try {
//            if (tmp)
//                logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is visible");
//        } catch (AssertionError | Exception e) {
//            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is not visible"), e);
//        }
//    }
//
//    /**
//     * Verifies that element identified with `locator` is not visible.
//     * @param locatorType
//     * @param locatorValue
//     */
//    public static void elementShouldNotBeVisible(String locatorType, String locatorValue){
//        boolean tmp;
//        try {
//            switch (locatorType){
//                case "id": tmp = driver.findElement(By.id(locatorValue)).isDisplayed();
//                    break;
//                case "name": tmp = driver.findElement(By.name(locatorValue)).isDisplayed();
//                    break;
//                case "class": tmp = driver.findElement(By.className(locatorValue)).isDisplayed();
//                    break;
//                case "xpath": tmp = driver.findElement(By.xpath(locatorValue)).isDisplayed();
//                    break;
//                default: break;
//            }
//            if (tmp = false)
//                logInfo.pass("Element located by '" + locatorType + " = " + locatorValue + "' is not visible");
//        } catch (AssertionError | Exception e){
//            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' is visible"), e);
//        }
//    }

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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' did not contain expected text '" + expectedValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + " = " + locatorValue + "' contained expected text '" + expectedValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save element's attribute to variable"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Element attribute should have been: '" + expectedAttribute + "' but it was: '" + actualAttribute + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable horizontal position of element located by" + locatorType + "='" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable vertical position of element located by" + locatorType + "='" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable dimension of element located by" + locatorType + "='" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable value of element located by " + locatorType + "='" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable text of element located by " + locatorType + "='" + locatorValue + "'"), e);
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
            testStepHandle("FAIL", driver, logInfo.fail("Could not save to variable text of element located by " + locatorType + "='" + locatorValue + "'"), e);
        }
    }

    /**
     * Clicks button identified by `locator`.
     * @param locatorType
     * @param locatorValue
     */
    public static void clickButton(String locatorType, String locatorValue){
        try {
            WebElement element = driver.findElement(By.tagName("button"));
            element.click();
            logInfo.pass("Clicked element located by '" + locatorType + " = " + locatorValue + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo.fail("Element located by '" + locatorType + "=" + locatorValue + "' was not clickable"), e);
        }
    }
}