package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.WomenCategoryPage;
import com.sun.org.apache.bcel.internal.generic.NEW;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WomenCategoryPageSteps {

    @Given("^I click on 'WOMEN' tab$")
    public void iClickOnWOMENTab() {
        new HomePage().selectWomen();
    }

    @Then("^I verify \"([^\"]*)\" women page text$")
    public void iVerifyWomenPageText(String message)  {
        new WomenCategoryPage().verifyWomenCategoryPageText(message);
    }

    @When("^I click on the product \"([^\"]*)\"$")
    public void iClickOnTheProduct(String productName) throws InterruptedException {
        new WomenCategoryPage().selectProduct(productName);
    }

    @And("^Change quantity \"([^\"]*)\"$")
    public void changeQuantity(String quantity)  {
        new ProductPage().selectQuantity(quantity);
    }

    @And("^select the size \"([^\"]*)\"$")
    public void selectTheSize(String size)  {
        new ProductPage().selectSize(size);
    }

    @And("^select the colour \"([^\"]*)\"$")
    public void selectTheColour(String colour) {
        new ProductPage().selectColour(colour);
    }

    @And("^click on the 'Add to Cart' button$")
    public void clickOnTheAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @And("^verify the popup message \"([^\"]*)\"$")
    public void verifyThePopupMessage(String expected) throws InterruptedException {
        new ProductPage().verifyPopUpMessage(expected);

    }

    @Then("^Click on the 'X' button and close the popup$")
    public void clickOnTheXButtonAndCloseThePopup() {
        new ProductPage().closeThePopUpMessage();
    }
}
