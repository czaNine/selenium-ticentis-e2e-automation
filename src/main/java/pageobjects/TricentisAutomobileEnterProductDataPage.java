package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.CheckBox;
import auto.framework.web.ListBox;
import auto.framework.web.Page;
import auto.framework.web.TextBox;
import common.TestDataHandler;

public class TricentisAutomobileEnterProductDataPage extends PageBase {
	public static Page page = new Page("Tricentis Automobile Enter Product Page", "https://sampleapp.tricentis.com/101/app.php");
	
	public static class EnterProductDataPage{
		private static TextBox _textBoxStartDate = new TextBox("Start Date TextBox", By.xpath("//input[@id='startdate']"));
		private static ListBox _listBoxInsuranceSum = new ListBox("Insurance Sum ListBox", By.xpath("//select[@id='insurancesum']"));
		private static ListBox _listBoxMeritRating = new ListBox("Merit Rating ListBox", By.xpath("//select[@id='meritrating']"));
		private static ListBox _listBoxDamageInsurance = new ListBox("Damage Insurance ListBox", By.xpath("//select[@id='damageinsurance']"));
		private static CheckBox _checkBoxLegalDefense = new CheckBox("Legal Defense Insurance CheckBox", By.xpath("//input[@id='LegalDefenseInsurance']/.."));
		private static ListBox _listBoxCourtesyCar = new ListBox("Courtesy Car ListBox", By.xpath("//select[@id='courtesycar']"));
		private static Button _buttonNext = new Button("Next Button", By.xpath("//button[@id='nextselectpriceoption']"));
		
		public static void populateEnterProductDataForm(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Populate Enter Product Data Form");
			_textBoxStartDate.waitForExist(true, 15);
			_textBoxStartDate.type(testDataHandler.startDate);
			_listBoxInsuranceSum.waitForExist(true, 15);
			_listBoxInsuranceSum.selectByVisibleText(testDataHandler.insuranceSum);
			_listBoxMeritRating.waitForExist(true, 15);
			_listBoxMeritRating.selectByVisibleText(testDataHandler.meritRating);
			_listBoxDamageInsurance.waitForExist(true, 15);
			_listBoxDamageInsurance.selectByVisibleText(testDataHandler.damageInsurance);
			_checkBoxLegalDefense.waitForExist(true, 15);
			_checkBoxLegalDefense.click();
			_listBoxCourtesyCar.waitForExist(true, 15);
			_listBoxCourtesyCar.selectByVisibleText(testDataHandler.courtesyCar);
		}
		
		public static void clickNext() {
			ReportLog.setTestStep("Click Next");
			_buttonNext.waitForExist(true, 15);
			_buttonNext.click();
		}
	}
}
