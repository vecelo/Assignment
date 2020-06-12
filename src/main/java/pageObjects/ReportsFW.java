package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsFW {

    ExtentReports rp11;

    public getReportObject(){
        String paths = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter rp1 = new ExtentSparkReporter(paths);
        ExtentReports rp11 = new ExtentReports();
        rp1.config().setReportName("Assignment Results");
        rp1.config().setDocumentTitle("Test Results");
        rp11 = new ExtentReports();
        rp11.attachReporter(rp1);
        rp11.setSystemInfo("Tester" , "Y-O-U-R-N-A-M-E");
        return rp11;
    }
}
