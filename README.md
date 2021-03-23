# automation-Challenge

The task is to write test scenarios and automate one of the positive test scenario for section 1.1

Test scenarios are mentioned in [Test_Scenarios.pdf](https://github.com/anujkumar21/automation-challenge/blob/master/Test_Scenarios.pdf)


## _About Framework:_

Automation framework is implemented in Page Object Model (POM) along with BDD & Object-Oriented Principles which helps
in making the code more readable, maintainable and reusable. Framework is capable to capture screenshots on test failure
and attach it to automation report. Also, framework is maintaining logs for each step.

List of all the software and tools required for developing and executing automation scripts:

1. Java (version 1.8)
2. Selenium/WebDriver (version 3.141.59)
3. Cucumber (version 6.10.1)
4. JUnit (version 4.12)
5. Maven (version 3)
6. Extent Report (version 1.2.0)
7. Log4j (version 2.14.0)
5. Chrome browser (version 89.0.4389.82 or any version of your choice)
6. Chrome drivers (version 89.0.4389.23 or corresponding driver for above chosen browser).
   Download [link](https://chromedriver.chromium.org/downloads)
7. Intellij

## _How to Execute:_

**_Pre-Requisite:_**

1. Framework supports the latest Chrome browser(version 89.0.4389.82) by default. For executing test scripts on any other
   Chrome version, please download and place the browser driver in drivers folder.
2. If you are executing the test scripts on Windows system, please download and place the browser driver in drivers
   folder. Also, please update the file extension in `<chromedriver>` tag in pom.xml file.

**_To execute test scripts please follow below steps:_**

1) Clone project
   > git clone https://github.com/anujkumar21/automation-challenge.git

2) Update `<email-address>` and `<password>` in [login.feature](https://github.com/anujkumar21/automation-challenge/blob/master/src/test/resources/login.feature) file present at `src/test/resources`.

3) Clean and compile project using
   > mvn clean compile

4) To execute automation scripts from command prompt use below command:
   > mvn test

5) To execute automation scripts from MainRunnerTest.java, right click the file and Run 'MainRunnerTest'

6) To execute automation scripts from feature file, add VM option '
   -Dwebdriver.chrome.driver=`<path of your browser driver>`' in Run/Edit Configuration > Templates > Cucumber Java.
   Then, right click on the file and select Run 'Feature: login'

## _Logs & Reports:_

1. Log file generated during test script execution is saved into "./target/logs" folder.
2. Framework has capability to capture screenshot for every failed test scenario.
3. Automation report will get generated as **AutomationReport.html** at "./target/HtmlReport/".

## _Execution Report:_

![AutomationReport](https://github.com/anujkumar21/automation-challenge/blob/master/AutomationReport.png)
