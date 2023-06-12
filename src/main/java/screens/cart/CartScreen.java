package screens.cart;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import screens.BaseScreen;

public class CartScreen extends BaseScreen {

    public CartScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.iherb:id/title")
    MobileElement cartConfirmBtn;

    @FindBy(id = "com.iherb:id/btn_view_cart")
    MobileElement toCartBtn;

    @FindBy(id = "com.iherb:id/product_card_display_name")
    MobileElement productTitle;

    public boolean cartConfirmCheck(){
        if(cartConfirmBtn.getText().contains("Added to cart!")) return true;
        else return false;
    }

    public CartScreen toCartBtnClick(){
        toCartBtn.click();
        return new CartScreen(driver);
    }
    public boolean productTitleCheck(String text){
        if(productTitle.getText().contains(text)) return true;
        else return false;
    }

}
