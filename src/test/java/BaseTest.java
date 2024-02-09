
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaseTest {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String mytestURL = "http://www.google.com";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Student\\chromedriver.exe");
//Create a new ChromeDriver
        driver = new ChromeDriver();
//Go to www.swtestacademy.com
        driver.navigate().to(mytestURL);
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();//preko cijelog zaslona
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));//u dev toolsu desni klik i provjeri pa nadi name
        searchTextBox.sendKeys("links");//ono sto zelis postat
        searchTextBox.submit();//submit to
        Thread.sleep(5000);
        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")//odi na youtube home desni klik provjeri pa na kod koji se otvorio copy->copyxpath
                );
        Assert.assertTrue(testLink.getText().contains("Links"));
        System.out.print(testLink.getText());//ispisivanje u konzoli youtube kome
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}