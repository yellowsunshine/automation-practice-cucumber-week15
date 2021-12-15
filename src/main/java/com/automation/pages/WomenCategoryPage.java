package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenCategoryPage extends Utility {

    private static final Logger log = LogManager.getLogger(WomenCategoryPage.class.getName());

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenText;

    @CacheLookup
    @FindBy()
    WebElement topsAndDresses;

    @CacheLookup
    @FindBy()
    WebElement sortByDropDown;

    @CacheLookup
    @FindBy(xpath = "//a[@class='product-name']")
    List<WebElement> productList;

    public void verifyWomenCategoryPageText(String text){
        doVerifyElementsJU("Incorrect page", text, womenText.getText());
        log.info("verifying womens page text : " + text);

    }

    public void selectProduct(String menu) throws InterruptedException {
        List<WebElement> names = productList;
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                log.info("selecting product : " + menu);
                break;
            }
        }

    }





}
