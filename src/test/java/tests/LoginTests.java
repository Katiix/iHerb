package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.login_registration.ReturningCustomerScreen;
import screens.region.RegionScreen;

public class LoginTests extends AppiumConfig {
    @Test(groups={"smoke", "positive"})
    public void LoginSuccess(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp()
                .fillEmail("xerojis275@ratedane.com").fillPassword("TestPass123$")
                .signIn();
        Assert.assertTrue(new HomeScreen(driver).homeScreenOpen());
    }
    @Test(groups={"smoke", "negative"})
    public void LoginEmailInvalid(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp()
                .fillEmail("invalidTest@ratedane.com").fillPassword("TestPass123$")
                .signIn();
        Assert.assertTrue(new ReturningCustomerScreen(driver).errorMessagePresent());
    }

    @Test(groups={"smoke", "negative"})
    public void LoginPasswordInvalid(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp()
                .fillEmail("xerojis275@ratedane.com").fillPassword("InvalidPass123$")
                .signIn();
        Assert.assertTrue(new ReturningCustomerScreen(driver).errorMessagePresent());
    }
}
