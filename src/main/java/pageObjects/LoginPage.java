package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//input[@name='email']")
    WebElement username;

    @FindBy(xpath ="//input[@id='formHorizontalPassword']")
    WebElement password;

    @FindBy(xpath ="//a[@class='col-login__btn']")
    WebElement LoginLink;

    public WebElement username(){
        return username;
    }

    public WebElement password(){
        return password;
    }

    public WebElement Loginbtn(){
        return LoginLink;
    }

    public void Login(WebDriver driver, String login,String pass) {
        username.sendKeys(login);
        password.sendKeys(pass);
        Loginbtn().click();
        }
}