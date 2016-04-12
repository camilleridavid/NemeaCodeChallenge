# Nemea Code Challenge [![Build Status](http://40.85.141.124:8080/buildStatus/icon?job=Nemea%20Run%20Unit%20Tests)](http://40.85.141.124:8080/view/Nemea/job/Nemea%20Run%20Unit%20Tests/)

### Git repository

https://github.com/camilleridavid/NemeaCodeChallenge    

### Java

SDK 1.8 

### Config

1. Website URLs can be found in the URL.xml properties file in the test resources folder.
2. Tests are executed on Firefox.
3. Upon a Cucumber test failing, the time of failure and a screenshot of the browser at the time of failure are embedded in the Cucumber HTML report for debugging purposes.

### Running tests locally

*IntelliJ - Create Maven 'Run Configurations':*

1. Cucumber System Tests
    * Command line: `clean test "-Dcucumber.options=--tags @nemea"`
2. Unit Tests
    * Command line: `-Dtest=*Tests package`
3. Javadoc
    * Command line: `javadoc:test-javadoc`
    
*Terminal:*

cd \<project root path\>

1. Cucumber System Tests
    * `mvn clean test "-Dcucumber.options=--tags @nemea"`
2. Unit Tests
    * `mvn -Dtest=*Tests package`
3. Javadoc
    * `mvn javadoc:test-javadoc`
    
### Jenkins

http://40.85.141.124:8080/view/Nemea/  
Username: nemea  
Password: nemea   
  
*Builds:*

1. **Nemea Publish Javadoc**
    * Polls Git every 15 minutes and initialises the job if there were any changes in the codebase.  
    * It simply builds the code and then generates the Javadoc.
    * To view the Javadoc, click on the Javadoc link at the top of the job page.

2. **Nemea Run System Tests**
    * Job is set to run periodically every hour on all days.
    * It builds the code and initialises the Cucumber tests.
    * Test results are shown in 3 distinct reports:
        * *Test Result Trend* is shown in the job page, with more details in the *Latest Test Result* link;
        * HTML report created by Cucumber, that can be accessed from the *Latest Cucumber Report* link in the job page;
        * HTML report created by a Jenkins Cucumber plugin, that can be accessed from the *Cucumber Reports* link in the job page.

3. **Nemea Run Unit Tests**
    * Polls Git every 15 minutes and initialises the job if there were any changes in the codebase.  
    * It builds the code and then runs the unit tests for the `Line` class.
    * *Test Result Trend* is shown in the job page, with more details in the *Latest Test Result* link.
    * Code coverage is included in unit test runs and is shown in:
        * the *Line Coverage* column in the *Nemea* view;
        * the *Code Coverage Trend* in the job page.