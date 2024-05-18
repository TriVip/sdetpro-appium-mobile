package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import models.pages.LoginPage;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

  private String username;
  private String password;

  public LoginFlow(AppiumDriver appiumDriver, String username, String password) {
    super(appiumDriver);
    this.username = username;
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void login() {
    LoginPage loginPage = new LoginPage(appiumDriver);
    if (!username.isEmpty()) {
      loginPage.username().clear();
      loginPage.username().sendKeys(username);
    }
    if (!password.isEmpty()) {
      loginPage.password().clear();
      loginPage.password().sendKeys(password);
    }
    loginPage.loginBtn().click();
  }

  public void verifyLogin() {
    final int MIN_PASS_LENGTH = 8;
    boolean isEmailValid = EmailValidator.getInstance().isValid(username);
    boolean isPasswordValid = password.length() >= MIN_PASS_LENGTH;

    if (isEmailValid && isPasswordValid) {
      verifyCorrectLoginCreds();
    }

    if (!isEmailValid) {
      verifyIncorrectEmailLogin();
    }

    if (!isPasswordValid) {
      verifyIncorrectPassword();
    }

  }

  // TODO: Implement this | reuse the dialog in the prev lessons
  private void verifyCorrectLoginCreds() {
  }

  private void verifyIncorrectEmailLogin() {
    String expectedInvalidEmailStr = "Please enter a valid email address";
    LoginPage loginPage = new LoginPage(appiumDriver);
    String actualInvalidEmailStr = loginPage.getInvalidEmailStr();
    if (!actualInvalidEmailStr.equalsIgnoreCase(expectedInvalidEmailStr)) {
      throw new RuntimeException("[ERR] Invalid email string incorrect!");
    }
  }

  private void verifyIncorrectPassword() {
    String expectedInvalidPasswordStr = "Please enter at least 8 characters";
    LoginPage loginPage = new LoginPage(appiumDriver);
    String actualInvalidPasswordStr = loginPage.getInvalidPasswordStr();
    if (!actualInvalidPasswordStr.equalsIgnoreCase(expectedInvalidPasswordStr)) {
      throw new RuntimeException("[ERR] Invalid password string incorrect!");
    }
  }

}
