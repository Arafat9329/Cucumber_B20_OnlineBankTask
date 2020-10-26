package com.zerobank.pages;

import com.zerobank.utils.Browser;
import com.zerobank.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//a[.='Savings']")
    private WebElement savings;

    @FindBy(id = "aa_accountId")
    private WebElement accountDropdownSelector;

    /**
     *
     * @param type: Savings, Brokerage, Checking, Credit Card, Loan
     */
    public void click_Account_types(String type){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+type+"']"));
       // if (!type.equalsIgnoreCase("Savings")) {
            Browser.scrollTo(element);
       // }
        Browser.waitElementToBeClickableAndClick(element);
    }
    public void clickSavings(){
        Browser.waitElementToBeClickableAndClick(savings);
    }

    public String accountDropdownSelector_firstSelected(){
        Select select = new Select(accountDropdownSelector);
        return select.getFirstSelectedOption().getText();
    }

}
