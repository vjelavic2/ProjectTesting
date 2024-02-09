
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WishListTest {
    public WebDriver driver;
    public String mytestURL = "https://www.links.hr/hr/";
    //----------------------Test Setup-----------------------------------
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

        WebElement searchPuderTextBox = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchPuderTextBox.sendKeys("punjac");
        searchPuderTextBox.sendKeys(Keys.RETURN);



        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Punjač za laptop AVACOM, 90W, univerzalni, crni']")));
        productImage.click();


        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement addToWishList = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-wishlist-button-149078\"]")));
        addToWishList.click();

        WebElement wishes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/div[3]/div/div[2]/div/ul/li[2]/a")));
        wishes.click();

        Thread.sleep(5000);
        WebElement isInWishes =
                driver.findElement(By.className("divTableCell")
                );
        Assert.assertTrue(isInWishes.getText().contains("59,99"));
    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}

