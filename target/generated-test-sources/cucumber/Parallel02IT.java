import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/finance.smokeTest/TC_0002_Revenue_InvoiceCreation.feature"},
        plugin = {"json:C:/Users/hg1004/Documents/GPE_Automation_GIT_20190214/target/cucumber-parallel/2.json"},

        tags = {"@RunTest"},
    monochrome = true,
glue = {"co.uk.optum"})
public class Parallel02IT {
}