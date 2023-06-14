package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.login_registration.BenefitsScreen;
import screens.login_registration.CreateAccountScreen;
import screens.region.RegionScreen;

public class RegistrationTests extends AppiumConfig {

    @Test(groups={"smoke", "positive"})
    public void LoginPageOpen(){
        BenefitsScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext();
        Assert.assertTrue(new BenefitsScreen(driver).signUpButtonPresent());
    }


    @Test(groups={"smoke", "positive"})
    public void CreateAccountSuccess(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp().createAccount()
                .sendEmail("xerojis275@ratedane.com").sendPassword("TestPass123$")
                .createBtnClick();
        Assert.assertTrue(new HomeScreen(driver).homeScreenOpen());
    }

    @Test(groups={"smoke", "negative"})
    public void CreateAccountEmailInvalid(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp().createAccount()
                .sendEmail("@.com").sendPassword("TestPass123$")
                .createBtnClick();
        Assert.assertTrue(new CreateAccountScreen(driver).invalidEmailMessageAppears());
    }

    @Test(groups={"smoke", "negative"})
    public void CreateAccountPasswordInvalid(){
        HomeScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp().clickSignUp().createAccount()
                .sendEmail("xerojis275@ratedane.com").sendPassword("t123")
                .createBtnClick();
        Assert.assertTrue(new CreateAccountScreen(driver).invalidPasswordMessageAppears());
    }

}
