import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test_without_framework {

    private WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test(){
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
        driver.get("http://google.com");
        driver.manage().window().maximize();

        WebElement searchBarr = driver.findElement(By.name("q"));
        searchBarr.sendKeys("facet");
        searchBarr.submit();

        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='TbwUpd']//cite[text()='https://www.facet.unt.edu.ar']")));
    }
}
