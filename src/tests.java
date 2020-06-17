import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class tests {
   private static AndroidDriver<MobileElement> driver;
    private static ExtentReports extent;
    private static ExtentTest myTests;
    static String ImagesPath = "C:\\Users\\Alon\\Desktop\\selenium\\screenShots";
    private introRegistrationScreen introRgScreen;
    private homeScreen hmscreen;
    private howToSendScreen sendScreen;
    private senderAndReceiverInfoScreen senderAndReceiverInfo;
    private profile prf;
    private chooseGiftScreen chooseGiftScreen;
    private chooseCategoryScreen chooseCategoryScreen;
    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void setUp() throws Exception {
        extent = new ExtentReports(generalPage.readFromFile("reportPath"));
        extent.loadConfig(new File("C:\\Users\\Alon\\Desktop\\selenium\\Myconfigs\\reportConfig.xml"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", generalPage.readFromFile("appPackage"));
        capabilities.setCapability("appActivity", generalPage.readFromFile("appActivity"));
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test public void Test_01_ChooseAUser() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
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
        prf = new profile(driver);
        String profileNameText=prf.profileTab.getText();
        System.out.println(profileNameText);
        String expectedNameText=generalPage.readFromFile("myFirstName");
try {
    Assert.assertEquals(expectedNameText, profileNameText);
    myTests.log(LogStatus.PASS, "Test passed",
            myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
}
catch (AssertionError e){
    myTests.log(LogStatus.FAIL, "AssertionError" + e);
}
        hmscreen=new homeScreen(driver);
        hmscreen.homePage.click();
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
    }
    @Test public void Test_02_ChooseAGift() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        hmscreen=new homeScreen(driver);
        hmscreen.homePage.click();
        hmscreen.category.click();
        String text = "גרקו";
        MobileElement el = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
        hmscreen.wineSiteClick.click();
        hmscreen.priceEditText.click();
        hmscreen.priceEditText.sendKeys(generalPage.readFromFile("myGiftPrice"));
        hmscreen.purchaseButton.click();
        senderAndReceiverInfo=new senderAndReceiverInfoScreen(driver);
        String toolbarText=senderAndReceiverInfo.toolbarTitle.getText();
        System.out.println(toolbarText);
        String expectedToolbarText=generalPage.readFromFile("toWhoTheGift");
        try{
            Assert.assertEquals(expectedToolbarText,toolbarText);
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
        }
        catch (AssertionError e){
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
    }
    @Test public void Test_03_senderAndReceiverInfo() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        String text = "Alon";
        MobileElement el = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
        senderAndReceiverInfo=new senderAndReceiverInfoScreen(driver);
        senderAndReceiverInfo.forWhoTheGift.click();
        senderAndReceiverInfo.forWhoTheGift.sendKeys(generalPage.readFromFile("toWhoSend"));
        senderAndReceiverInfo.whatKindOfEvent.click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='מתנות לעובדים']")).click();
        senderAndReceiverInfo.blessedText.clear();
        senderAndReceiverInfo.blessedText.sendKeys(generalPage.readFromFile("blessing"));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        senderAndReceiverInfo.goNextButton.click();
        sendScreen=new howToSendScreen(driver);
        String step2Text=sendScreen.step2Text.getText();
        String expectedStep2Text=generalPage.readFromFile("step2Text");
        try{
            Assert.assertEquals(expectedStep2Text,step2Text);
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
        }
        catch (AssertionError e){
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
    }
    @Test public void Test_04_howToSendScreen() throws Exception {
        myTests = extent.startTest(name.getMethodName());
        myTests.log(LogStatus.INFO, "Start of the Test");
        sendScreen=new howToSendScreen(driver);
        boolean selected_value=sendScreen.radioButton.isSelected();
         if(!selected_value) {
             sendScreen.radioButton.click();
         }
       // sendScreen.emailSend.click();
        List list = driver.findElements(By.className("android.widget.CheckBox"));
        ((MobileElement) list.get(2)).click();
        sendScreen.emailSend.click();
        Thread.sleep(1000);
        String text = "המשך";
        MobileElement el = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
        sendScreen.email.sendKeys(generalPage.readFromFile("email"));
        driver.hideKeyboard();
        senderAndReceiverInfo=new senderAndReceiverInfoScreen(driver);
        senderAndReceiverInfo.goNextButton.click();
        String confirmationText=sendScreen.confirmation.getText();
        String expectedConfirmationText=generalPage.readFromFile("confirmation");
        try{
            Assert.assertEquals(expectedConfirmationText,confirmationText);
            myTests.log(LogStatus.PASS, "Test passed",
                    myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
        }
        catch (AssertionError e){
            myTests.log(LogStatus.FAIL, "AssertionError" + e);
        }
        myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
        driver.closeApp();
    }
      @Test public void Test_05_ExtrasSwipingLeft() throws Exception {
          driver.launchApp();
          myTests = extent.startTest(name.getMethodName());
          myTests.log(LogStatus.INFO, "Start of the Test");
          chooseCategoryScreen =new chooseCategoryScreen(driver);
          chooseCategoryScreen.myTest1();
          hmscreen=new homeScreen(driver);
          hmscreen.horizontalSwipe();
          hmscreen.fashion.click();
          String categoryText=hmscreen.mainToolBarTitle.getText();
          String expectedCategoryText=generalPage.readFromFile("categoryText");
          try{
              Assert.assertEquals(expectedCategoryText,categoryText);
              myTests.log(LogStatus.PASS, "Test passed",
                      myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
          }
          catch (AssertionError e){
              myTests.log(LogStatus.FAIL, "AssertionError" + e);
          }
          myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
      }
      @Test public void Test_06_ExtrasAfterChoosingCategory() throws Exception {
          myTests = extent.startTest(name.getMethodName());
          myTests.log(LogStatus.INFO, "Start of the Test");
          chooseGiftScreen=new chooseGiftScreen(driver);
          chooseGiftScreen.buyMeTotal.click();
          hmscreen=new homeScreen(driver);
          hmscreen.priceEditText.click();
          hmscreen.priceEditText.sendKeys(generalPage.readFromFile("myGiftPrice2"));
          hmscreen.purchaseButton.click();
          String categoryText=hmscreen.mainToolBarTitle.getText();
          String expectedCategoryText=generalPage.readFromFile("toWhoTheGift");
          try{
              Assert.assertEquals(expectedCategoryText,categoryText);
              myTests.log(LogStatus.PASS, "Test passed",
                      myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
          }
          catch (AssertionError e){
              myTests.log(LogStatus.FAIL, "AssertionError" + e);
          }
          myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
          driver.closeApp();
      }
      @Test public void Test_07_ExtrasSettingScreen() throws Exception {
          driver.launchApp();
          myTests = extent.startTest(name.getMethodName());
          myTests.log(LogStatus.INFO, "Start of the Test");
          prf = new profile(driver);
          prf.goToProfile();
          prf.onBuyMe.click();
          String onBuyMeText=prf.contentText.getText();
          String expectedOnBuyMeText=generalPage.readFromFile("onBuyMeText");
          try{
              Assert.assertEquals(expectedOnBuyMeText,onBuyMeText);
              myTests.log(LogStatus.PASS, "Test passed",
                      myTests.addScreenCapture(takeScreenShot(ImagesPath + "\\" + System.currentTimeMillis())));
              myTests.log(LogStatus.INFO,onBuyMeText);
          }
          catch (AssertionError e){
              myTests.log(LogStatus.FAIL, "AssertionError" + e);
          }
          myTests.log(LogStatus.INFO, "End of the Test" + name.getMethodName());
      }

    @After
    public void myAfter(){
        extent.endTest(myTests);
    }


    @AfterClass
    public static void myAfterClass(){
        driver.quit();
        extent.flush();
    }
    static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}