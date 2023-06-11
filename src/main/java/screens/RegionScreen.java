package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

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


    public LanguageCurrencyScreen chooseCountry() {
        country.click();
        return new LanguageCurrencyScreen(driver);
    }

    public boolean countryCheck(String text) {
        System.out.println(country.getText());
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

    public BenefitsScreen clickNext(){
        buttonNext.click();
        return new BenefitsScreen(driver);
    }
}
