package com.n11.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "com/n11/step_definitions",
        dryRun =false,
        tags = "@wip"

)
public class CukesRunner {
}