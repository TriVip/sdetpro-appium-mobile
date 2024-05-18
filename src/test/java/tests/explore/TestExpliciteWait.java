package tests.explore;

import io.appium.java_client.AppiumBy;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestExpliciteWait extends BaseTest {

  private static final long WAIT_TIME = 10L;

  @Test
  public void locatedBy() {
    // Will throw TimeOut
    new WebDriverWait(appiumDriver, Duration.ofSeconds(WAIT_TIME)).until(
        ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.accessibilityId("ABC")));
  }

  @Test
  public void locatedByElement() {
    // Will throw NoSuchElement
    new WebDriverWait(appiumDriver, Duration.ofSeconds(WAIT_TIME)).until(
        ExpectedConditions.visibilityOf(
            appiumDriver.findElement(AppiumBy.accessibilityId("ABC"))));
  }
}
