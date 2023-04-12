package com.Ensar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Women extends BasePage{


    @FindBy(xpath = "(//*[text()='Tops'])[3]")
    public WebElement tops;

    @FindBy(xpath = "(//div[@class='product-item-info'])[1]")
    public WebElement firstItem;

}
