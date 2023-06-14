package screens.search;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;
import screens.cart.CartScreen;
import screens.filter.FilterScreen;

public class SearchScreen extends BaseScreen {

    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView\n")
    MobileElement closeHintBtn;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView\n")
    MobileElement searchFirstResult;
    @FindBy(id = "com.iherb:id/title")
    MobileElement resultTitle;

    @FindBy(id = "com.iherb:id/productlist_filter_sort_button")
    MobileElement filterBtn;

    @FindBy(id = "com.iherb:id/add_cart_icon")
    MobileElement addToCartBtn;

    @FindBy(id = "com.iherb:id/first_line")
    MobileElement noResultsMessage;

    @FindBy(id = "com.iherb:id/second_line")
    MobileElement resultInvalidTitle;

    @FindBy(id = "com.iherb:id/title")
    MobileElement errorUnableToFind;
    public SearchScreen closeHintBtn() {
        pause(2000);
        closeHintBtn.click();
        return new SearchScreen(driver);
    }

    public SearchScreen resultClick() {
        searchFirstResult.click();
        return new SearchScreen(driver);
    }

    public boolean resultTitleCheck(String text) {
        if (resultTitle.getText().contains(text)) return true;
        else return false;
    }

    public boolean noResultsErrorMessage(String text){
        if(errorUnableToFind.getText().contains("We were unable to find any items matching \""+text+"\"")) return true;
        else return false;
    }
    public FilterScreen filterClick(){
        filterBtn.click();
        return new FilterScreen(driver);
    }

    public CartScreen addToCartClick(){
        addToCartBtn.click();
        return new CartScreen(driver);
    }
}
