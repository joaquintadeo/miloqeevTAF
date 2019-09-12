package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

    public static void maximizeBrowserWindow(){
        driver.manage().window().maximize();
    }
}
