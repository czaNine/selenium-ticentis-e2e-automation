package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.CheckBox;
import auto.framework.web.ListBox;
import auto.framework.web.Page;
import auto.framework.web.RadioButton;
import auto.framework.web.TextBox;
import common.TestDataHandler;

public class TricentisAutomobileEnterInsurantDataPage extends PageBase {
	public static Page page = new Page("Tricentis Automobile Enter Insurant Page", "https://sampleapp.tricentis.com/101/app.php");
	
	public static class EnterInsurantDataPage{
		private static TextBox _textBoxFirstName = new TextBox("First Name TextBox", By.xpath("//input[@id='firstname']"));
		private static TextBox _textBoxLastName = new TextBox("Last Name TextBox", By.xpath("//input[@id='lastname']"));
		private static TextBox _textBoxDateOfBirth = new TextBox("Date of Birth TextBox", By.xpath("//input[@id='birthdate']"));
		private static RadioButton _radioButtonGender = new RadioButton("Gender RadioButton", By.xpath("//input[@id='gendermale']/.."));
		private static TextBox _textBoxStreetAddress = new TextBox("Street Address TextBox", By.xpath("//input[@id='streetaddress']"));
		private static ListBox _listBoxCountry = new ListBox("Country ListBox", By.xpath("//select[@id='country']"));
		private static TextBox _textBoxZipCode = new TextBox("Zip Code TextBox", By.xpath("//input[@id='zipcode']"));
		private static TextBox _textBoxCity = new TextBox("City TextBox", By.xpath("//input[@id='city']"));
		private static ListBox _listBoxOccupation = new ListBox("Occupation ListBox", By.xpath("//select[@id='occupation']"));
		private static CheckBox _checkBoxSpeeding = new CheckBox("Speeding CheckBox", By.xpath("//input[@id='speeding']/.."));
		private static CheckBox _checkBoxSkyDiving = new CheckBox("Skydiving CheckBox", By.xpath("//input[@id='skydiving']/.."));
		private static Button _buttonNext = new Button("Next Button", By.xpath("//button[@id='nextenterproductdata']"));
		
		public static void populateEnterInsurantDataForm(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Populate Enter Insurant Data Form");
			_textBoxFirstName.waitForExist(true, 15);
			_textBoxFirstName.type(testDataHandler.firstName);
			_textBoxLastName.waitForExist(true, 15);
			_textBoxLastName.type(testDataHandler.lastName);
			_textBoxDateOfBirth.waitForExist(true, 15);
			_textBoxDateOfBirth.type(testDataHandler.dateOfBirth);
			_radioButtonGender.waitForExist(true, 15);
			_radioButtonGender.click();
			_textBoxStreetAddress.waitForExist(true, 15);
			_textBoxStreetAddress.type(testDataHandler.streetAddress);
			_listBoxCountry.waitForExist(true, 15);
			_listBoxCountry.selectByVisibleText(testDataHandler.country);
			_textBoxZipCode.waitForExist(true, 15);
			_textBoxZipCode.type(testDataHandler.zipCode);
			_textBoxCity.waitForExist(true, 15);;
			_textBoxCity.type(testDataHandler.city);
			_listBoxOccupation.waitForExist(true, 15);
			_listBoxOccupation.selectByVisibleText(testDataHandler.occupation);
			_checkBoxSpeeding.waitForExist(true, 15);
			_checkBoxSpeeding.click();
			_checkBoxSkyDiving.waitForExist(true, 15);
			_checkBoxSkyDiving.click();
		}
		
		public static void clickNext() {
			ReportLog.setTestStep("Click Next");
			_buttonNext.waitForExist(true, 15);
			_buttonNext.click();
		}
	}
}
