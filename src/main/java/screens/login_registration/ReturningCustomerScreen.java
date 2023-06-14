package screens.login_registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;
import screens.HomeScreen;


public class ReturningCustomerScreen extends BaseScreen {

    public ReturningCustomerScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Create my account\"]")
    MobileElement createAccountBtn;

    @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Login Pages\"]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View")
    MobileElement email;
    @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Login Pages\"]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")
    MobileElement password;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    MobileElement signInBtn;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Invalid email, phone number, or password\"]")
    MobileElement invlaidEmailPassError;
    public CreateAccountScreen createAccount(){
        pause(4000);
        createAccountBtn.click();
        return new CreateAccountScreen(driver);
    }

    public ReturningCustomerScreen fillEmail(String text){
        pause(2000);
        email.click();
        driver.hideKeyboard();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        driver.hideKeyboard();
        return new ReturningCustomerScreen(driver);
    }

    public ReturningCustomerScreen fillPassword(String text){
        pause(2000);
        password.click();
        driver.hideKeyboard();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        return new ReturningCustomerScreen(driver);
    }

    public HomeScreen signIn(){
        signInBtn.click();
        return new HomeScreen(driver);
    }

    public boolean errorMessagePresent(){
        String message = invlaidEmailPassError.getAttribute("content-desc");
        System.out.println(message);
        if(message.contains("Invalid email, phone number, or password"))return true;
        else return false;

    }

    public HomeScreen logIn(String email, String password){
        fillEmail(email);
        fillPassword(password);
        signIn();
        return new HomeScreen(driver);
    }

}
