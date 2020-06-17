import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class chooseGiftScreen {
    private static AndroidDriver<MobileElement> driver;

    @FindBy(xpath ="//android.widget.TextView[@text='BUYME TOTAL - שובר משולב לרשתות מובילות']")
    AndroidElement buyMeTotal;
    public chooseGiftScreen (AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
}
