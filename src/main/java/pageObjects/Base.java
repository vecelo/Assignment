package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;
    public String urlTesting;

    public WebDriver intializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Projects\\Assignment\\src\\main\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        urlTesting = prop.getProperty("url");

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Assignment\\src\\main\\resources\\chromedriver.exe");
            // chi can drive=new ChromeDriver
            // neu laf WebDriver driver = new ChromeDriver() ---> fail
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Assignment\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
        //This is general code to take screen shot
        TakesScreenshot chh = (TakesScreenshot)driver;
        File sourceFolder = chh.getScreenshotAs(OutputType.FILE);
        String targetFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
        FileUtils.copyFile(sourceFolder, new File(targetFile));
        return targetFile;
    }
}
