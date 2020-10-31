package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber6.json",
        features = "src/test/resources/features/onlineBank/StatementsAndDocuments.feature",
        glue = "com/zerobank/stepDefinitions",
        tags = "not @bug",
        dryRun = false
)
public class StatementsAndDocumentsParallelRunner {
}
