package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber4.json",
        features = "src/test/resources/features/onlineBank/FindTransactions.feature",
        glue = "com/zerobank/stepDefinitions",
        tags = "not @bug",
        dryRun = false
)
public class FindTransactionsParallelRunner {
}
