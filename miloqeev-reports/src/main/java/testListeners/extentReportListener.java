package testListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class extentReportListener {
    public static ExtentHtmlReporter report = null;
    public static ExtentReports extent = null;
    public static ExtentTest test = null;
    public static ExtentTest logInfo = null;

    public static ExtentReports setUp(){
        try {
            String reportLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "/miloqeev-reports/test-results/report.html";
            if (reportLocation == null)
                new File(System.getProperty("user.dir") + File.separator + ".." + File.separator + "/miloqeev-reports/test-results/report.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String reportLocation = System.getProperty("user.dir") + File.separator + ".." + File.separator + "/miloqeev-reports/test-results/report.html";
        report = new ExtentHtmlReporter(reportLocation);
        report.loadXMLConfig(System.getProperty("user.dir") + File.separator +".." + File.separator + "/miloqeev-reports/src/main/resources/extent-reports-config.xml");
        report.config().setDocumentTitle("Miloqeev Test Automation Framework");
        report.config().setReportName("Automation Test Report");
        report.config().setTheme(Theme.DARK);
        System.out.println("Extent Report location initialized . . .");
        report.start();

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Application", "miloqeev");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        System.out.println("System Info. set in Extent Report");
        return extent;
    }

    public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
                extenttest.error(throwable.fillInStackTrace());

                try {
                    extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (driver != null) {
                    driver.quit();
                }
                break;

            case "PASS":
                extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
                break;

            default:
                break;
        }
    }

    public static String captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String tmp = getcurrentdateandtime();
        String destination = System.getProperty("user.dir") + File.separator +".." + File.separator + "/miloqeev-reports/test-results/screenshots/"  + tmp  + ".png";
        String dst = "screenshots/"  + tmp + ".png";
        File target = new File(destination);
        FileUtils.copyFile(src, target);
        return dst;
    }

    private static String getcurrentdateandtime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        } catch (Exception e) {
        }
        return str;
    }

    public static void createTest(String feature, String scenario, String step){
        try {
            test = extent.createTest(Feature.class, feature);
            test = test.createNode(Scenario.class, scenario);
            logInfo = test.createNode(new GherkinKeyword("Given"), "Given" + " \'" + step + "\'");

        } catch (AssertionError | Exception e){
            logInfo.fail(e);
        }
    }

    public static void createTestStep(String gherkinKeyword, String step){
        if (gherkinKeyword == "When") {
            try {
                logInfo = test.createNode(new GherkinKeyword("When"), gherkinKeyword + " \'" + step + "\'");

            } catch (AssertionError | Exception e) {
                logInfo.fail(e);
            }
        }
        if (gherkinKeyword == "Then"){
            try {
                logInfo = test.createNode(new GherkinKeyword("Then"), gherkinKeyword + " \'" + step + "\'");

            } catch (AssertionError | Exception e){
                logInfo.fail(e);
            }
        }
        if (gherkinKeyword == "And") {
            try {
                logInfo = test.createNode(new GherkinKeyword("And"), gherkinKeyword + " \'" + step + "\'");

            } catch (AssertionError | Exception e) {
                logInfo.fail(e);
            }
        }
    }

    public static void backendTestStepHandle(String teststatus,ExtentTest extenttest,Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
                extenttest.error(throwable.fillInStackTrace());
                break;
            case "PASS":
                extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
                break;
            default:
                break;
        }
    }
}
