package co.uk.optum.utility;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.lexer.Ca;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.time.LocalDate.*;

@RunWith(Cucumber.class)
//@CucumberOptions(
//
//        glue = {"co.uk.optum"},
//        features = {"src/test/resources/features/"},
//        tags = {"@wip"},
//        format = {"pretty","json:report/report.json"},
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"})

@CucumberOptions(
        glue = {"co.uk.optum"},
        features = {"src/test/resources/features/"},
        tags = {"@wip"},
        format = {"pretty","json:report/report.json"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
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




