package com.Ensar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[@title='Add to Cart']")
    public WebElement addToCart;


}
