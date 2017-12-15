package com.epam.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "classpath:features",
        glue="com.epam.bdd.steps"
)
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {}
