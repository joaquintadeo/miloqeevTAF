import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import facetPage.main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facetExtentReport {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeMethod
    public void setup(){
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\Joaquin\\Documents\\Facultad\\Tesis\\miloqeevTAF\\miloqeev-reports\\src\\main\\reports\\extent.html");
        htmlReporter.loadXMLConfig("C:\\Users\\Joaquin\\Documents\\Facultad\\Tesis\\miloqeevTAF\\miloqeev-reports\\src\\main\\resources\\extent-reports-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void teardown(){
        extent.flush();
    }

    @Test
    public void facetLogoExtentReport () throws Exception{
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        main.Given_user_opens_a_browser();
        test.pass("User opens browser");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
        main.When_user_navigates_to_facet_web_page();
        test.pass("User goes to facet web page");
        main.Then_user_must_see_facet_logo();
        test.pass("User sees facet logo");
        main.close_browser();
        test.pass("User closes browser");
    }
}
