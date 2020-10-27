package com.zerobank.pages;

import com.zerobank.utils.Browser;
import io.cucumber.java.nl.Stel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.WEmbeddedFrame;

import java.util.ArrayList;
import java.util.Arrays;
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

    @FindBy(id = "aa_type")
    private WebElement typeSelector;

    @FindBy(xpath = "//button[.='Find']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    private List<WebElement> listOfDateResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]")
    private List<WebElement> listOfDescriptionResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]")
    private List<WebElement> listOfDepositResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]")
    private List<WebElement> listOfWithdrawalResult;



    public void clickfindTransactions(){
        Browser.waitElementToBeClickableAndClick(findTransactions);
    }

    public void enter_formAndToDate(String from, String to){
        fromDateInput.click();
        fromDateInput.clear();
        fromDateInput.sendKeys(from, Keys.ENTER);
        toDateInput.click();
        toDateInput.clear();
        toDateInput.sendKeys(to,Keys.ENTER);
    }

    public void clickFindButton(){
        findButton.click();
    }

    public List<WebElement> firstAndLastDate(){
        List<WebElement> list = listOfDateResult;
     return list;
    }

    public boolean firstAndLastDate(String beginningDate, String endDate){
        List<WebElement> list = listOfDateResult;
        ArrayList<Integer>arrayList = new ArrayList<Integer>();
        for (WebElement each:list){
           arrayList.add(Integer.parseInt(each.getText().replaceAll("-",""))) ;
        }
        System.out.println("arrayList = " + arrayList);

        ArrayList<Integer>rangeList= new ArrayList<Integer>();
        int start = Integer.parseInt(beginningDate.replaceAll("-",""));
        int end = Integer.parseInt(endDate.replaceAll("-",""));
        int range = end-start;
        rangeList.add(start);
        System.out.println("rangeList = " + rangeList);
        System.out.println("rangeList.get(rangeList.size()-1) = " + rangeList.get(rangeList.size() - 1));
        for (int i = 0; i < range; i++) {
            int addOne=rangeList.get(rangeList.size() - 1);
            rangeList.add((addOne+1));
            System.out.println("addOne = " + addOne);
        }
        System.out.println("rangeList = " + rangeList);
        System.out.println("arrayList = " + arrayList);
        System.out.println("rangeList.containsAll(arrayList) = " + rangeList.containsAll(arrayList));

        return  rangeList.containsAll(arrayList);
    }

    public boolean isSort(){
        List<WebElement> list = listOfDateResult;

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
        Browser.wait(2);
        boolean res = false;
        List<WebElement> list = listOfDescriptionResult;
        //Browser.waitToVisible(listOfResultDescription);
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
        Browser.waitEnterTextWhenVisible(descriptionInput,str);
    }

    public ArrayList<String>listOfDepositResult(){
        Browser.wait(2);
        List<WebElement> list = listOfDepositResult;
        System.out.println("list = " + list.size());

        ArrayList<String>arrayList= new ArrayList<>();
        for (WebElement each:list){
            if (!each.getText().equals("")){
                arrayList.add(each.getText());
            }
        }
        System.out.println("arrayList = " + arrayList.size());
        return arrayList;
    }

    public ArrayList<String>listOfWithdrawalResult(){
        Browser.wait(2);
        List<WebElement> list = listOfWithdrawalResult;
        ArrayList<String>arrayList= new ArrayList<>();
        for (WebElement each:list){
            if (!each.getText().equals("")){
                arrayList.add(each.getText());
            }
        }

        return arrayList;
    }

    public void typeSelector(String visibleText){
        Select select = new Select(typeSelector);
        select.selectByVisibleText(visibleText);
    }
}
