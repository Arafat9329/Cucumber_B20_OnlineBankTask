package com.zerobank.pages;

import com.zerobank.utils.Browser;
import com.zerobank.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);

    @FindBy(id = "account_activity_tab")
    private WebElement topTab_accountActivityTab;

    public void click_topTab_accountActivityTab(){
        Browser.waitElementToBeClickableAndClick(topTab_accountActivityTab);
    }

}
