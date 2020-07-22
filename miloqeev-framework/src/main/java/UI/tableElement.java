package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static UI.browserManagement.getDriver;
import static UI.element.findElementBy;
import static UI.element.getElementCount;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class tableElement {

    public static String getTableCell(String locatorType, String locatorValue, int rowIndex, int colIndex){
        String tableCell = null;
        try{
            WebElement table = findElementBy(locatorType, locatorValue);
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            List<WebElement> columns = rows.get(rowIndex).findElements(By.tagName("td"));
            tableCell = columns.get(colIndex).getText();
            logInfo.pass("Table Cell value Row " + rowIndex + ", Column " + colIndex + ": '" + tableCell + "' saved to variable");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not find cell in table located by '" + locatorType + "=" + locatorValue + "'"), e);
        }
        return tableCell;
    }

    public static void tableCellShouldContain(String locatorType, String locatorValue, int rowIndex, int colIndex, String expectedText){
        String tableCell = null;
        try{
            WebElement table = findElementBy(locatorType, locatorValue);
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            List<WebElement> columns = rows.get(rowIndex).findElements(By.tagName("td"));
            tableCell = columns.get(colIndex).getText();
            Assert.assertEquals(tableCell, expectedText);
            logInfo.pass("Table Cell value Row " + rowIndex + ", Column " + colIndex + "is equal to '" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table Cell value Row " + rowIndex + ", Column " + colIndex + " should have been ='" + expectedText + "' but instead it was ='" + tableCell + "'"), e);
        }
    }

    public static void tableShouldContain(String locatorType, String locatorValue, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locatorType + "='" + locatorValue + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table located by '" + locatorType + "=" + locatorValue + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    public static void tableColumnShouldContain(String locatorType, String locatorValue, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locatorType + "='" + locatorValue + "']//tr//td[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table column located by '" + locatorType + "=" + locatorValue + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table column located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    public static void tableRowShouldContain(String locatorType, String locatorValue, String expectedText){
        try{
            int tableElementCount = getDriver().findElements(By.xpath("//*[@" + locatorType + "='" + locatorValue + "']//tr//th[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(tableElementCount, 0);
            logInfo.pass("Table row located by '" + locatorType + "=" + locatorValue + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Table row located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    public static void footerShouldContain(String locatorType, String locatorValue, String expectedText){
        try{
            int footerElementCount = getDriver().findElements(By.xpath("//*[@" + locatorType + "='" + locatorValue + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(footerElementCount, 0);
            logInfo.pass("Footer located by '" + locatorType + "=" + locatorValue + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Footer located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + expectedText + "'"), e);
        }
    }

    public static void headerShouldContain(String locatorType, String locatorValue, String expectedText){
        try{
            int headerElementCount = getDriver().findElements(By.xpath("//*[@" + locatorType + "='" + locatorValue + "']//*[text()='" + expectedText + "']")).size();
            Assert.assertNotEquals(headerElementCount, 0);
            logInfo.pass("Header located by '" + locatorType + "=" + locatorValue + "' contains text='" + expectedText + "'");
        }  catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Header located by '" + locatorType + "=" + locatorValue + "' did not contain text='" + expectedText + "'"), e);
        }
    }
}
