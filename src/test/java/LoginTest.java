import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends Base {

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void LoginPage() throws InterruptedException {
        LoginPage a = new LoginPage(driver);
        a.username().sendKeys("admin@test.com");
        a.password().sendKeys("test123");
        a.Loginbtn().click();
        MainPage b = new MainPage(driver);
        Assert.assertTrue(b.getLogo().isDisplayed());
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
