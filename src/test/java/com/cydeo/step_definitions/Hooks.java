package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //In this class,  WE CAN PASS  pre- & post-  CONDITIONS to each scenario and each step  !!!

    @Before (order = 1)    // import from io.cucumber.java
    public void setupScenario(){
        System.out.println("======Setting up browser using cucumber @Before");
    }

    @Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){
        System.out.println("======this will only apply to scenarios with @login tag");
    }

    @Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        System.out.println("======this will only apply to scenarios with @db tag");
    }


    @After  // !!! executes after each scenario
    public void teardownScenario(Scenario scenario){

        //if scenario fails the method will return TRUE and take a screenshot.
        if(scenario.isFailed()){
            byte [] screenshot= ((TakesScreenshot)Driver.getDriver()) .getScreenshotAs(OutputType.BYTES);  // we used downcasting
            scenario.attach(screenshot, "image/png", scenario.getName());
        }




        Driver.closeDriver();
        //System.out.println("=====Closing browser using cucumber @After");
        //System.out.println("=====Scenario ended/ Take screenshot if failed");

    }

    @BeforeStep  // executes before each STEPS in the scenario
    public void setupStep(){
        System.out.println("------------>applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("-------------->applying tearDown using @AfterStep");
    }


    // BEFORE HOOKS WILL RUN BEFORE BACKGROUNDS






}
