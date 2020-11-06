package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.StatementsAndDocumentsDetailsPage;
import com.zerobank.utils.Browser;
import com.zerobank.utils.ConfigurationReader;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class StatementsAndDocumentsDetailsStepDefinitins {
    LoginPage loginPage = new LoginPage();
    StatementsAndDocumentsDetailsPage statementsAndDocumentsDetailsPage = new StatementsAndDocumentsDetailsPage();

    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_statements_documents_tab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("onlineBankURL"));
        loginPage.login();

        statementsAndDocumentsDetailsPage.click_onlineStatementsTab();
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_recent_statements_year(int year) {
        statementsAndDocumentsDetailsPage.click_year(year);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int numberOfRecord) {
        Assert.assertEquals(numberOfRecord, statementsAndDocumentsDetailsPage.statementsListNumber());
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statementName) {
        statementsAndDocumentsDetailsPage.click_statement(statementName);
        Browser.wait(2);//wait for downloading
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        System.out.println("statementsAndDocumentsDetailsPage.lastFileName() = " + statementsAndDocumentsDetailsPage.lastFileName());
        System.out.println("string = " + string);
        Assert.assertTrue(statementsAndDocumentsDetailsPage.lastFileName().contains(string));

    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(statementsAndDocumentsDetailsPage.lastFileName().contains("pdf"));
    }

}


