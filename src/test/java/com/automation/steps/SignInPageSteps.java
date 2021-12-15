package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInPageSteps {
    @Given("^user Clicks On The Sign In Link$")
    public void userClicksOnTheSignInLink() {
        new HomePage().clickOnTheSignInLink();
    }

    @When("^user verifies that \"([^\"]*)\" authentication message is displayed$")
    public void userVerifiesThatAuthenticationMessageIsDisplayed(String message) {
        new SignInPage().verifyTheAuthenticationText(message);
    }

    @When("^user enters username \"([^\"]*)\" in the username field$")
    public void userEntersUsernameInTheUsernameField(String uname) {
        new SignInPage().enterUserNameInTheUserNameField(uname);
    }

    @And("^user enters password \"([^\"]*)\" in the password field$")
    public void userEntersPasswordInThePasswordField(String pw) {
        new SignInPage().enterPasswordInThePasswordField(pw);

    }

    @And("^clicks the sign in Button$")
    public void clicksTheSignInButton() {
        new SignInPage().clickOnTheSignInButton();
    }

    @Then("^verifies the error message \"([^\"]*)\"$")
    public void verifiesTheErrorMessage(String emess) {
        new SignInPage().verifyErrorMessage(emess);
    }

    @Then("^verifies that sign out link is displayed \"([^\"]*)\"$")
    public void verifiesThatSignOutLinkIsDisplayed(String link) {
        new SignInPage().verifyLogOutLink(link);
    }

    @And("^clicks on the sign out link$")
    public void clicksOnTheSignOutLink() {
        new SignInPage().clickOnTheSignOutLink();
    }

    @Then("^verifies that the sign in \"([^\"]*)\" link is displayed$")
    public void verifiesThatTheSignInLinkIsDisplayed(String signIn) {
        new SignInPage().verifyThatSignInLinkIsDisplayed(signIn);
    }

}
