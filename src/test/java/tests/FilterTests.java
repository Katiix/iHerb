package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.filter.FilterScreen;
import screens.region.RegionScreen;

public class FilterTests extends AppiumConfig {
    @BeforeClass
    public void preCondition() {
        new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp()
                .logIn("xerojis275@ratedane.com", "TestPass123$").closeBtn();
    }

    @Test
    public void filterCheck() {
        FilterScreen res = new HomeScreen(driver)
                .search("Deodorant")
                .closeHintBtn()
                .filterClick()
                .closeHintButton()
                .hideOutOfStock();
        Assert.assertTrue(new FilterScreen(driver).switchIsOn());
    }

}
