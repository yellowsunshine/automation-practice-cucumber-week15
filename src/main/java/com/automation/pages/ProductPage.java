package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//select[@id='group_1']")
    WebElement sizeDropDown;

    @FindBy(css = "div[class='layer_cart_product col-xs-12 col-md-6'] h2")
    WebElement popUpMessageTextLink;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement popUpCloseButtonLink;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    public void selectQuantity(String qty){
        pmFindElementAndClearText(quantity);
        pmSendTextToElement(quantity, qty);
        log.info("select quantity : " + qty.toString());
    }

    public void selectSize(String size){
        pmSelectByVisibleTextFromDropDown(sizeDropDown, size);
        log.info("select size : " + size);
    }

    public void selectColour(String col){
        if(col=="White"){
            driver.findElement(By.id("color_8")).click();
            log.info("select col : " + col);}
        else if (col == "Orange"){
            driver.findElement(By.id("color_13")).click();
            log.info("select col : " + col);}
        else if (col == "Green"){
            driver.findElement(By.id("color_15")).click();
            log.info("select col : " + col);}
        else if (col == "Blue"){
            driver.findElement(By.id("color_14")).click();
            log.info("select col : " + col);}
        else {
            System.out.println("Please select a colour");
        }
    }

    public void clickOnAddToCartButton(){
        pmClickOnElement(addToCartButton);
        log.info("click on add to cart button : " + addToCartButton.toString());
    }


    public void verifyPopUpMessage(String expmess) throws InterruptedException {
        String actual = popUpMessageTextLink.getText();
        Thread.sleep(5000);
        doVerifyElementsJU("Page is not correctly displayed", expmess,actual);
        Thread.sleep(3500);
        log.info("Verifying the popup Message :" + popUpMessageTextLink.toString());
    }

    public void closeThePopUpMessage() {
        pmClickOnElement(popUpCloseButtonLink);
        log.info("Closing the popup message :" + popUpCloseButtonLink.toString());
    }


}
