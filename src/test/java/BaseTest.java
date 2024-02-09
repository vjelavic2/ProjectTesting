
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaseTest {

    public WebDriver driver;
    public String mytestURL = "http://www.google.com";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Student\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(mytestURL);
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("links");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")//odi na youtube home desni klik provjeri pa na kod koji se otvorio copy->copyxpath
                );
        Assert.assertTrue(testLink.getText().contains("Links"));
        System.out.print(testLink.getText());
    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}