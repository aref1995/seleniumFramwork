package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features = "src/test/java/feature"
,glue = {"steps"}
,plugin =  {"pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/rerun.txt"},
monochrome = true)
public class TestRunner extends TestBase{
	
	
}
