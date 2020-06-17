import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class howToSendScreen {
    private static AndroidDriver<MobileElement> driver;

    @FindBy(id = "il.co.mintapp.buyme:id/step2Text") MobileElement step2Text;
    @FindBy(id="il.co.mintapp.buyme:id/nowRadioButton") MobileElement radioButton;
    @FindBy(xpath = "//android.widget.TextView[@text='במייל']") MobileElement emailSend;
    @FindBy(className = "android.widget.EditText") MobileElement email;
    @FindBy(xpath = "//android.widget.Button[@text='אישור התשלום ושליחת המתנה']") MobileElement confirmation;
    public howToSendScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
}
