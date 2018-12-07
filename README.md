## Test automation task - Dmitry Speransky

- [Technology overview](#1-technology-overview)
- [Running tests](#2-how-to-run-tests)
- [Results and reports](#3-results-and-reports)

### 1. Technology overview

Test automation project follows most modern approach to framework design and is based on the following tools/concepts:
- `Selenium` (most feature-rich, stable and fast browser driver)
- `Java 8` 
- `Cucumber for Java 8` (with dependency injection)
- `Multi-layered` test framework structure
- `PageObject` pattern
- `Maven profiles`

Cucumber is the industry standard for designing BDD-based frameworks and allows the code of tests to be easily-readable, 
maintainable and expandable. Cucumber scenarios are also the best when it comes to understanding of how functionality works and tested.
 
Cucumber is also an extremely potent and flexible tool when used just as a test framework and allows to achieve the following:
- Easy `grouping` of scenarios into `sets` (with combinations of Cucumber `tags`)
- Execution of global `setUp/tearDown` code as well as `fine-tuned before/after` scenario code for the specific scenarios
- `State (context) sharing` between steps (with `dependency injection`)
- Powerful built-in reporting capabilities  

### 2. How to run tests
#### Pre-conditions
- Make sure that `JDK 8+` is installed (I use Oracle JDK 8 on macOS)
- Make sure that Maven is installed (if not run `brew install maven` on macOS or download the archive from Apache)
- `Chrome` and/or `Firefox` are installed

**IMPORTANT** This solution supports running tests against `Chrome` and `Firefox` on `macOS` and `Linux` and 
`automatically` selects necessary driver - you don't need to download `chromedriver` or `geckodriver`.

#### CLI commands

- to run web tests against the `default` browser(`Chrome` in `normal/GUI` mode):
```sh
    mvn test
```    

- OR to run web tests against the `default` browser(`Chrome` in `normal/GUI` mode) and generate Maven site report:
```sh
    mvn test site
```   

- to run web tests against the `Chrome` browser in `normal/GUI` mode :
```sh
    mvn clean test -P chrome
``` 

- to run web tests against the `Chrome` browser in `headless` mode :
```sh
    mvn clean test -P chrome_headless
``` 

- to run web tests against the `Firefox` browser in `normal/GUI` mode :
```sh
    mvn clean test -P firefox
``` 

- to run web tests against the `Firefox` browser in `headless` mode :
```sh
    mvn clean test -P firefox_headless
``` 

**NOTE** - in order to generate `Maven site HTML report` please add `site` goal to the command (after `test` goal and
before `-P` parameter).


**IMPORTANT** - *Due to the lack of time cross-browser testing was only performed on `macOS` (not on `Linux`) - 
tests passed in all browser configurations*

### 3. Results and reports

`During` the test execution a detailed information about the current Cucumber scenarios will be displayed in the console.

`After` each test run the following `reports` will be generated
1) `Cucumber XML`(JUnit), `Cucumber JSON` and `Cucumber HTML` reports can be found in **target/reports** folder
(`Cucumber HTML` report contains embedded `screenshots` of the page in case if there were failures).
2) `Maven Surefire HTML` report can be found in **target/site** folder (requires `site` goal to be specified).
3) `Maven Surefire XML` and `TXT` reports can be found in **target/surefire-reports** folder
