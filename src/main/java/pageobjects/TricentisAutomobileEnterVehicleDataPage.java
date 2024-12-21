package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.Element;
import auto.framework.web.Link;
import auto.framework.web.ListBox;
import auto.framework.web.Page;
import auto.framework.web.TextBox;
import common.TestDataHandler;

public class TricentisAutomobileEnterVehicleDataPage extends PageBase {
	public static Page page = new Page("Tricentis Automobile Enter Vehicle Page", "https://sampleapp.tricentis.com/101/app.php");
	
	public static class EnterVehicleDataPage{
		private static Element _elementAutomobileInsurance = new Element("Automobile Insurance Element", By.xpath("//span[@id='selectedinsurance']"));
		private static Link _linkEnterVehicleData = new Link("Enter Vehicle Data Link", By.xpath("//a[@id='entervehicledata']"));
		private static Link _linkEnterInsurantData = new Link("Enter Insurant Data Link", By.xpath("//a[@id='enterinsurantdata']"));
		private static Link _linkEnterProductData = new Link("Enter Product Data Link", By.xpath("//a[@id='enterproductdata']"));
		private static Link _linkSelectPriceOption = new Link("Select Price Option Link", By.xpath("//a[@id='selectpriceoption']"));
		private static Link _linkSelectSendQuote = new Link("Send Quote Link", By.xpath("//a[@id='sendquote']"));
		private static ListBox _listBoxMake = new ListBox("Make ListBox", By.xpath("//select[@id='make']"));
		private static TextBox _textBoxEnginePerformance = new TextBox("Engine Performance TextBox", By.xpath("//input[@id='engineperformance']"));
		private static TextBox _textBoxDateOfManufacture = new TextBox("Date of Manufacture TextBox", By.xpath("//input[@id='dateofmanufacture']"));
		private static ListBox _listBoxNumberOfSeats = new ListBox("Number of Seats ListBox", By.xpath("//select[@id='numberofseats']"));
		private static ListBox _listBoxFuelType = new ListBox("Number of Seats ListBox", By.xpath("//select[@id='fuel']"));
		private static TextBox _textBoxListPrice = new TextBox("List Price TextBox", By.xpath("//input[@id='listprice']"));
		private static TextBox _textBoxLicensePlateNumber = new TextBox("License Plate Number TextBox", By.xpath("//input[@id='licenseplatenumber']"));
		private static TextBox _textBoxAnnualMileage = new TextBox("Annual Mileage TextBox", By.xpath("//input[@id='annualmileage']"));
		private static Button _buttonNext = new Button("Next Button", By.xpath("//button[@id='nextenterinsurantdata']"));
		
		public static void validateAutomobileTabsDisplay() {
			ReportLog.setTestStep("Verify Reference Tabs");
			_elementAutomobileInsurance.waitForExist(true, 15);
			_elementAutomobileInsurance.verifyDisplayed();
			_linkEnterVehicleData.waitForExist(true, 15);
			_linkEnterVehicleData.verifyDisplayed();
			_linkEnterInsurantData.waitForExist(true, 15);
			_linkEnterInsurantData.verifyDisplayed();
			_linkEnterProductData.waitForExist(true, 15);
			_linkEnterProductData.verifyDisplayed();
			_linkSelectPriceOption.waitForExist(true, 15);
			_linkSelectPriceOption.verifyDisplayed();
			_linkSelectSendQuote.waitForExist(true, 15);
			_linkSelectSendQuote.verifyDisplayed();
		}
		
		public static void populateEnterVehicleDataFields(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Populate Enter Vehicle Data Form");
			_listBoxMake.waitForExist(true, 15);
			_listBoxMake.selectByVisibleText(testDataHandler.make);
			_textBoxEnginePerformance.waitForExist(true, 15);
			_textBoxEnginePerformance.type(testDataHandler.enginePerformance);
			_textBoxDateOfManufacture.waitForExist(true, 15);
			_textBoxDateOfManufacture.type(testDataHandler.dateOfManufacture);
			_listBoxNumberOfSeats.waitForExist(true, 15);
			_listBoxNumberOfSeats.selectByVisibleText(testDataHandler.numberOfSeats);
			_listBoxFuelType.waitForExist(true, 15);
			_listBoxFuelType.selectByVisibleText(testDataHandler.fuelType);
			_textBoxListPrice.waitForExist(true, 15);
			_textBoxListPrice.type(testDataHandler.listPrice);
			_textBoxLicensePlateNumber.waitForExist(true, 15);;
			_textBoxLicensePlateNumber.type(testDataHandler.licensePlateNumber);
			_textBoxAnnualMileage.waitForExist(true, 15);
			_textBoxAnnualMileage.type(testDataHandler.annualMileage);
		}
		
		public static void clickNext() {
			ReportLog.setTestStep("Click Next");
			_buttonNext.waitForExist(true, 15);
			_buttonNext.click();
		}
	}
}
