package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static UI.browserManagement.getDriver;
import static UI.element.findElementBy;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class tableElement {

    /**
     * Returns contents of table cell identified by `locator`.
     * @param locator
     * @param rowIndex
     * @param colIndex
     * @return
     */
    public static String getTableCell(String locator, int rowIndex, int colIndex){
        String tableCell = null;
        try{
            WebElement table = findElementBy(locator);
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            List<WebElement> columns = rows.get(rowIndex).findElements(By.tagName("td"));
            tableCell = columns.get(colIndex).getText();
            logInfo.pass("Table Cell value Row " + rowIndex + ", Column " + colIndex + ": '" + tableCell + "' saved to variable");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find cell in table located by '" + locator + "'"), e);
        }
        return tableCell;
    }

    /**
     * Verifies that table cell identified by `locator` contains text `expected`.
     * @param locator
     * @param rowIndex
     * @param colIndex
     * @param expectedText
     */
    public static void tableCellShouldContain(String locator, int rowIndex, int colIndex, String expectedText){
        String tableCell = null;
        try{
            WebElement table = findElementBy(locator);
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            List<WebElement> columns = rows.get(rowIndex).findElements(By.tagName("td"));
            tableCell = columns.get(colIndex).getText();
            Assert.assertEquals(tableCell, expectedText);
            logInfo.pass("Table Cell value Row " + rowIndex + ", Column " + colIndex + "is equal to '" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table Cell value Row " + rowIndex + ", Column " + colIndex + " should have been ='" + expectedText + "' but instead it was ='" + tableCell + "'"), e);
        }
    }

    /**
     * Verifies that table identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedText
     */
    public static void tableShouldContain(String locator, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locator + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table located by '" + locator + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table located by '" + locator + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    /**
     * Verifies that table column identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedText
     */
    public static void tableColumnShouldContain(String locator, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locator + "']//tr//td[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table column located by '" + locator + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table column located by '" + locator + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    /**
     * Verifies that table row identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedText
     */
    public static void tableRowShouldContain(String locator, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locator + "']//tr//th[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table row located by '" + locator + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table row located by '" + locator + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    /**
     * Verifies that footer identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedText
     */
    public static void footerShouldContain(String locator, String expectedText){
        try{
            int footerElementCount = getDriver().findElements(By.xpath("//*[@" + locator + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(footerElementCount, 0);
            logInfo.pass("Footer located by '" + locator + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Footer located by '" + locator + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    /**
     * Verifies that header identified by `locator` contains text `expected`.
     * @param locator
     * @param expectedText
     */
    public static void headerShouldContain(String locator, String expectedText){
        try{
            int headerElementCount = getDriver().findElements(By.xpath("//*[@" + locator + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(headerElementCount, 0);
            logInfo.pass("Header located by '" + locator + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Header located by '" + locator + "' did not contain text='" + expectedText + "'"), e);
        }
    }
}
