package screens.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class BenefitsScreen extends BaseScreen {

    public BenefitsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.iherb:id/tv_next")
    MobileElement signUpButton;



    public LoginSocialMediaScreen signUp(){
        pause(2000);
        signUpButton.click();
        return new LoginSocialMediaScreen(driver);
    }

    public boolean signUpButtonPresent(){
        pause(4000);
        System.out.println(signUpButton.getText());
        if(signUpButton.getText().contains("Sign in / Create an account")){
            return true;
        }else return false;
    }
}
