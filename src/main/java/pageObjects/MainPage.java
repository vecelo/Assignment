package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy (xpath = "//a[@class='navbar-brand']")
    WebElement Logo;

    public WebElement getLogo() {
        return Logo;
    }
}

