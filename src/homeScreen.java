import com.paulhammant.ngwebdriver.ByAngularOptions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class homeScreen {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(xpath = "//android.widget.TextView[@text='איזור אישי']") MobileElement profile;
    @FindBy(xpath = "//android.widget.TextView[@text='ראשי']") MobileElement homePage;
    @FindBy(xpath = "//android.widget.TextView[@text='מתנות עד הבית']") MobileElement category;
    @FindBy(xpath = "//android.widget.TextView[@text='גרקו']") MobileElement wineSiteClick;
    @FindBy(id="il.co.mintapp.buyme:id/priceEditText") MobileElement priceEditText;
    @FindBy(id="il.co.mintapp.buyme:id/purchaseButton") MobileElement purchaseButton;
    @FindBy(xpath = "//android.widget.TextView[@text='הכל']")
    AndroidElement allCategories;
    @FindBy(xpath = "//android.widget.TextView[@text='גיפט קארד למסעדות שף']") MobileElement giftCardResturantChef;
    @FindBy(xpath = "//android.widget.TextView[@text='גיפט קארד לבתי ספא']") AndroidElement spa;
    @FindBy(xpath ="//android.widget.TextView[@text='גיפט קארד למותגי אופנה']") AndroidElement fashion;
    @FindBy(id ="il.co.mintapp.buyme:id/main_toolbar_title" ) AndroidElement mainToolBarTitle;
    public homeScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
    public void horizontalSwipe() {
           List<MobileElement> e=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/tab_title\")"));
          MobileElement firdelement=e.get(0);
          MobileElement secondElement=e.get(1);
          MobileElement thirdElement=e.get(2);

          int midOfY =thirdElement.getLocation().y +(thirdElement.getSize().height/2);
          String Text=thirdElement.getText();
          System.out.println(Text);
          System.out.println(midOfY);
          System.out.println(thirdElement.getSize().height);
          System.out.println(thirdElement.getLocation().y);
          int fromXLocation=thirdElement.getLocation().x;
          int toXLocation=firdelement.getLocation().x;

          TouchAction  action =new TouchAction(driver);
          action.press(PointOption.point(fromXLocation, midOfY))
                  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                  .moveTo(PointOption.point(toXLocation, midOfY))
                  .release()
                  .perform();}

}
