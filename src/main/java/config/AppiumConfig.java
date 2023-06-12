package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {
    protected static AppiumDriver<MobileElement> driver;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("deviceName", "nex");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("appPackage", "com.iherb");
        caps.setCapability("appActivity", "com.iherb.mobile.product.splash.view.SplashActivity");
        caps.setCapability("automationName", "Appium");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
