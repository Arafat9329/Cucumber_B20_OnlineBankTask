package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report5.html",
                "json:target/cucumber5.json",},
        features = "src/test/resources/features/onlineBank/StatementsAndDocuments.feature",
        glue = "com/zerobank/stepDefinitions",
        tags = "not @bug",
        dryRun = false
)
public class StatementsAndDocumentsParallelRunner {
}
