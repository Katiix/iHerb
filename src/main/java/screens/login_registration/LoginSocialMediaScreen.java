package screens.login_registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class LoginSocialMediaScreen extends BaseScreen {
    public LoginSocialMediaScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.iherb:id/login_page_button_sign_in_with_email")
    MobileElement signUpBtn;

    public ReturningCustomerScreen clickSignUp(){
        pause(2000);
        signUpBtn.click();
        return new ReturningCustomerScreen(driver);
    }


}
