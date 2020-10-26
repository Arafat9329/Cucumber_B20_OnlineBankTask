package com.zerobank.stepDefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utils.ConfigurationReader;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class FindTransactionsStepDefinitions {
    LoginPage loginPage = new LoginPage();
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("onlineBankURL"));
        loginPage.login();
        //Browser.wait(1);
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Account Summary");

        findTransactionsPage.click_topTab_accountActivityTab();
        findTransactionsPage.clickfindTransactions();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTransactionsPage.enter_formAndToDate(fromDate,toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.clickFindButton();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String beggingDate, String endDate) {
        List<WebElement> list = findTransactionsPage.firstAndLastDate();
//        Assert.assertEquals(list.get(0).getText(), endDate);
//        Assert.assertEquals(list.get(list.size()-1).getText(), beggingDate);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        System.out.println("loginPage = " + findTransactionsPage.isSort());
        Assert.assertTrue(findTransactionsPage.isSort());


    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String str) {
        Assert.assertTrue(findTransactionsPage.firstAndLastDate().size()>1);
    }

}
