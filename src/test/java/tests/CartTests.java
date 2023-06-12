package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.cart.CartScreen;
import screens.region.RegionScreen;


public class CartTests extends AppiumConfig {
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
    public void addToCartFromSearch(){
        CartScreen res = new HomeScreen(driver)
                .search("Deodorant")
                .closeHintBtn()
                .addToCartClick();
        Assert.assertTrue(new CartScreen(driver).cartConfirmCheck());
    }
    @Test
    public void goToCartFromSearch(){
        CartScreen res = new HomeScreen(driver)
                .search("Deodorant")
                .closeHintBtn()
                .addToCartClick()
                .toCartBtnClick();
        Assert.assertTrue(new CartScreen(driver).productTitleCheck("Deodorant"));
    }
}
