package Pages;

import Selectors.CountriesPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountriesPage {
    WebDriver driver;

    public CountriesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "th:first-child")
    private WebElement checkAll;

    @FindBy(css = "a[href=\"/\"]")
    private WebElement homeLink;

    public WebElement getCheckAll() {
        return checkAll;
    }

    public WebElement getHomeLink() {
        return homeLink;
    }

    public void clickWantToGoByRow(int rowNum){
        WebElement element = driver.findElement(By.cssSelector(CountriesPageSelectors.wantToGoByRow.replaceAll("XXXX", String.valueOf(rowNum))));
        element.click();
    }

    public void clickVisitedByRow(int rowNum){
        WebElement element = driver.findElement(By.cssSelector(CountriesPageSelectors.visitedByRow.replaceAll("XXXX", String.valueOf(rowNum))));
        element.click();
    }

    public HomePage navigateToHome(){
        homeLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(driver);
        return homePage;
    }
}
