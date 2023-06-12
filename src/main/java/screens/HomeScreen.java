package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import screens.search.SearchScreen;

import javax.swing.*;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/close_button")
    MobileElement closeBtn;

    @FindBy(id = "com.iherb:id/search_txtbox")
    MobileElement searchBar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup" +
            "/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.TextView\n")
    MobileElement searchResult;




    public HomeScreen closeBtn(){
        closeBtn.click();
        return new HomeScreen(driver);
    }

    public boolean homeScreenOpen() {
        return closeBtn.isDisplayed();
    }
    public SearchScreen search(String text){
        pause(2000);
        searchBar.click();
        driver.hideKeyboard();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        driver.hideKeyboard();
        action.click(searchResult).perform();
        return new SearchScreen(driver);
    }





}
