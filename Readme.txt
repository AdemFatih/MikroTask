#Test-automation-Mikro

Mikro project for test automation, Ul and Api testing:

The Ul framework and Api test created using Cucumber BDD in Gherkin language

For assertion in UI and Api, Junit is used.

##Concepts Included

Cucumber BDD testing for UI and Api

Shared state across cucumber step definitions

Dependency injection

Page Object pattern

Common web page interaction methods

Commonly used test utility classes

##Tools;

Maven - Cucumber-JVM - JUnit - Selenium Webdriver - Restassured

##Requirements

In order to utilise this project you need to have the following installed locally:

Maven 2.22.2

Mozilla Firefox (Ul tests use Firefoxby default, can be changed in config)

Java 11 - version 11

Intellu IDEA-version 2021.3.2 Dependencies:

In order to utilise this project you need to have following dependencies in pom.xml

and you can find them https://mvnrepository.com

Selenium-version 3.141.59

Webdrivermanager - version 5.0.3

Cucumber-java - version 5.7.0

Cucumber-junit - version 5.7.0

##Plugins

maven-surefire-plugin- version 2.22.2

maven-cucumber-reporting - version 5.0.0

##Usage

For Api test you should @Api tag and for UI test you should @UI tag in CukesRunner

The project is broken into separate modules for UI.

Each of these modules can be utilised independently of the others using maven profiles. in terminal with command:

mvn test

mvn verify

To run UI tests only, navigate to Challenge1-Ul-runners directory and run:

CukesRunner

Reporting Reports for each module are written into their respective /target directories after a successful run.

Ul acceptance tests result in a HTML report for each feature in MikroTask\target\default-html-reports\index.html

MikroTask\target\cucumber-html-reports overview-failures.html 
In the case of test failures, a screen-shot of the UI at the point of failure is embedded into the report.