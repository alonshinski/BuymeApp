import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class profile {
    private static AndroidDriver<MobileElement> driver;
    private introRegistrationScreen introRgScreen;
    private homeScreen hmscreen;
    @FindBy(id ="il.co.mintapp.buyme:id/name") MobileElement profileTab;
    @FindBy(xpath = "//android.widget.TextView[@text='על BUYME']")
    AndroidElement onBuyMe;
    @FindBy(id ="il.co.mintapp.buyme:id/contentText") AndroidElement contentText;



    public profile(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
    public void goToProfile() throws InterruptedException {
        //Thread.sleep(2000);
        introRgScreen = new introRegistrationScreen(driver);
       // Thread.sleep(2000);
        introRgScreen.skipButton.click();
       // Thread.sleep(1000);
        introRgScreen.googleLogin.click();
       //Thread.sleep(1000);
        introRgScreen.ChooseUser.click();
        //Thread.sleep(20000);// i gave this sleep because in the first time you have to write your phone manually and wait for approval message
        hmscreen = new homeScreen(driver);
        hmscreen.profile.click();
    }
}
