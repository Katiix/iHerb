package screens.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import screens.BaseScreen;
import screens.HomeScreen;

import java.lang.reflect.MalformedParameterizedTypeException;


public class CreateAccountScreen extends BaseScreen {
    public CreateAccountScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Login Pages\"]/android.view.View/android.view.View[2]/android.view.View[2]")
    MobileElement email;

    @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Login Pages\"]/android.view.View/android.view.View[2]/android.view.View[3]")
    MobileElement password;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Create account\"]")
    MobileElement createBtn;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Enter you email in the correct format.\"]")
    MobileElement invlaidEmailError;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Enter at least 8 characters.\"]")
    MobileElement invalidPasswordError;

    public CreateAccountScreen sendEmail(String text) {
        pause(4000);
        email.click();
        driver.hideKeyboard();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        return new CreateAccountScreen(driver);
    }

    public CreateAccountScreen sendPassword(String text) {
        pause(4000);
        password.click();
        driver.hideKeyboard();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        driver.hideKeyboard();
        return new CreateAccountScreen(driver);
    }

    public HomeScreen createBtnClick() {
        createBtn.click();
        return new HomeScreen(driver);
    }

    public boolean invalidEmailMessageAppears() {
        String message = invlaidEmailError.getAttribute("content-desc");
        System.out.println(message);
        if(message.contains("Enter you email in the correct format."))return true;
        else return false;
    }
    public boolean invalidPasswordMessageAppears() {
        String message = invalidPasswordError.getAttribute("content-desc");
        System.out.println(message);
        if(message.contains("Enter at least 8 characters."))return true;
        else return false;
    }

}
