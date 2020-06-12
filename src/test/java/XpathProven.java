import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class XpathProven extends Base {

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        LoginPage lp = new LoginPage(driver);
        lp.Login(driver, " ", " ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void XpathProven() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        WebDriverWait wa = new WebDriverWait(driver,10);

        //Check if page is opened
        Assert.assertTrue(mp.isParentPortalOpened());

        //Store in variable
        List<WebElement> xpathReturn = mp.getXpathQuery();
        for(WebElement ele : xpathReturn){
            System.out.println(ele.getText()+ '\n');
        }


    }


    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
