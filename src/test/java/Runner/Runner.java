package Runner;

import io.cucumber.testng.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"Runner"},
        plugin = {
                "summary",
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json"
        })

public class Runner extends AbstractTestNGCucumberTests {

        private TestNGCucumberRunner testNGCucumberRunner;
        WebDriver driver;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());


        }

        @Test(groups = "cucumber scenarios",
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios")
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper)  {
                testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        }

        @DataProvider
        public Object[][] scenarios() {
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
                testNGCucumberRunner.finish();
        }

}