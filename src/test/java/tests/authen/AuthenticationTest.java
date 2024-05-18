package tests.authen;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class AuthenticationTest extends BaseTest {

  @Test
  public void loginWithCreds() {
    List<LoginCredData> loginCredData = new ArrayList<>();
    loginCredData.add(new LoginCredData("teo@", "87654321"));
    loginCredData.add(new LoginCredData("teo@sth.com", "123456"));
    loginCredData.add(new LoginCredData("teo@sth.com", "12345678"));

    for (LoginCredData loginCred : loginCredData) {
      LoginFlow loginFlow = new LoginFlow(
          appiumDriver, loginCred.getUsername(), loginCred.getPassword()
      );
      loginFlow.gotoLoginScreen();
      loginFlow.login();
      loginFlow.verifyLogin();
    }
  }

  // Data Model Class
  public static class LoginCredData {

    private String username;
    private String password;

    public LoginCredData(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }
  }
}
