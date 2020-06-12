package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy (css = "th.sort-column[title=\"First Name\"]")
    WebElement sortFirstName;

    @FindBy (xpath = "//select[@id = \"formControlsSelect\"]")
    WebElement requestBtn;

    @FindBy (xpath = "//a[@class = \"query__filter__item\"]")
    WebElement requestSts;

    @FindBy (css = "button.btn:last-child")
    WebElement applyBtn;

    @FindBy (css = "table tr td:nth-child(2) div")
    List<WebElement> firstColumn;

    @FindBy (xpath = "//td[@class='td-request-approved uppercase']/following-sibling::td/div[contains(text(),'2019')]/ancestor::tr")
    List<WebElement> xpathQuery;

    @FindBy (css = "table tr td:nth-child(6)")
    List<WebElement> firstnameColumn;

    public WebElement filterBtn(){
        return filterBtn;
    }

    public WebElement requestBtn(){
        return requestBtn;
    }

    public WebElement ApplyBtn(){
        return applyBtn;
    }

    public WebElement getSortFirstName(){
        return sortFirstName;
    }

    public List<WebElement> getFirstColumn() {
        return firstColumn;
    }

    public List<WebElement> getFirstnameColumn() {
        return firstnameColumn;
    }

    public List<WebElement> getXpathQuery() {
        return xpathQuery;
    }

    public boolean isParentPortalOpened(){
        return Logo.getText().toString().contains("[ Parent Portal ]");
    }


}

