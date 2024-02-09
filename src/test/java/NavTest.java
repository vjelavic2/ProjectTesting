
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NavTest {

    public WebDriver driver;
    public String mytestURL = "https://www.links.hr/hr/";
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Student\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(mytestURL);
    }

    @Test
    public void navigationTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementNav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[2]/ul/li[6]/a/span/span")));
        elementNav.click();

        Thread.sleep(5000);
        WebElement testNav =
                driver.findElement(By.className("active")//odi na youtube home desni klik provjeri pa na kod koji se otvorio copy->copyxpath
                );
        String actualText = testNav.getText();
        System.out.println("Actual Text: " + actualText);
        Assert.assertTrue(actualText.contains("SPORT I OPREMA"), "Expected text 'Sport' not found in actual text: " + actualText);


    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}