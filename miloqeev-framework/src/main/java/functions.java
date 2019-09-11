import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class functions{

    private static WebDriver driver;

    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

    public static void goTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void inputText(int selectorType, String selectorValue, String text){
        WebElement element = findBy(selectorType, selectorValue);
        element.sendKeys(text);
        element.submit();
    }

    public static WebElement findBy(int selectorType, String selectorValue){
        WebElement tmp = null;
        switch (selectorType){
            case utils.ID: tmp = driver.findElement(By.id(selectorValue));
                break;
            case utils.NAME: tmp = driver.findElement(By.name(selectorValue));
                break;
            case utils.CLASSNAME: tmp = driver.findElement(By.className(selectorValue));
                break;
            case utils.XPATH: tmp = driver.findElement(By.xpath(selectorValue));
                break;
            default: break;
        }
        return tmp;
    }

    public static void waitUntilPageContainsElement(int selectorType, String selectorValue){
        WebDriverWait wait = new WebDriverWait(driver,40);
        switch (selectorType){
            case utils.ID: wait.until(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)));
                break;
            case utils.NAME: wait.until(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)));
                break;
            case utils.CLASSNAME: wait.until(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)));
                break;
            case utils.XPATH: wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)));
                break;
            default: break;
        }
    }
}
