package com.sample.www;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.TestBase;

public class GoogleSearch extends TestBase {
	static int pageTwoNumberOfResults;
	static int pageThreeNumberOfResults;

	
	@Test(priority  =1)
    public void VerifyGoogleOpened() {

        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Google homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Omar");
        logger.info("Verify URL");

        openURL(properties.getProperty("URL"));
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {

            test.log(Status.INFO, "Verification Successful - The correct title is displayed on the web page.");
            logger.info("Verification Successful - The correct title is displayed on the web page.");

        } 
        else {
            test.log(Status.FAIL, "Verification Failed - An incorrect title is displayed on the web page.");
            logger.error("Verification Failed - An incorrect title is displayed on the web page.");
        }
        
    }
	
	
	@Test(priority  =2)
	public void VerifyVodafoneSearch() {

        test = extent.createTest("Verify Vodafone Search", "Case 2: User needs to verify if Search gone as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Omar");
        logger.info("Verify Search");
        
        webdriver.enterText(MainPage.txtSearchBox, "Vodafone");   
        test.log(Status.INFO, "Entering Vodafone in search box.");
        logger.info("Entering Vodafone in the search box.");
        
        
        webdriver.waitForElementToBeClickable(MainPage.btnSearch1);
        webdriver.clickOnButton(MainPage.btnSearch1);
        test.log(Status.INFO, "Click on search button with entering any details.");
        logger.info("Click on search button with entering any details.");
        
        

       
    }
	
	@Test(priority  =3)
	public void VerifyScrollDownPageTwo() throws InterruptedException {

        test = extent.createTest("Verify Scrolling 2", "Case 4: User needs to verify if Scrolling gone as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Omar");
        logger.info("Verify Scrolling 2");
        
       

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);

        webdriver.waitForElementVisible(SearchPage.navigationNumbers);
        
        
        
        
        webdriver.waitForElementVisible(SearchPage.pageTwoBtn);
        webdriver.waitForElementToBeClickable(SearchPage.pageTwoBtn);
        webdriver.clickOnButton(SearchPage.pageTwoBtn);
        test.log(Status.INFO, "Click on Page Two Button ");
        logger.info("Click on Page Two Button with");
        
        
        pageTwoNumberOfResults = driver.findElements(SearchPage.searchRes).size();
        System.out.println("Number of results in page 2 " + pageTwoNumberOfResults);
        
        
        

        
        
    }
	
	
	@Test(priority  =4)
	public void VerifyScrollDownPagThree() throws InterruptedException {

        test = extent.createTest("Verify Scrolling 3", "Case 5: User needs to verify if Scrolling in page 3 gone as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Omar");
        logger.info("Verify Scrolling 3");
        
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        webdriver.waitForElementVisible(SearchPage.navigationNumbers);
        
        
        webdriver.waitForElementVisible(SearchPage.pageThreeBtn);
        webdriver.waitForElementToBeClickable(SearchPage.pageThreeBtn);
        webdriver.clickOnButton(SearchPage.pageThreeBtn);
        test.log(Status.INFO, "Click on Page Three Button ");
        logger.info("Click on Page Three Button");
        
        pageThreeNumberOfResults = driver.findElements(SearchPage.searchRes).size();

        
        System.out.println("Number of results in page 3 " + pageThreeNumberOfResults);


    }
	
	
	@Test(priority  =5)

	public void VerifyNumberOfSearchResults() throws InterruptedException {
		
        test = extent.createTest("Number of search results", "Case 5: User needs to verify if number of results is the same in page 2 and 3.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Omar");
        logger.info("Number of search results");


	if (pageThreeNumberOfResults==pageTwoNumberOfResults) {

        test.log(Status.INFO, "Number of results is the same");
        logger.info("Number of results is the same.");

    } 
    else {
        test.log(Status.FAIL, "Number of results is different");
        logger.error("Number of results is different");
    }
	
	}
    
	

}
