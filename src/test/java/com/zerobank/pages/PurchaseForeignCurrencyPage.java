package com.zerobank.pages;

import com.zerobank.utils.Browser;
import com.zerobank.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage {

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']/..")
    private WebElement click_payBillsTab_PurchaseForeignCurrency;

    @FindBy(xpath = "//select[@id='pc_currency']//option")
    private List<WebElement> currencyList;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCostsButton;

    @FindBy(id = "purchase_cash")
    private WebElement purchaseButton;


    public void click_payBillsTab_PurchaseForeignCurrency(){
        Browser.waitElementToBeClickableAndClick(click_payBillsTab_PurchaseForeignCurrency);
    }

    public ArrayList<String> currencyList(){
       List<WebElement> list = currencyList;
       ArrayList<String> arrayList = new ArrayList<>();
       for (WebElement each :list){
           arrayList.add(each.getText());
       }
        System.out.println("arrayList = " + arrayList);
       return arrayList;
    }

    public void click_calculateCostsButton(){
        Browser.waitElementToBeClickableAndClick(calculateCostsButton);
    }

    public void click_purchaseButton(){
        Browser.waitElementToBeClickableAndClick(purchaseButton);
    }

    public boolean isAlarDisplay(){
        Alert alert = Driver.getDriver().switchTo().alert();
        String errorMessage=alert.getText();

        return !errorMessage.isEmpty();

    }
}
