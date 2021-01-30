package com.registration.pageobject;

import com.registration.base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistraionDetailsPage extends WebDriverBase {

    @FindBy(xpath="//*[@id=\"m\"]/div[2]/div[4]/div[1]/div/span/div[2]/dl[1]/dd")
    private WebElement regnum;
    @FindBy(xpath="//*[@id=\"m\"]/div[2]/div[4]/div[1]/div/span/div[2]/dl[2]/dd")
    private WebElement make;
    @FindBy(xpath="//*[@id=\"m\"]/div[2]/div[4]/div[1]/div/span/div[2]/dl[3]/dd")
    private WebElement model;
    @FindBy(xpath="//*[@id=\"m\"]/div[2]/div[4]/div[1]/div/span/div[2]/dl[4]/dd")
    private WebElement colour;
    @FindBy(xpath="//*[@id=\"m\"]/div[2]/div[4]/div[1]/div/span/div[2]/dl[5]/dd")
    private WebElement year;

    public RegistraionDetailsPage(){

        PageFactory.initElements(driver,this);
    }

    public String getRegistrionNumber() throws InterruptedException {
        Thread.sleep(5000);
       return  regnum.getText();
    }
    public String getMake(){
        return  make.getText();
    }
    public String getModel(){
        return  model.getText();
    }
    public String getColour(){
        return  colour.getText();
    }
    public String getYear(){
        return  year.getText();
    }


}
