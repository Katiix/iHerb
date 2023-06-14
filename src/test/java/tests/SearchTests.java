package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.region.RegionScreen;
import screens.search.SearchScreen;

public class SearchTests extends AppiumConfig {
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp()
                .logIn("xerojis275@ratedane.com", "TestPass123$").closeBtn();
    }

    @Test(groups={"smoke", "positive"})
    public void searchSuccess(){
        SearchScreen res = new HomeScreen(driver).search("Deodorant").closeHintBtn().resultClick();
        Assert.assertTrue(new SearchScreen(driver).resultTitleCheck("Deodorant"));
    }
    @Test(groups={"smoke", "negative"})
    public void searchInvalid(){
        SearchScreen res = new HomeScreen(driver).search("dfggjhjkhnm");
        Assert.assertTrue(new SearchScreen(driver).noResultsErrorMessage("dfggjhjkhnm"));
    }


}
