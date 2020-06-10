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

    @FindBy (css = "button.btn-filter")
    WebElement filterBtn;

    @FindBy (xpath = "//select[@id = \"formControlsSelect\"]")
    WebElement requestBtn;

    @FindBy (xpath = "//a[@class = \"query__filter__item\"]")
    WebElement requestSts;

    @FindBy (css = "button.btn:last-child")
    WebElement applyBtn;

    public WebElement getLogo() {
        return Logo;
    }

    public WebElement filterBtn(){
        return filterBtn;
    }

    public WebElement requestBtn(){
        return requestBtn;
    }

    public WebElement getRequestSts() {
        return requestSts;
    }


    public WebElement ApplyBtn(){
        return applyBtn;
    }

    public boolean isParentPortalOpened(){
        return Logo.getText().toString().contains("[ Parent Portal ]");
    }


}

