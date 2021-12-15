package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "(//a[@title='Women'])[1]")
    WebElement women;

    @CacheLookup
    @FindBy()
    WebElement dresses;

    @CacheLookup
    @FindBy()
    WebElement tshirts;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']")
    WebElement menu;


    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement signInLink;

    @CacheLookup
    @FindBy()
    WebElement logo;

    public void clickOnTheSignInLink(){
        pmClickOnElement(signInLink);
        log.info("clicking on sign in link : " + signInLink.getText());
    }

    public void selectWomen()  {
        pmClickOnElement(women);
        log.info("clicking on women tab : " + women.toString());
    }



}
