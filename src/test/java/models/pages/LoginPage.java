package models.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import models.components.login.LoginDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

  private final static By usernameSel = AppiumBy.accessibilityId("input-email");
  private final static By passwordSel = AppiumBy.accessibilityId("input-password");
  private final static By loginBtnSel = AppiumBy.accessibilityId("button-LOGIN");
  private final static By invalidEmailTxtSel = AppiumBy.xpath(
      "//*[contains(@text, 'valid email')]");
  private final static By invalidPasswordTxtSel = AppiumBy.xpath(
      "//*[contains(@text, 'at least 8')]");

  public LoginPage(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public WebElement username() {
    return component.findElement(usernameSel);
  }

  public WebElement password() {
    return component.findElement(passwordSel);
  }

  public WebElement loginBtn() {
    return component.findElement(loginBtnSel);
  }

  public String getInvalidEmailStr() {
    return component.findElement(invalidEmailTxtSel).getText();
  }

  public String getInvalidPasswordStr() {
    return component.findElement(invalidPasswordTxtSel).getText();
  }


  public LoginDialog loginDialog() {
    return new LoginDialog(appiumDriver);
  }

}
