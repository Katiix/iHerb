package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ReturningCustomerScreen extends BaseScreen{

    public ReturningCustomerScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Login Pages\"]/android.view.View[2]")
    MobileElement createAccountBtn;
    public CreateAccountScreen createAccount(){
        createAccountBtn.click();
        return new CreateAccountScreen(driver);
    }

}
