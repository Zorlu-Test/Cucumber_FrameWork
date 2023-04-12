package com.Ensar.pages;

import com.Ensar.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public abstract class BasePage {

    Random random = new Random();
    public Actions actions = new Actions(Driver.get());
    public Select select;
    public WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    public Faker faker = new Faker();

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }






}
