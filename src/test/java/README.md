**EXAM**
=========
    Exam Task:

Open google.com in web browser, search for "Selenium" and verify results on first 2 pages.
### What needs to be done:
1) Create new Maven/Java project
2) Add required libraries to pom.xml (Selenium, TestNG etc)
3) Using best practices of OOP and PageObject/PageFactory patterns automate following scenario
- Navigate to google.com in web browser
- Enter `Selenium` into search field
- Click on "Search" button
- Assert number of Search results is 10 on page 1
- Assert that each result in a list contains searchterm
- Click on "2' link to switch to next page
- Assert number of Search results is 10 on page 2
- Assert that each result in a list contains searchterm
- To prepare TestNG xml that will cover both Chrome and Firefox

4 . In `README.md` file describe following things:
- what's inside your project ( which files, for what etc)
- what needs to be installed in order to run your tests
- how to run your tests via command line

*** 
### Downloading of desired files 
1. [Download Intellij Idea by link](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC) 
2. [Download Java SE Development Kit by link](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html) 
*** 
### Installation of downloaded files 
1. Install `Java SE Development Kit` **use default settings during installation** 
2. Install Intellij Idea **use default settings during installation** 
3. Install Firefox browser 
4. Install Chrome browser
*** 
### Creating new project in Intellij Idea 
1. Launch `Intellij Idea` 
2. Create New project 
3. Select 'Maven' tab from the left panel [Screenshot](http://prntscr.com/j9gbe7) 
4. Select jdk in 'Project SDK' field [Screenshot](http://prntscr.com/j9gdbz) 
5. Click on 'Next' button [Screenshot](http://prntscr.com/j9gdtf) 
6. Type text in 'GroupID' and 'ArtifactID' fields and click 'Next' button [Screenshot](http://prntscr.com/j9ge9x) 
7. Type project name in 'Project Name' and 'Project Location' fields as in 'ArtifactID' field in previous step 
8. Click 'Finish' button [Screenshot](http://prntscr.com/j9ghaz) 
*** 
### Adding Selenium WebDriver 
1. Go to [Maven repository by link](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0) 
2. Copy 'Selenium dependency' [Screenshot](http://prntscr.com/j9gkx8) 
. Open 'pom.xml' file [Screenshot](http://prntscr.com/j9gmd2) 
4. Insert 'copied dependency' [Screenshot](http://prntscr.com/j9gnsu) org.seleniumhq.selenium selenium-java 3.11.0 
5. Add tag above and tag below [Screenshot](http://prntscr.com/j9goy5) 
6. Note that if text between tags has red color - need to wait for a few minutes 
*** 
### Adding geckodriver 
1. Go to [Geckodriver page](https://github.com/mozilla/geckodriver/releases) 
2. [Download geckodriver by link](http://prntscr.com/j9hb0k) 
3. Unpack downloaded ZIP file 
4. Copy 'geckodriver.exe' to 'C:\Windows\System32' 
*** 
### Adding additional panels 
1. Click on 'View' tab in Main menu and click on 'Toolbar' and 'Tool Buttons' points [Screenshot](http://prntscr.com/j9h329) 
2. Check new panels appear from the right [Screenshot](http://prntscr.com/j9h9cm) 
*** 
### Adding new Class 
1. Click right mouse button on 'java' folder in path 'Name of the project > src > main > java' [Screenshot](http://prntscr.com/j9gz63) 
2. Hover mouse on 'New' tab [Screenshot](http://prntscr.com/j9gzfh) 
3. Click on 'Java Class' option [Screenshot](http://prntscr.com/j9gzvj) 
4. Type any name of class in 'Name' field [Screenshot](http://prntscr.com/j9h0eb) 
5. Click on 'Ok' button [Screenshot](http://prntscr.com/j9h15m) 
*** 
### Connecting Firefox browser with opening 'Google' page 
1. Type next strings: WebDriver WebDriver = new FirefoxDriver(); WebDriver.get ("https://www.google.com/"); [Screenshot](http://prntscr.com/j9h6sf) 
2. Note thst if 'WebDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.WebDriver;' appears st the top [Screenshot](http://prntscr.com/j9h88z) 
3. Note thst if 'FirefoxDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.firefox.FirefoxDriver;' appears st the top [Screenshot](http://prntscr.com/j9h8t8) 
*** 

###To perform the task, I use the Test framework.

I create a `Public class` 'GoogleBasic Test' in which I create before and after configurators. 
Annotations `@BeforeMethod`, `@AfterMethod` denote methods that are executed each time before / after execution of the test method - browser parameters, 
URL, default values ​​and the order of actions after running the tests.
I create a `Public class` 'Google SearchTest', in which I use the DataProvider function. 
It allows you to write data-driven tests, which means you can run the same test methods multiple times with different data sets-I use three variants of a data set. 

Next, I declare the creation of pages, their name, data type. 
I declare the check of the pages loading, the presence of necessary fields for data input, the display of the search results, their correspondence to the number (10), and the content in each of the 10 items of the search element. 
I go to the second page of the search and also check the availability of 10 items and the content in each search item. 

To check I use a special design Assert.
Next, I create pages based on the generated tests
`GoogleBasePage`, `GoogleStartSearchPage`, `GoogleSearchResultsPage`, `GoogleSearchResults2Page`,
in which the internal mechanism of testing is described. 
For writing, I use the `Page Object` template, the `Page Factory` class, Java Script.

### How to run your tests via command line

- Open the command line
- Write the following commands and start execution

***mvn clean install***

***To run all tests***

- To run only one test, add ***-Dtest = [class name]*** to the maven command line.