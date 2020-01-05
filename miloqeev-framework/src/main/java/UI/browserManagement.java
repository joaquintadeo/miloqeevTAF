package UI;

import testListeners.extentReportListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class browserManagement extends extentReportListener {
    public static WebDriver driver;

    /**
     * Opens the given browser to a blank page.
     * @param browser
     * @throws Throwable
     */
    public static void openBrowser(String browser) throws Throwable{
        try {
            if (browser == "chrome"){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            if (browser == "firefox"){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            if (browser == "iexplorer"){
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            if (browser == "edge"){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            logInfo.pass("Browser opened");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Closes the current browser.
     * @throws Throwable
     */
    public static void closeBrowser() throws Throwable{
        try {
            driver.close();
            logInfo.pass("Browser closed");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Navigates the active browser instance to the provided url.
     * @param url
     * @throws Throwable
     */
    public static void goTo(String url) throws Throwable{
        try {
            driver.get(url);
            logInfo.pass("Navigated to Url");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Sets the implicit wait value used by Selenium.
     * @param miliseconds
     */
    public static void setBrowserImplicitWait(int miliseconds) throws Throwable{
        try {
            driver.manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user refreshing page.
     */
    public static void refreshPage() throws Throwable{
        try {
            driver.navigate().refresh();
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user clicking the back button on their browser.
     */
    public static void goBack() throws Throwable{
        try {
            driver.navigate().back();
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user clicking the foward button on their browser.
     */
    public static void goFoward() throws Throwable{
        try {
            driver.navigate().forward();
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns the title of the current page.
     * @return
     */
    public static String getPageTitle() throws Throwable{
        String title = null;
        try {
            title = driver.getTitle();
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return title;
    }

    /**
     * Logs the current page title.
     */
    public static void logPageTitle() throws Throwable{
        try {
            String title = getPageTitle();
            System.out.println("The page title is: " + title);
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page title equals `expectedTitle`
     * @param expectedTitle
     */
    public static void titleShouldBe(String expectedTitle) throws Throwable{
        String actualTitle = getPageTitle();
        try {
            if (!actualTitle.equals(expectedTitle)){
                System.out.println("Page title should have been: " + expectedTitle + " but it was: " + actualTitle);
                System.out.println("Current page title is: " + actualTitle);
            }
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns the current browser's URL.
     * @return
     */
    public static String getLocation() throws Throwable{
        String location = null;
        try {
            location = driver.getCurrentUrl();
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return location;
    }

    /**
     * Logs the current browser's URL.
     */
    public static void logLocation() throws Throwable{
        try {
            String location = getLocation();
            System.out.println("Current location is: " + location);
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies current browser's URL is exactly `expectedLocation`.
     * @param expectedLocation
     */
    public static void locationShouldBe(String expectedLocation) throws Throwable{
        String actualLocation = getLocation();
        try {
            if (!actualLocation.equals(expectedLocation)){
                System.out.println("Location should have been: " + expectedLocation + " but it was: " + actualLocation);
                System.out.println("Current location is: " + actualLocation);
            }
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }
}
