package com.Ensar.step_Definition;

import com.Ensar.pages.Pages;
import com.Ensar.utilities.ConfigurationReader;
import com.Ensar.utilities.Driver;
import com.Ensar.utilities.DynamicClick;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Add_Item_To_Basket extends Pages {

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        Driver.get().get(ConfigurationReader.get("baseUrl"));
    }

    @When("the user searches for an item with the SKU code {string}")
    public void theUserSearchesForAnItemWithTheSKUCode(String code) {
        dashBoard().search.sendKeys(code, Keys.ENTER);
    }

    @And("the user clicks  on the item {string}")
    public void theUserClicksIsOnTheItem(String item){
        DynamicClick.clickOnElement(item);
    }

    @And("the user clicks on {string} button")
    public void theUserClickOnButton(String clickOn){
        DynamicClick.clickOnElement(clickOn);
    }

    @When("the user clicks on  {string} button")
    public void theUserClicksOnButton(String basket) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a/span[@class='counter qty']")));
        DynamicClick.clickOnElement(basket);
    }


    @Then("the user verifies that the {string} item is present in the basket.")
    public void theUserVerifiesThatTheItemIsPresentInTheBasket(String expectedItem){
        String addedItem = dashBoard().addedItems.get(0).getText();
        Assert.assertEquals("Item names does not match", addedItem, expectedItem);
    }

    /**
     * without dynamic click method steps.
     */
    @And("the user clicks  on the item Overnight Duffle")
    public void theUserClicksOnTheItemOvernightDuffle() {
        searchResult().overnightDuffle.click();
    }


    @When("the user clicks on Add to Cart button")
    public void theUserClicksOnAddToCartButton() {
        productPage().addToCart.click();
    }

    @And("the user clicks on basket button")
    public void theUserClicksOnBasketButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a/span[@class='counter qty']")));
        productPage().basket.click();

    }


}
