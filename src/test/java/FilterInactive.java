import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterInactive extends Base {

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        LoginPage lp = new LoginPage(driver);
        lp.Login(driver, "admin@test.com", "test123");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testFilterwInactive() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        WebDriverWait wa = new WebDriverWait(driver,10);

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
        List<WebElement> realList = mp.getFirstColumn();
        ArrayList<String> sample = new ArrayList<String>();
        for (WebElement element : realList) {
            String name = element.getText();
            sample.add(name);
        }

        Assert.assertFalse(sample.contains("Inactive"));
        }


    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
