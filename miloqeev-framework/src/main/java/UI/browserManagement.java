package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class browserManagement {
    public static WebDriver driver;

    public static void openBrowser(String browser){
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
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

    public static void goTo(String url){
        driver.get(url);
    }

    public static void setBrowserImplicitWait(int miliseconds){
        driver.manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }

    public static void goBack(){
        driver.navigate().back();
    }

    public static void goFoward(){
        driver.navigate().forward();
    }

    public static String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public static void logPageTitle(){
        String title = getPageTitle();
        System.out.println("The page title is: " + title);
    }

    public static void titleShouldBe(String expectedTitle){
        String actualTitle = getPageTitle();
        if (!actualTitle.equals(expectedTitle)){
            System.out.println("Page title should have been: " + expectedTitle + " but it was: " + actualTitle);
        }
        System.out.println("Current page title is: " + actualTitle); //esto deberia ir dentro del error
    }
    /*
    algo se debe poder hacer para no repetir codigo
     */
    public static String getLocation(){
        String location = driver.getCurrentUrl();
        return location;
    }

    public static void logLocation(){
        String location = getLocation();
        System.out.println("Current location is: " + location);
    }

    public static void locationShouldBe(String expectedLocation){
        String actualLocation = getLocation();
        if (!actualLocation.equals(expectedLocation)){
            System.out.println("Location should have been: " + expectedLocation + " but it was: " + actualLocation);
        }
        System.out.println("Current location is: " + actualLocation); //esto deberia ir dentro del error
    }
}
