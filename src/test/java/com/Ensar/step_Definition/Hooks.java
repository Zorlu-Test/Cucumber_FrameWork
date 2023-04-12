package com.Ensar.step_Definition;


import com.Ensar.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {


    @After
    public void tearDown() {
        Driver.closeDriver();
    }


}
