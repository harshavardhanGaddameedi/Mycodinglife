package co.uk.optum.utility;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
//@CucumberOptions(
//
//        glue = {"co.uk.optum"},
//        features = {"src/test/resources/features/"},
//        tags = {"@wip"},
//        format = {"pretty","json:report/report.json"},
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"})
//C:\GP_Empower_Automation1\src\test\resources\features\finance.smokeTest

@CucumberOptions(
        glue = {"co.uk.optum"},
        features = {"src//test//resources//features"},
//        tags = {"@smokeHR, @smoke"},
        tags = {"@maventest"},
//        format = {"pretty","json:report/report.json","html:report/cucumber-reports","html:report/"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
//        format = {"pretty","html:report/results.html"},
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
        )
public class TestEngine {
    public static FeatureContext context;


    static {context = FeatureContext.getInstance();}

    @BeforeClass
    public static void setup() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh:mm");
        String dateString = format.format(curDate);

        String reportFilePath = "report" + File.separator + "Test Results_" + dateString + "_report.html";
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportFilePath));
    }


    }






