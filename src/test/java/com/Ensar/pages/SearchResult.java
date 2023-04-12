package com.Ensar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Overnight Duffle')]")
    public WebElement overnightDuffle;


}
