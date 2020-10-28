package com.zerobank.pages;

import com.zerobank.utils.Browser;
import com.zerobank.utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class StatementsAndDocumentsDetailsPage extends BasePage{

    @FindBy(xpath = "//a[.='Online Statements']/..")
    private WebElement onlineStatementsTab;

    @FindBy(xpath = "//div[@class='tab-pane active']//tbody//tr")
    private List<WebElement> statementsList;

    public void click_onlineStatementsTab(){
        Browser.waitElementToBeClickableAndClick(onlineStatementsTab);
    }

    public void click_year(int year){
        WebElement yearElement = Driver.getDriver().findElement(By.xpath("//a[.='"+(year+"")+"']"));
        Browser.waitElementToBeClickableAndClick(yearElement);
    }

    public int statementsListNumber(){
        return statementsList.size();
    }

    public void click_statement(String statementName){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+statementName+"']"));
        Browser.waitElementToBeClickableAndClick(element);
    }

    public String lastFileName(){
        String donloadPath ="C:\\Users\\a9329\\Downloads";
        File dir = new File(donloadPath);
        File[] files  =  dir.listFiles();
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        System.out.println("lastModifiedFile.getName() = " + lastModifiedFile.getName());
        return lastModifiedFile.getName();
    }



}
