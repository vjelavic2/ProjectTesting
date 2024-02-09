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

public class SearchTest  {
    public WebDriver driver;
    public String mytestURL = "http://www.google.com";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Student\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(mytestURL);
    }

    @Test
    public void searchAndClickFirstResult() throws InterruptedException {

        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("links");
        searchTextBox.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")
                );



        wait.until(ExpectedConditions.elementToBeClickable(By.className("sVXRqc")));
        WebElement notinoLink = driver.findElement(By.cssSelector("a.sVXRqc"));
        notinoLink.click();



        WebElement searchPuderTextBox = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchPuderTextBox.sendKeys("punjac");
        searchPuderTextBox.sendKeys(Keys.RETURN);

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"q\"]"));
        Assert.assertTrue(searchResult.isDisplayed(), "Rezultat pretrage za 'punjac' nije prikazan.");

        System.out.println("Test za pretragu i klikanje na prvi rezultat uspješno izvršen.");
    }
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
