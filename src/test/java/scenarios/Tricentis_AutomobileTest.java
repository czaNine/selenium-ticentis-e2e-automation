package scenarios;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import pageobjects.TricentisAutomobileEnterInsurantDataPage;
import pageobjects.TricentisAutomobileEnterProductDataPage;
import pageobjects.TricentisAutomobileEnterVehicleDataPage;
import pageobjects.TricentisAutomobileSelectPriceOptionPage;
import pageobjects.TricentisAutomobileSendQuotePage;
import pageobjects.TricentisLandingPage;

public class Tricentis_AutomobileTest extends TestBase{
	
	@Test
	public void AutomobileInsuranceQuotationTest() throws Exception{
		// Load the test data from the TestDataHandler for the specific test case (Tricentis_AutomobileInsuranceQuotation)
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Tricentis", "RowSelection='Tricentis_AutomobileInsuranceQuotation'");
		
		// Set the test name and description for reporting purposes
		ReportLog.setTestName("Tricentis - Automobile Insurance Quotation");
		ReportLog.setTestCase("End to end testing for Vehicle Insurance Application");	
		
		// Open the URL and wait for the page to load
		ReportLog.setTestStep("Prerequisite: Navigate to Open URL");
		
		WebControl.open(testDataHandler.url);
		WebControl.waitForPageToLoad(60);
		
		// Validate the landing page and click on the "Automobile" tab
		TricentisLandingPage.LandingPage.validateTricentisTabsDisplay();
		TricentisLandingPage.LandingPage.clickAutomobileTab();
		
		// Navigate to and populate the vehicle data form
		TricentisAutomobileEnterVehicleDataPage.EnterVehicleDataPage.validateAutomobileTabsDisplay();
		TricentisAutomobileEnterVehicleDataPage.EnterVehicleDataPage.populateEnterVehicleDataFields(testDataHandler);
		TricentisAutomobileEnterVehicleDataPage.EnterVehicleDataPage.clickNext();
		
		// Navigate to and populate the insurant data form
		TricentisAutomobileEnterInsurantDataPage.EnterInsurantDataPage.populateEnterInsurantDataForm(testDataHandler);
		TricentisAutomobileEnterInsurantDataPage.EnterInsurantDataPage.clickNext();
		
		// Navigate to and populate the product data form
		TricentisAutomobileEnterProductDataPage.EnterProductDataPage.populateEnterProductDataForm(testDataHandler);
		TricentisAutomobileEnterProductDataPage.EnterProductDataPage.clickNext();
		
		// Navigate to and select the price option
		TricentisAutomobileSelectPriceOptionPage.SelectPriceOptionPage.populateSelectPriceOption();
		TricentisAutomobileSelectPriceOptionPage.SelectPriceOptionPage.clickNext();
		
		
		// Navigate to and populate the send quote form
		TricentisAutomobileSendQuotePage.SendQuotePage.populateSendQuoteForm(testDataHandler);
		TricentisAutomobileSendQuotePage.SendQuotePage.clickSend();
		TricentisAutomobileSendQuotePage.SendQuotePage.validateEmailSuccess();
		TricentisAutomobileSendQuotePage.SendQuotePage.clickOKButton();
	}
}
