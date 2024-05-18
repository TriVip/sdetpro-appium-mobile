package tests;

import driver.DriverFactory;
import driver.Platform;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected static AppiumDriver appiumDriver;

  @BeforeTest
  public void initAppiumDriverSession() {
    appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
  }

  @AfterTest(alwaysRun = true)
  public void quitAppiumDriverSession() {
    appiumDriver.quit();
  }

}
