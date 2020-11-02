import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public  class Utiles {

    public WebDriver driver;


    public static  boolean isElemenyDisplyed(WebDriver driver,By locator){
        boolean isDisplayed=true;
        isDisplayed = (driver.findElements(locator).size()>0) ? true : false;
        return isDisplayed;
    }









}
