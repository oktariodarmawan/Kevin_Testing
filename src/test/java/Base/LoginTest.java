package Base;

import PageObject.LoginPage;
import PageObject.SecureAreaPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void SuccessfuLoginWithValidCredentials(){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

    @Test
    public void LoginWithInvalidCredentials(){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecret!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your password is invalid!"),
                "Alert text is incorrect");
    }

    @Test
    public void emptyPassword(){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Your username is invalid!"),
                "Alert text is incorrect");
    }


}
