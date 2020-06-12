import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstnameSort extends Base {

    @BeforeTest
    public void setUpDriver() throws IOException {
        driver = intializeDriver();
        driver.get(urlTesting);
        LoginPage lp = new LoginPage(driver);
        lp.Login(driver, " ", " ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testFirstnameSort() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        WebDriverWait wa = new WebDriverWait(driver,10);

        //Check if page is opened
        Assert.assertTrue(mp.isParentPortalOpened());

        //Sort on AUT
        mp.getSortFirstName().click();

        //Store in variable
        List<WebElement> varList = mp.getFirstnameColumn();

        //Copy to sourceList
        ArrayList<String> sourceList =new ArrayList<String>();
        for(int i = 0;i<varList.size();i++){
            sourceList.add(varList.get(i).getText());
        }

        //Init a bakList for compare
        ArrayList<String> draftList = new ArrayList<String>();

        //Copy to drafList
        for (WebElement element : varList) {
            String name = element.getText();
            draftList.add(name);
        }

        //Sort drafList by yourself
        Collections.sort(draftList);
        for(String ele : draftList){
            System.out.println(ele);
        }

        //Compare drafList with sourceList
        Assert.assertTrue(sourceList.equals(draftList));

    }


    @AfterTest
    public void tearDown(){
        driver.close();
        rp11.flush();
    }

}
