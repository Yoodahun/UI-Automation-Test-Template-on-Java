package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReports() {
        String filePath = System.getProperty("user.dir") + "/report/index.html";
        System.out.println(filePath);

        ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
        reporter.config().setReportName("Automation Result");
        reporter.config().setDocumentTitle("Test result");
        ExtentReports report = new ExtentReports();
        report.attachReporter(reporter);

        return report;

    }
}
