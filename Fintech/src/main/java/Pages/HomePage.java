package Pages;

import Selectors.HomePageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class HomePage{

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href*=\"countries\"]")
    private WebElement countriesLink;

    public WebElement getCountriesLink() {
        return countriesLink;
    }

    public int getCountriesAvailable(){
        WebElement element = driver.findElement(By.xpath(HomePageSelectors.dashboardItem.replaceAll("XXXX", String.valueOf(1))));
        return Integer.valueOf(element.getText());
    }

    public int getCountriesVisited(){
        WebElement element = driver.findElement(By.xpath(HomePageSelectors.dashboardItem.replaceAll("XXXX", String.valueOf(2))));
        return Integer.valueOf(element.getText());
    }

    public int getCountriesToVisit(){
        WebElement element = driver.findElement(By.xpath(HomePageSelectors.dashboardItem.replaceAll("XXXX", String.valueOf(3))));
        return Integer.valueOf(element.getText());
    }

    public WebElement getCountriesVisitedResetButton(){
        WebElement element = driver.findElement((HomePageSelectors.visitedResetButton));
        return element;
    }

    public WebElement getCountriesToVisitResetButton(){
        WebElement element = driver.findElement((HomePageSelectors.toVisitResetButton));
        return element;
    }

    public void clickCountriesToVisitResetButton(){
        getCountriesToVisitResetButton().click();
    }

    public void clickCountriesVisitedResetButton(){
        getCountriesVisitedResetButton().click();
    }

    public CountriesPage navigateToCountries(){
        countriesLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CountriesPage countriesPage = new CountriesPage(driver);
        return countriesPage;
    }


}
