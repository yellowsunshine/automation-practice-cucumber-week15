package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(CreateAccountPage.class.getName());

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='radio']")
    WebElement selectTitle;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @CacheLookup
    @FindBy(id = "lastname")
    WebElement addressLastName;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement addressLine1;

    @CacheLookup
    @FindBy(id = "city")
    WebElement addressCity;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement addressState;

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement addressPostcode;

    @CacheLookup
    @FindBy(id = "id_country")
    WebElement addressCountry;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountText;


    public void enterMandatoryInformation(String title,String name, String lstName, String passwrd) {

        if (title == "Mr.") {
            pmClickOnElement(By.xpath("//input[@id='id_gender1']"));
            log.info("Selecting Title " + selectTitle.toString());
        } else if (title == "Mrs.") {
            pmClickOnElement(By.xpath("//input[@id='id_gender1']"));
            log.info("Selecting Title " + selectTitle.toString());
        } else {
            pmClickOnElement(By.xpath("//input[@id='id_gender2']"));
            log.info("Selecting Title " + selectTitle.toString());
        }

        pmSendTextToElement(firstName, name);
        log.info("Entering first name " + firstName.toString());

        pmSendTextToElement(lastName, lstName);
        log.info("Entering Last name  " + lastName.toString());

        pmSendTextToElement(password, passwrd);
        log.info("Entering Password  " + password.toString());

    }

    public void enterAddressDetails(String fName, String lstName,
                                    String address, String city, String state, String postcode, String mobile) {
        pmSendTextToElement(addressFirstName, fName);
        log.info("Entering First Name  " + addressFirstName.toString());

        pmSendTextToElement(addressLastName, lstName);
        log.info("Entering Last Name  " + addressLastName.toString());

        pmSendTextToElement(addressLine1, address);
        log.info("Entering Last Name  " + addressLastName.toString());

        pmSendTextToElement(addressCity, city);
        log.info("Entering city  " + addressCity.toString());

        pmSelectByVisibleTextFromDropDown(addressState, state);
        log.info("Selecting state from dropdown  " + addressState.toString());

        pmSendTextToElement(addressPostcode, postcode);
        log.info("Entering Post code  " + addressPostcode.toString());

        pmSendTextToElement(mobilePhone, mobile);

        log.info("Entering Mobile number  " + mobilePhone.toString());
    }

    public void clickOnRegisterButton() {
        log.info("Clicking on Register button  " + registerButton.toString());
        pmClickOnElement(registerButton);
    }

    public void verifyMyAccountText(String text) {
        log.info("Verifying 'My Account' Text  " + myAccountText.toString());
        doVerifyElementsJU("incorrect text", text, myAccountText.getText());
    }


}
