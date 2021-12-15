package com.automation.steps;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.SignInPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class CreateAccountSteps  {

    @When("^I enter username in the email address field$")
    public void iEnterUsernameInTheEmailAddressField() {
        new SignInPage().enterEmailAddressInCreateAnAccount();
    }


    @And("^I click on the 'Create an account' button$")
    public void iClickOnTheCreateAnAccountButton() {
        new SignInPage().clickOnCreateAnAccountLink();
    }

    @And("^I fill all mandatory fields$")
    public void iFillAllMandatoryFields(DataTable dataTable ) {
        List<List<String>> userList  =  dataTable.asLists(String.class);
        for (List<String> e :userList){
            new CreateAccountPage().enterMandatoryInformation(e.get(0), e.get(1), e.get(2), e.get(3));
        }
    }

    @And("^I enter all address detail fields$")
    public void iEnterAllAddressDetailFields(DataTable dataTable) {
        List<List<String>> userList  =  dataTable.asLists(String.class);
        for (List<String> e :userList){
            new CreateAccountPage().enterAddressDetails(e.get(0), e.get(1), e.get(2), e.get(3), e.get(4), e.get(5), e.get(6));
        }
    }

    @And("^I click on the 'Register' button$")
    public void iClickOnTheRegisterButton() {
        new CreateAccountPage().clickOnRegisterButton();
    }

    @Then("^I verify the 'My account' message \"([^\"]*)\"$")
    public void iVerifyTheMyAccountMessage(String text)  {
        new CreateAccountPage().verifyMyAccountText(text);

    }
}
