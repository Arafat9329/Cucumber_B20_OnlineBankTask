package com.zerobank.stepDefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utils.ConfigurationReader;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDefinitions {
    LoginPage loginPage = new LoginPage();
    AddNewPayeePage addNewPayeePage = new AddNewPayeePage();
    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("onlineBankURL"));
        loginPage.login();

        addNewPayeePage.click_topTab_payBills();
        purchaseForeignCurrencyPage.click_payBillsTab_PurchaseForeignCurrency();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        System.out.println("dataTable = " + dataTable);
        ArrayList<String> arrayList = purchaseForeignCurrencyPage.currencyList();

        System.out.println("arrayList = " + arrayList);
        for (String each: dataTable){
            System.out.println("arrayList.contains(each) = " + each);
            Assert.assertTrue( arrayList.contains(each));
        }

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
       purchaseForeignCurrencyPage.click_calculateCostsButton();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(purchaseForeignCurrencyPage.isAlarDisplay());

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        purchaseForeignCurrencyPage.click_calculateCostsButton();
    }
}
