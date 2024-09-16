package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.xpath("//INPUT[@id='username']");
    private By passwordField = By.xpath("//INPUT[@id='password']");
    private By loginButton = By.xpath("//I[@class='fa fa-2x fa-sign-in'][text()=' Login']");
    private By statusAlert = By.id("flash");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public WebElement passwordField(){
        return driver.findElement(passwordField);
    }

}
