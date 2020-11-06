package com.zerobank.pages;

import com.zerobank.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage {

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsTab;

    @FindBy(xpath = "//a[.='Add New Payee']/..")
    private WebElement click_payBillsTab_addNewPayee;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeNameInput;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    private WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement addButton;

    @FindBy(id = "alert_content")
    private WebElement messagePopUp;


    public void click_topTab_payBills(){
        Browser.waitElementToBeClickableAndClick(payBillsTab);
    }

    public void click_payBillsTab_addNewPayee(){
        Browser.waitElementToBeClickableAndClick(click_payBillsTab_addNewPayee);
    }

    public void enter_payeeName(String text){
        Browser.waitEnterTextWhenVisible(payeeNameInput,text);
    }

    public void enter_payeeAddress(String tex){
        Browser.waitEnterTextWhenVisible(payeeAddressInput,tex);
    }

    public void enter_account(String text){
        Browser.waitEnterTextWhenVisible(accountInput,text);
    }

    public void enter_payeeDetails(String text){
        Browser.waitEnterTextWhenVisible(payeeDetails,text);

    }

    public void click_addButton(){
        Browser.waitElementToBeClickableAndClick(addButton);
    }

    public String get_messagePopUpMessage(){
        return messagePopUp.getText();
    }

}

