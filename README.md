
## ⚙️Setup

*  Install Git
*  Install IntelliJ (or another IDE)
*  Install JDK
*  Install Maven


### Import the Project

1. Create a directory on your machine.

2. Clone this repository into said directory.
    ```
    $ git clone https://github.com/Deepak-Kumar-DK/Sauce-Labs-Demo.git
    ```

3. Import the project into your IntelliJ (or IDE of your choice) as a **Maven Project**.

4. Click through the prompts, and confirm when it asks to **Import from Sources**

5. Choose the **framework** directory as the **root** directory of the project.


### Run a Maven Test

1. Run the following command to update any package dependencies:
    ```
    $ mvn dependency:resolve
    ```
2. Then run the following command to compile your test code:
    ```
    $ mvn test-compile
    ```


### Run the Cucumber Test

* Run as JUnit

  1. Now we can run the test.
  2. Right Click on TestRunner class (src/test/java/runners/TestRunner.java)
  3. Click Run As > JUnit Test.
  4. Cucumber will run the script the same way it runs in Selenium WebDriver.
  5. The result will be shown in the project explorer window in JUnit tab.
  6. Report will be generated after Run completed under folder (target/cucumber-reports/cucumber-report.html)
  7. Open the report in web browser to view the report of Test run.