package screens.region;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class LanguageCurrencyScreen extends BaseScreen {
    public LanguageCurrencyScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/edt_search")
    MobileElement searchCountry;

    @FindBy(id = "com.iherb:id/regionalradioitem_text_displayname")
    MobileElement chooseCountryName;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    MobileElement language;


    public LanguageCurrencyScreen searchCountry(String text) {
        type(searchCountry, text);
        return new LanguageCurrencyScreen(driver);
    }

    public RegionScreen chooseCountryName() {
        chooseCountryName.click();
        return new RegionScreen(driver);
    }

    public RegionScreen chooseLanguageName() {
        language.click();
        return new RegionScreen(driver);
    }
}
