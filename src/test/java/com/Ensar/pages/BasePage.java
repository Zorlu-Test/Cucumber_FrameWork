package com.Ensar.pages;

import com.Ensar.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "search")
    public WebElement search;
    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement basket;

    @FindBy(id = "top-cart-btn-checkout")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@class='logo']")
    public WebElement luma; //Icon
    @FindBy(xpath = "//div[@data-action='scroll']//strong/a")
    public List<WebElement> addedItems;

    @FindBy(xpath = "//div/a/span[@class='counter qty']")
    public WebElement counterQty;


}
