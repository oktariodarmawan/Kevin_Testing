package PageObject;

import PageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginPageLink = By.xpath("//A[@href='/login'][text()='Form Authentication']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickLoginPage(){
        driver.findElement(loginPageLink).click();
        return new LoginPage(driver);
    }

}
