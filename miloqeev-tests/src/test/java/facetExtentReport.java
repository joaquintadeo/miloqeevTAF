import UI.browserManagement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import facetPage.main;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class facetExtentReport extends browserManagement{
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    main steps;

    @BeforeMethod
    public void setup(){
        test = extent.createTest("MyFirstTest", "Sample description");
        steps = new main(test);
    }

    @AfterClass
    public void teardown(){
        extent.flush();
    }

    @Test
    public void facetLogoExtentReport (){
        steps.Given_user_opens_a_browser();
        steps.When_user_navigates_to_facet_web_page();
        steps.Then_user_must_see_facet_logo();
        steps.close_browser();
    }

    @BeforeClass
    public void createReport(){
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\Joaquin\\Documents\\Facultad\\Tesis\\miloqeevTAF\\miloqeev-reports\\src\\main\\reports\\extent.html");
        htmlReporter.loadXMLConfig("C:\\Users\\Joaquin\\Documents\\Facultad\\Tesis\\miloqeevTAF\\miloqeev-reports\\src\\main\\resources\\extent-reports-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
            String screenshotPath = facetExtentReport.getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
        driver.quit();
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
}
