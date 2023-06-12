package tests;


import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.login.BenefitsScreen;
import screens.login.LoginSocialMediaScreen;
import screens.region.RegionScreen;

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




}
