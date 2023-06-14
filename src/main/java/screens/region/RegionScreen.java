package screens.region;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;
import screens.login_registration.BenefitsScreen;

public class RegionScreen extends BaseScreen {

    public RegionScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/etCountry")
    MobileElement country;

    @FindBy(id = "com.iherb:id/etLanguage")
    MobileElement language;

    @FindBy(id = "com.iherb:id/regional_button_save")
    MobileElement buttonNext;
    @FindBy(id = "com.iherb:id/etZipCode")
    MobileElement zipCode;

    @FindBy(id = "com.iherb:id/textinput_error")
    MobileElement errorZipInvalid;

    public LanguageCurrencyScreen chooseCountry() {
        country.click();
        return new LanguageCurrencyScreen(driver);
    }

    public boolean countryCheck(String text) {
        pause(2000);
        if (country.getText().contains("IL")) {
            return true;
        } else return false;
    }

    public LanguageCurrencyScreen languageChoice() {
        pause(2000);
        language.click();
        return new LanguageCurrencyScreen(driver);
    }


    public boolean langCheck(String text) {
        System.out.println(language.getText());
        if(language.getText().contains(text)){
            return true;
        }else return false;
    }

    public RegionScreen zipCodeChoice(String text){
        zipCode.click();
        driver.hideKeyboard();
        zipCode.sendKeys(text);
        return new RegionScreen(driver);
    }

    public boolean errorInvalidZipCode(){
        if(errorZipInvalid.getText().contains("Invalid zip code")) return true;
        else return false;
    }
    public BenefitsScreen clickNext(){
        buttonNext.click();
        return new BenefitsScreen(driver);
    }


}
