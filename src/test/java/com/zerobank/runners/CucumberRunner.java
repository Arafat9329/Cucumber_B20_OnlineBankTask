package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
 @CucumberOptions(
         plugin = "json:target/cucumber1.json",
         features = "src/test/resources/features",
         glue = "com/zerobank/stepDefinitions",
         tags = "not @bug",
         dryRun = false
 )
 public class CucumberRunner {

}


