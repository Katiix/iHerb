package screens.filter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class FilterScreen extends BaseScreen {

    public FilterScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/close_btn")
    MobileElement closeHintBtn;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.Switch\n")
    MobileElement hideOutOfStockSwitch;
    public FilterScreen closeHintButton(){
        closeHintBtn.click();
        return new FilterScreen(driver);
    }

    public FilterScreen hideOutOfStock(){
        hideOutOfStockSwitch.click();
        return new FilterScreen(driver);
    }
    public boolean switchIsOn(){
        if(hideOutOfStockSwitch.getText().contains("ON")) return true;
        else return false;
    }

}
