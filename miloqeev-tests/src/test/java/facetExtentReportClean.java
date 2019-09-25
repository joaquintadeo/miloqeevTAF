import UI.browserManagement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import facetPage.main;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class facetExtentReportClean extends browserManagement {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setup(){
        htmlReporter = new ExtentHtmlReporter("miloqeevTAF\\miloqeev-reports\\src\\main\\reports\\extent.html");
        htmlReporter.loadXMLConfig("C:\\Users\\Joaquin\\Documents\\Facultad\\Tesis\\miloqeevTAF\\miloqeev-reports\\src\\main\\resources\\extent-reports-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
            String screenshotPath = facetExtentReportClean.getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
        extent.flush();
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @Test
    public void facetLogoExtentReport () throws Exception{
        test = extent.createTest("MyFirstTest", "Sample description");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
        WebElement e=driver.findElement(By.name("q"));
        e.sendKeys("extent");
        e.submit();
    }
}
