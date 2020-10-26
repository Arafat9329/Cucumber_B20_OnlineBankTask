package com.zerobank.pages;

import com.zerobank.utils.Browser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransactionsPage extends BasePage {

    @FindBy(xpath = "//a[.='Find Transactions']/..")
    private WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    private WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    private WebElement toDateInput;

    @FindBy(id = "aa_description")
    private WebElement descriptionInput;

    @FindBy(xpath = "//button[.='Find']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    private List<WebElement> listOfResultDate;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]")
    private List<WebElement> listOfResultDescription;

    public void clickfindTransactions(){
        Browser.waitElementToBeClickableAndClick(findTransactions);
    }

    public void enter_formAndToDate(String from, String to){
        fromDateInput.click();
        fromDateInput.sendKeys(from, Keys.ENTER);
        toDateInput.click();
        toDateInput.sendKeys(to,Keys.ENTER);
    }

    public void clickFindButton(){
        findButton.click();
    }

    public List<WebElement> firstAndLastDate(){
        List<WebElement> list = listOfResultDate;
//        for (WebElement each:list) {
//            System.out.println("each.getText() = " + each.getText());
//        }
     return list;
    }

    public boolean isSort(){

        List<WebElement> list = listOfResultDate;
        ArrayList<String> sortArrlist = new ArrayList<>();
        for (WebElement each:list){
            sortArrlist.add(each.getText());
        }
        Collections.sort(sortArrlist);
        Collections.reverse(sortArrlist);

        ArrayList<String> arrlist = new ArrayList<>();
        for (WebElement each:list){
            arrlist.add(each.getText());
        }

        System.out.println("sortArrlist = " + sortArrlist);
        System.out.println("arrlist = " + arrlist);
        return sortArrlist.equals(arrlist);
    }

    public boolean isContainOnly(String str){
    boolean res = false;
    List<WebElement> list = listOfResultDescription;

    for (WebElement each :list){
        if (each.getText().contains(str)){
            res =true;
        }else {
            res=false;
            System.out.println("FALSE: each.getText() = " + each.getText());
            list.clear();
            break;

        }
    }
        list.clear();
        return res;
    }

    public void enter_description(String str){
        Browser.waitEnterTextWhenVisibil(descriptionInput,str);
    }


}
