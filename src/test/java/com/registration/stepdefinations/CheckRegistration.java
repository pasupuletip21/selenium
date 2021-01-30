package com.registration.stepdefinations;

import com.registration.base.WebDriverBase;
import com.registration.pageobject.RegistraionDetailsPage;
import com.registration.pageobject.SearchPage;
import com.registration.util.ReadInputFile;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import cucumber.api.java.Before;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckRegistration extends WebDriverBase {
    SearchPage searchpage;
    List<String> regNumber;
    Map<String, List<String>> listMap = new HashMap<String, List<String>>();

    RegistraionDetailsPage registriondetails;
   public String regcarnum=null;
//   public String  carmark=null;
//   public String  carmodel=null;
//  public  String  carcolour=null;
//   public String  caryear=null;
  public String tempReg=null;
public CheckRegistration(){
    super();
}
@Before
public void setup(){
    WebDriverBase.initialBrowser();
}
    @Given("get the car registraion number from the input file")
    public void getTheCarRegistraionNumberFromTheInputFile() throws IOException {

        regNumber= ReadInputFile.getRegNum();
    }
    @When("search the registrion number using  input number")
    public void search_the_registrion_number_using_input_number() throws InterruptedException {
         searchpage=new SearchPage();
       //  for(String inputNum:regNumber) {
             tempReg = regNumber.get(1);
             System.out.println("registarion number" + tempReg);

             List<String> list = new ArrayList<String>();
             registriondetails = searchpage.sendRegistraionNum(regNumber.get(1));
             list.add(registriondetails.getRegistrionNumber());
             list.add(registriondetails.getMake());
             list.add(registriondetails.getModel());
             list.add(registriondetails.getColour());
             list.add(registriondetails.getYear());
             listMap.put(regcarnum, list);

        // }
    }

@Then("get the  registraion details  using number")
    public void get_the_registraion_details_using_number() throws InterruptedException {

}


    @Then("veriry the details correct or not")
    public void veriry_the_details_correct_or_not() throws IOException {
        List<String> outputfile=ReadInputFile.resOutput();
        String expectedRec = null;
        for (String record : outputfile) {
            if (record.contains(tempReg)) {
                expectedRec = record;
            }
        }
        String[] exp = expectedRec.split(",");
        List<String>expectedList=new ArrayList<String>();
        expectedList.add(exp[0]);
        expectedList.add(exp[1]);
        expectedList.add(exp[2]);
        expectedList.add(exp[3]);
        expectedList.add(exp[4]);

      List<String> carDetails= listMap.get(regcarnum);
System.out.println("carDetails "+carDetails.get(0));

        Assert.assertEquals(expectedList, carDetails);
//        Assert.assertEquals(exp[1], carDetails.get(1));
//        Assert.assertEquals(exp[2], carDetails.get(2));
//        Assert.assertEquals(exp[3], carDetails.get(3));
//        Assert.assertEquals(exp[4], carDetails.get(4));
    }
@After
    public void tearDown(){
    WebDriverBase.close();
}

}
