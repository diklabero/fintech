import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    final String URL = "https://af-qa-test.vercel.app/";
    protected WebDriver driver;


    @BeforeClass
    public void baseTestSetUp() {
        WebDriverManager.chromedriver().version("85").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @AfterClass
    public void quit() {
        driver.quit();
    }


}
