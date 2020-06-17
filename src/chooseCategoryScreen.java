import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class chooseCategoryScreen {
    private static AndroidDriver<MobileElement> driver;
    private introRegistrationScreen introRgScreen;
    private homeScreen hmscreen;
    public chooseCategoryScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
    public void myTest1() throws Exception {
        Thread.sleep(2000);
        introRgScreen = new introRegistrationScreen(driver);
        Thread.sleep(2000);
        introRgScreen.skipButton.click();
        Thread.sleep(1000);
        introRgScreen.googleLogin.click();
        Thread.sleep(1000);
        introRgScreen.ChooseUser.click();
        //Thread.sleep(20000);// i gave this sleep because in the first time you have to write your phone manually and wait for approval message
        hmscreen = new homeScreen(driver);
        hmscreen.profile.click();
        hmscreen=new homeScreen(driver);
        hmscreen.homePage.click();
    }
}
