package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefinitions {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_savings_link_on_the_account_summary_page(String type) {
        accountActivityPage.click_Account_types(type);
    }

    @Then("the {string} page should be displayed")
    public void the_account_activity_page_should_be_displayed(String exp) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(exp));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_savings_selected(String exp) {
        Assert.assertEquals(exp,accountActivityPage.accountDropdownSelector_firstSelected());

    }

}
