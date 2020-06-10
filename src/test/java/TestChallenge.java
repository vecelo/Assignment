import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestChallenge extends Base {

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        LoginPage lp = new LoginPage(driver);
        lp.Login(driver,"admin@test.com", "test123");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testFilterwInactive() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        WebDriverWait wa = new WebDriverWait(driver,5);

        //Check if page is opened
        Assert.assertTrue(mp.isParentPortalOpened());

        //Click Filters
        mp.filterBtn().click();

        Select sts = new Select(mp.requestBtn());
        sts.selectByValue("inactive");

        //Click Apply
        mp.ApplyBtn().click();
        Thread.sleep(5000);

        //Verify Status is INACTIVE

//        Assert.assertEquals(mp.getRequestSts().getAttribute("innerHTML"),"Request Status: \n Inactive");

    }

//    @Test
//    public void testFirstNameColumn() throws InterruptedException {
//
//        MainPage mp = new MainPage(driver);
//        //Check if page is opened
//        Assert.assertTrue(mp.isParentPortalOpened());
//
//        Thread.sleep(3000);
//        mp.filterBtn().click();
//        Thread.sleep(3000);
//
//        mp.requestBtn().sendKeys(Keys.DOWN);
//        mp.requestBtn().sendKeys(Keys.DOWN);
//        mp.requestBtn().sendKeys(Keys.DOWN);
//        mp.requestBtn().sendKeys(Keys.DOWN);
//        mp.requestBtn().sendKeys(Keys.DOWN);
//        Thread.sleep(3000);
//
//
//
//        mp.ApplyBtn().click();
//        Thread.sleep(3000);
//    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
