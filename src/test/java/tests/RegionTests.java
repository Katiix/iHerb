package tests;


import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.login_registration.BenefitsScreen;
import screens.region.RegionScreen;

public class RegionTests extends AppiumConfig {

    @Test(groups={"smoke", "positive"})
    public void chooseCountryName(){
        RegionScreen res = new RegionScreen(driver).chooseCountry().searchCountry("Israel").chooseCountryName();
        Assert.assertTrue(res.countryCheck("IL"));
    }

    @Test(groups={"smoke", "positive"})
    public void chooseLanguageName(){
        RegionScreen res = new RegionScreen(driver).languageChoice().chooseLanguageName();
        Assert.assertTrue(res.langCheck("English"));
    }

    @Test(groups={"smoke", "positive"})
    public void chooseZipCode(){
        BenefitsScreen res = new RegionScreen(driver).zipCodeChoice("32003").clickNext();
        Assert.assertTrue(new BenefitsScreen(driver).signUpButtonPresent());
    }
    @Test(groups={"smoke", "negative"})
    public void chooseZipCodeInvalid(){
        BenefitsScreen res = new RegionScreen(driver).zipCodeChoice(" ").clickNext();
        Assert.assertTrue(new RegionScreen(driver).errorInvalidZipCode());
    }



}
