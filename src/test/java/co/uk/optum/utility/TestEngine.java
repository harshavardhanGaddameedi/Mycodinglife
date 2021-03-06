package co.uk.optum.utility;

//import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = {"co.uk.optum"},
        features = {"src//test//resources//features"},
       //tags = {"@smokeHR, @smoke"},
//       tags = {"@receivablesSmoke"},
        tags = {"@jenkins"},
        format = {"pretty","json:report/report.json","html:report/cucumber-reports","html:report/"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}

)


public class TestEngine {
    public static FeatureContext context;

    static {context = FeatureContext.getInstance();}

    @BeforeClass
    public static void setup() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh:mm");
        String dateString = format.format(curDate);

//        String reportFilePath = "report" + File.separator + "Test Results_" + dateString + "_report.html";
//        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportFilePath));reportFilePath
    }


    }

