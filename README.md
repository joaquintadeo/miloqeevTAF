# Miloqeev Test Automation Framework

![Project Image](https://miro.medium.com/max/550/1*2GicMCBgQTDf7I1hmMoCLQ.jpeg)


---

### Table of Contents

- [Description](#description)
- [How To Use](#how-to-use)
- [References](#references)
- [Author Info](#author-info)

---

## Description

Keyword-Driven BDD Test Automation Framework for both Front-End and Backend-Testing.

#### Technologies

- [Java](https://www.java.com/en/)
- [Selenium WebDriver](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [Cucumber Plugin](https://cucumber.io/)
- [Extent Reports](https://extentreports.com/)
- [Maven](https://maven.apache.org/)

[Back To The Top](#miloqeev-test-automation-framework)

---

## How To Use

#### Installation
1. Clone repository.
2. Open project from desired IDE.
3. Wait for IDE to import all necessary dependencies.


#### User Guide

1. Create feature file for your test inside miloqeev-tests/src/test/resources/features.
2. You will be promted to generate test steps as Java Class, save them inside miloqeev-tests/src/test/java/tests.
3. To set the code for the test steps, import classes and methods from miloqeev-framework/src/main/java.
4. Create test runner file inside miloqeev-tests/src/test/java/tests populating fields:
    - features, indicating location of test feature file.
    - glue indicating location of test file.
    - tags indicating tag of tests to execute.
5. Create test config file inside miloqeev-tests/src/test/java/configFiles specifying runner file under class name.
6. Execute test running config file.
7. Check results in miloqeev-reports/test-results. In case of failure, a screenshot will be attached.

* #####Template files inside every folder for creation assistance. 
    
    
[Back To The Top](#miloqeev-test-automation-framework)

---

## References
[Back To The Top](#miloqeev-test-automation-framework)

---

## License

Copyright (c) [2020] [Joaquin Tadeo]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the right
to use the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[Back To The Top](#miloqeev-test-automation-framework)

---

## Author Info

- Linkedin - [Joaquin Tadeo](https://www.linkedin.com/in/joaqu%C3%ADn-tadeo-43a811166/?locale=en_US)
- GitHub - [Joaquin Tadeo](https://github.com/joaquintadeo)

[Back To The Top](#miloqeev-test-automation-framework)
