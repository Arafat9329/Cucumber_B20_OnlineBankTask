package com.zerobank.pages;

import com.zerobank.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage {

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsTab;

    @FindBy(xpath = "//a[.='Add New Payee']/..")
    private WebElement click_payBillsTab_addNewPayee;

    public void click_topTab_payBills(){
        Browser.waitElementToBeClickableAndClick(payBillsTab);
    }

    public void click_payBillsTab_addNewPayee(){
        Browser.waitElementToBeClickableAndClick(click_payBillsTab_addNewPayee);
    }
}
