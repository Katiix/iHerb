package tests;


import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.BenefitsScreen;
import screens.LoginSocialMediaScreen;
import screens.RegionScreen;

public class RegionTests extends AppiumConfig {

    @Test
    public void chooseCountryName(){
        RegionScreen res = new RegionScreen(driver).chooseCountry().searchCountry("Israel").chooseCountryName();
        Assert.assertTrue(res.countryCheck("IL"));
    }

    @Test
    public void chooseLanguageName(){
        RegionScreen res = new RegionScreen(driver).languageChoice().chooseLanguageName();
        Assert.assertTrue(res.langCheck("English"));
    }
    @Test
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

    @Test
    public void SignUpPageOpen(){
        LoginSocialMediaScreen res = new RegionScreen(driver)
                .chooseCountry()
                .searchCountry("Israel")
                .chooseCountryName()
                .languageChoice()
                .chooseLanguageName()
                .clickNext().signUp();
    }



}
