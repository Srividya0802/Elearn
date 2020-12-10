package RunnerPack;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features= {"src/test/java/elearnFeatPack"},glue= {"stepDef"},monochrome=true,plugin= {"pretty" , "html:target/cucumber","json:target/CucumberTestReport.json" })
public class elearnRun extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;  

	  @BeforeClass(alwaysRun = true)  
	    public void setUpClass() throws Exception {  
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
	  }  

	    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	    public void scenario(CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());  
	  }  

	    @DataProvider  
	  public Object[][] scenarios() {  
	        return testNGCucumberRunner.provideFeatures();  
	  }  

	    @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	        testNGCucumberRunner.finish();  
	

	    }
	
}
