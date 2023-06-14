package screens.filter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;
import screens.search.SearchScreen;

import java.lang.reflect.MalformedParameterizedTypeException;

public class FilterScreen extends BaseScreen {

    public FilterScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/close_btn")
    MobileElement closeHintBtn;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.Switch\n")
    MobileElement hideOutOfStockSwitch;
    @FindBy(id = "com.iherb:id/bt_filter_apply")
    MobileElement applyButtonAmount;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageButton\n")
    MobileElement categoryFilter;

    @FindBy(id = "com.iherb:id/et_search_items")
    MobileElement categoryField;

    @FindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.CheckBox\n")
    MobileElement firstResult;
    public FilterScreen closeHintButton() {
        closeHintBtn.click();
        return new FilterScreen(driver);
    }

    public FilterScreen hideOutOfStock() {
        hideOutOfStockSwitch.click();
        return new FilterScreen(driver);
    }

    public boolean switchIsOn() {
        if (hideOutOfStockSwitch.getText().contains("ON")) return true;
        else return false;
    }

    public int amountOfResultsBeforeFilter() {
        return Integer.parseInt(applyButtonAmount.getText().replaceAll("[\\D]", ""));
    }

    public int amountOfResultsAfterFilter() {
        return Integer.parseInt(applyButtonAmount.getText().replaceAll("[\\D]", ""));
    }

    public boolean checkResultsAmount(int before, int after) {
        if (before > after) return true;
        else return false;
    }

    public FilterScreen chooseCategory(String text){
        categoryFilter.click();
        type(categoryField, text);
        return new FilterScreen(driver);
    }

    public boolean categoryResultCheck(String text){
        if(firstResult.getText().contains(text)) return true;
        else return false;
    }
    public FilterScreen chooseFirstCategoryResult(){
        firstResult.click();
        return new FilterScreen(driver);
    }

    public SearchScreen applyFilter(){
        applyButtonAmount.click();
        return new SearchScreen(driver);
    }



}
