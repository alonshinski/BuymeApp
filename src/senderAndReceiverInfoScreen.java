import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class senderAndReceiverInfoScreen {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(id = "il.co.mintapp.buyme:id/main_toolbar_title") MobileElement toolbarTitle;
    @FindBy(id="il.co.mintapp.buyme:id/toEditText") MobileElement forWhoTheGift;
    @FindBy(id="il.co.mintapp.buyme:id/blessEditText") MobileElement blessedText;
    @FindBy(id="il.co.mintapp.buyme:id/goNextButton") MobileElement goNextButton;
    @FindBy(id="android:id/text1")  MobileElement whatKindOfEvent;
    public senderAndReceiverInfoScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
}
