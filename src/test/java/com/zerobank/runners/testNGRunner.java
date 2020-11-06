package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin =  {"json:target/cucumberTestNG.json",
                "html:target/cucumber-reportTestNG.html",
                "rerun:target/rerun.txt"
                   },
        features = "src/test/resources/features",
        glue = "com/zerobank/stepDefinitions",
        publish = true
                )

public class testNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
