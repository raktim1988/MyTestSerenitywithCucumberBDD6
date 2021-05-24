package com.automation.test;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "C:/Users/pnl03b9x/Downloads/Backup/Raktim_Backup/Raktim/Personal/NewJob/Adidas/Addidas/TestAssignment/src/test/resources/features"
)
public class RunnerTest {}
