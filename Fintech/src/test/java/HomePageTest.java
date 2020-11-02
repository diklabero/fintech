import Pages.CountriesPage;
import Pages.HomePage;
import Selectors.HomePageSelectors;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;


    @BeforeClass
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "validating data on dashboard after opening the app for the first time")
    public void dashboardDataFirstTime() {
        Assert.assertEquals(homePage.getCountriesVisited(),0);
        Assert.assertEquals(homePage.getCountriesToVisit(),0);
        Assert.assertFalse(Utiles.isElemenyDisplyed(driver,HomePageSelectors.toVisitResetButton));
        Assert.assertFalse(Utiles.isElemenyDisplyed(driver,HomePageSelectors.visitedResetButton));    }

    @Test(priority = 2, description = "validating data on dashboard after checking countries")
    public void dashboardDataAfterClickingCountries() {
        CountriesPage countriesPage = homePage.navigateToCountries();
        countriesPage.clickVisitedByRow(2);
        countriesPage.clickWantToGoByRow(3);
        homePage = countriesPage.navigateToHome();
        Assert.assertEquals(homePage.getCountriesVisited(),1);
        Assert.assertEquals(homePage.getCountriesToVisit(),1);
        Assert.assertTrue(Utiles.isElemenyDisplyed(driver,HomePageSelectors.toVisitResetButton));
        Assert.assertTrue(Utiles.isElemenyDisplyed(driver,HomePageSelectors.visitedResetButton));
    }

    @Test(priority = 3, description = "validating data on dashboard after data reset")
    public void dashboardDataAfterReset() {
        homePage.clickCountriesToVisitResetButton();
        homePage.clickCountriesVisitedResetButton();
        Assert.assertEquals(homePage.getCountriesVisited(),0);
        Assert.assertEquals(homePage.getCountriesToVisit(),0);
        Assert.assertFalse(Utiles.isElemenyDisplyed(driver,HomePageSelectors.toVisitResetButton));
        Assert.assertFalse(Utiles.isElemenyDisplyed(driver,HomePageSelectors.visitedResetButton));
    }

}
