package com.zerobank.stepDefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utils.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

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

    /**
     *
     *       |Payee Name    | The Law Offices of Hyde, Price & Scharks|
     *       |Payee Address | 100 Same st, Anytown, USA, 10001        |
     *       |Account       | Checking                                |
     *       |Payee details | XYZ account                             |
     */
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {

        addNewPayeePage.enter_payeeName(dataTable.get("Payee Name"));
        addNewPayeePage.enter_payeeAddress(dataTable.get("Payee Address"));
        addNewPayeePage.enter_account(dataTable.get("Account"));
        addNewPayeePage.enter_payeeDetails(dataTable.get("Payee details"));
        addNewPayeePage.click_addButton();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_the_new_payee_the_law_offices_of_hyde_price_scharks_was_successfully_created_should_be_displayed() {
        Assert.assertEquals("The new payee The Law Offices of Hyde, Price & Scharks was successfully created.",addNewPayeePage.get_messagePopUpMessage());
    }

}
