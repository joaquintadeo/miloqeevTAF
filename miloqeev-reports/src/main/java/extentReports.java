import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReports {
    public void setupOnlyParent(){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("Open Browser");
        test.pass("Browser Opened");

        extent.flush();
    }

    public void setupParentAndChild(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest parentTest = extent.createTest("Given_user_opens_a_browser");

        ExtentTest childTest1 = parentTest.createNode("Open chrome");
        childTest1.pass("chrome opened");

        parentTest.pass("Browser Opened");
        extent.flush();
    }
}
