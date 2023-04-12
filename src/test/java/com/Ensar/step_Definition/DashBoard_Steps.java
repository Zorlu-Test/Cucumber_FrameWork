package com.Ensar.step_Definition;

import com.Ensar.utilities.ConfigurationReader;
import com.Ensar.utilities.Driver;
import com.Ensar.utilities.DynamicClick;
import io.cucumber.java.en.Given;

public class DashBoard_Steps {


    @Given("user goes dashboard of page")
    public void user_goes_dashboard_of_page() {

        Driver.get().get(ConfigurationReader.get("baseUrl"));

    }

    @Given("user click on {string}")
    public void user_click_on(String clickOn) throws InterruptedException {
        DynamicClick.clickOnElement(clickOn);
        Thread.sleep(3000);
    }

}
