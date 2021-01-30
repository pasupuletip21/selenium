package com.registration.pageobject;

import com.registration.base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends WebDriverBase {

    @FindBy(xpath="//input[@id='vrm-input' and @name='vrm']")
    private WebElement searchtext;
    @FindBy(xpath ="//button[contains(text(),'Free Car Check')]")
    private  WebElement submitbuttion;

    public SearchPage(){

        PageFactory.initElements(driver,this);
    }

    public RegistraionDetailsPage sendRegistraionNum(String number) throws InterruptedException {
        searchtext.sendKeys(number);
        Thread.sleep(5000);
        submitbuttion.click();
        return new RegistraionDetailsPage();
    }
}
