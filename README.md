# Selenium Maven TestNG Web Testing Framework
## Description

* Selenium Wedriver framework implemented using Java, Maven and TestNG. The framework implements the Page Object Pattern and data driven approach.
* The framework is implemented in IDE IntelliJ Idea.
* Test data is read from the Excel workbook and configuration properties from the config.properties file.
* The tests can be run in Firefox, Chrome and Microsoft Edge browser.
* Learn about Page Object Pattern at https://github.com/SeleniumHQ/selenium/wiki/PageObjects   

## Test Application

Application Under Test is https://itarvato.ee/

## Prerequisites

*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher
*   Maven must be installed and environment variable M2_HOME/MAVEN_HOME should be available in classpath
*	Please refer for any help in Maven. 
* 	http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* 	http://www.tutorialspoint.com/maven/maven_environment_setup.htm

## Getting Started

1. Webdriver available in repository is with respect to Windows 10, 64 bit O.S, So you may have to download compatible webdrivers for firefox,chrome and edge
2. Copy the webdriver in src/main/resources/drivers
3. Install and setup M2_HOME, MAVEN_HOME environment variable.
4. Clone the repository or download
5. Use the *.xml file available in the root directory to start test execution by passing running the following command
6. mvn clean test -DtestngFile <file_name_path>
7. If you want to change select the browser, change browser value in config.properties file src/main/java/com/company/app/config/config.properties

## Test Data
1. Change the form test data required for the test in xls file located at  src/main/java/com/company/app/testdata/contactdata.xlsx
2. Captured screen shot for test failure can be found in screen-shots directory which is created after running the test.

## Steps to execute on windows command line using Maven
1. Ensure all prerequisites are met and M2_HOME is set
2. Go to project root folder using Windows command line
3. mvn clean test -DtestngFile testng_1.xml

### Run following commands as it is from git bash terminal
1. git clone 
2. echo $M2_HOME
3. mvn clean test -DtestngFile=testng_1.xml   or mvn clean test -DtestngFile=testng_e2e.xml

## Test Stability and Environment Details
Framework and Web test ran successfully through both IDE intelliJ IDEA and MVN command line on below given System   
1. O.S: Windows 10 , Version: 10.0.17134
2. Chrome Browser Version 70.0.3538.102 (Official Build) (64-bit) 

## Can be tested on following version of browser
1. FireFox 63.0.3 (64-bit)
2. Microsoft Edge 42.17134.1.0


## Location of test report
1. After running the test through command line, you can find extent-report/testng-report at  <project_dir>/target/surefire-reports
2. Take a look at index.html, Extent.html and emailable-report.html

## Contact information
1. For queries contact author Navedanjum Ansari    
                              navedanjum.ansari@gmail.com/ansari@ut.ee/naansa@ttu.ee
							  website: xpressionworks.com