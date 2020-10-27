package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
 @CucumberOptions(
         features = "src/test/resources/features",
         glue = "com/zerobank/stepDefinitions",
         tags = "@OB3",
         dryRun = false
 )
 public class CucumberRunner {

}


