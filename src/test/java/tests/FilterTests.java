package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.filter.FilterScreen;
import screens.region.RegionScreen;
import screens.search.SearchScreen;

public class FilterTests extends AppiumConfig {
    @BeforeMethod(alwaysRun = true)
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

    @Test(groups={"smoke", "positive"})
    public void filterHideOutOfStockCheck() {
        int before = new HomeScreen(driver)
                .search("Deodorant")
                .closeHintBtn()
                .filterClick()
                .closeHintButton().amountOfResultsBeforeFilter();
        int after = new FilterScreen(driver)
                .hideOutOfStock()
                .amountOfResultsAfterFilter();
        Assert.assertTrue(new FilterScreen(driver).switchIsOn());
        Assert.assertTrue(new FilterScreen(driver).checkResultsAmount(before, after));
    }

    @Test(groups={"smoke", "positive"})
    public void filterByCategoryCheck(){
        FilterScreen res  = new HomeScreen(driver)
                .search("Deodorant")
                .closeHintBtn()
                .filterClick()
                .closeHintButton()
                .chooseCategory("Beauty");
        Assert.assertTrue(new FilterScreen(driver).categoryResultCheck("Beauty"));
        SearchScreen res2  = new FilterScreen(driver)
                .chooseCategory("Beauty")
                .chooseFirstCategoryResult().applyFilter();

    }




}
