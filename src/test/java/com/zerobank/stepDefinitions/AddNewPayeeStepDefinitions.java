package com.zerobank.stepDefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utils.ConfigurationReader;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewPayeeStepDefinitions {
    LoginPage loginPage = new LoginPage();
    AddNewPayeePage  addNewPayeePage = new AddNewPayeePage();

    @Given("Add New Payee tab")
    public void add_new_payee_tab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("onlineBankURL"));
        loginPage.login();

        addNewPayeePage.click_topTab_payBills();
        addNewPayeePage.click_payBillsTab_addNewPayee();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_the_new_payee_the_law_offices_of_hyde_price_scharks_was_successfully_created_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
