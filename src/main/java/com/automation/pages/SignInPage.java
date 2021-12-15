package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {

    private static final Logger log = LogManager.getLogger(SignInPage.class.getName());

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createAccountEmailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;


    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signInButton;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    WebElement signInAccount;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInLink;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOut;

    @CacheLookup
    @FindBy(xpath = "(//span[normalize-space()='Create an account'])[1]")
    WebElement createAnAccountButton;

    @CacheLookup
    @FindBy(css = ".page-heading")
    WebElement authenticationText;

    @CacheLookup
    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement createAnAccountText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger']//ol")
    WebElement errorMessage;

    public void verifyTheAuthenticationText(String message){
        waitForElementWithFluentWait(By.cssSelector(".page-heading"), 30, 5);
        doVerifyElementsJU("Authentication message incorrect", message, authenticationText.getText());
        log.info("verify the authentication message : " + authenticationText);
    }

    public void enterUserNameInTheUserNameField(String username){
        pmSendTextToElement(emailAddress, username);
        log.info("enter user name : " + username);
    }

    public void enterPasswordInThePasswordField(String passWord) {
        pmSendTextToElement(password, passWord);
        log.info("enter user name : " + passWord);
    }

    public void clickOnTheSignInButton()  {
        pmClickOnElement(signInButton);
        log.info("click on the sign in button : " + signInButton.getText());
    }

    public void verifyErrorMessage(String eMessage) {
        doVerifyElementsJU("Message displayed incorrectly", eMessage, errorMessage.getText());
        log.info("verify the error message : " + eMessage);
    }

    public void verifyLogOutLink(String linkMessage) {
        doVerifyElementsJU("Logout link displayed incorrectly", linkMessage, signOut.getText() );
        log.info("verify the log out link : " + signOut.getText());
    }

    public void clickOnTheSignOutLink(){
        pmClickOnElement(signOut);
        log.info("click on the sign out link : " + signOut.getText());
    }

    public void verifyThatSignInLinkIsDisplayed(String signIn){
        doVerifyElementsJU("Link is displayed incorrectly", signIn, signInLink.getText());
        log.info("Verifying sign in link : " + signInLink.getText());
    }

    public void enterEmailAddressInCreateAnAccount(){
        pmSendTextToElement(createAccountEmailAddress, randomString()+"@gmail.com");
        log.info("enter email : ");
    }

    public void clickOnCreateAnAccountLink(){
        pmClickOnElement(createAnAccountButton);
        log.info("click on the create an account link : " + createAnAccountButton.getText());
    }
}
