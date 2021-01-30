package com.regestration.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "target/test-classes"},
        plugin = {
                "pretty", "html:target/MarsRover-Test-Report",
                "json:target/registraion-Test-Report/cucumber.json",
                "rerun:target/registraion-Test-Report/rerun.txt"},
        tags = "@search",
        glue = {"com/registration/stepdefinations/"})
public class RegistraionTestRunner {
}
