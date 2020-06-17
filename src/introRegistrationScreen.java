
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class introRegistrationScreen {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(id = "skipButton") MobileElement skipButton;
    @FindBy(id="googleButton") MobileElement googleLogin;
    @FindBy(id="com.google.android.gms:id/container") MobileElement ChooseUser;





    public introRegistrationScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }

    }

