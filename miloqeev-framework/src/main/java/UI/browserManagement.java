package UI;

import static testListeners.extentReportListener.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class browserManagement {
    public static WebDriver driver;

    /**
     * Opens the given browser to a blank page.
     * @param browser
     */
    public static void openBrowser(String browser){
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
            logInfo.pass("Browser opened: '" + browser + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Closes the current browser.
     */
    public static void closeBrowser(){
        if (driver != null) {
            driver.close();
            logInfo.pass("Browser closed");
        }
    }

    /**
     * Navigates the active browser instance to the provided url.
     * @param url
     */
    public static void goTo(String url){
        try {
            driver.get(url);
            logInfo.pass("Navigated to Url: " + "'" + url + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Sets the implicit wait value used by Selenium.
     * @param miliseconds
     */
    public static void setBrowserImplicitWait(int miliseconds){
        try {
            driver.manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
            logInfo.pass("Browser implicit wait set to '" + miliseconds + " miliseconds'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user refreshing page.
     */
    public static void refreshPage(){
        try {
            driver.navigate().refresh();
            logInfo.pass("Refreshed current page");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user clicking the back button on their browser.
     */
    public static void goBack(){
        try {
            driver.navigate().back();
            logInfo.pass("Moved back one page");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Simulates user clicking the foward button on their browser.
     */
    public static void goFoward(){
        try {
            driver.navigate().forward();
            logInfo.pass("Moved foward one page");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns the title of the current page.
     * @return
     */
    public static String getPageTitle(){
        String title = null;
        try {
            title = driver.getTitle();
            logInfo.pass("Saved page title to variable");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return title;
    }

    /**
     * Logs the current page title.
     */
    public static void logPageTitle(){
        try {
            String title = getPageTitle();
            System.out.println("The page title is: " + title);
            logInfo.pass("Logged page title to console");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies that current page title equals `expectedTitle`
     * @param expectedTitle
     */
    public static void titleShouldBe(String expectedTitle){
        String actualTitle = getPageTitle();
        try {
            if (!actualTitle.equals(expectedTitle)){
                System.out.println("Page title should have been: " + expectedTitle + " but it was: " + actualTitle);
                System.out.println("Current page title is: " + actualTitle);
                logInfo.pass("Successfully compared page titles");
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
    public static String getLocation(){
        String location = null;
        try {
            location = driver.getCurrentUrl();
            logInfo.pass("Saved current URL to variable");

        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return location;
    }

    /**
     * Logs the current browser's URL.
     */
    public static void logLocation(){
        try {
            String location = getLocation();
            System.out.println("Current location is: " + location);
            logInfo.pass("Logged current URL to console");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Verifies current browser's URL is exactly `expectedLocation`.
     * @param expectedLocation
     */
    public static void locationShouldBe(String expectedLocation){
        String actualLocation = getLocation();
        try {
            if (!actualLocation.equals(expectedLocation)){
                System.out.println("Location should have been: " + expectedLocation + " but it was: " + actualLocation);
                System.out.println("Current location is: " + actualLocation);
                logInfo.pass("Successfully compared URLs");
            }
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }
}
