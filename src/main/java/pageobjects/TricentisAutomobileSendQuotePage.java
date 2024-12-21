package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.Element;
import auto.framework.web.Page;
import auto.framework.web.TextBox;
import auto.framework.web.WebControl;
import common.TestDataHandler;

public class TricentisAutomobileSendQuotePage extends PageBase {
	public static Page page = new Page("Tricentis Automobile Send Quote Page", "https://sampleapp.tricentis.com/101/app.php");
	
	public static class SendQuotePage{
		private static TextBox _textBoxEmail = new TextBox("Email TextBox", By.xpath("//input[@id='email']"));
		private static TextBox _textBoxUsername = new TextBox("Username TextBox", By.xpath("//input[@id='username']"));
		private static TextBox _textBoxPassword = new TextBox("Password TextBox", By.xpath("//input[@id='password']"));
		private static TextBox _textBoxConfirmPassword = new TextBox("Confirm Password TextBox", By.xpath("//input[@id='confirmpassword']"));
		private static Button _buttonSend = new Button("Send Button", By.xpath("//button[@id='sendemail']"));
		private static Element _elementSendingEmailSuccess = new Element("Sending Email Success Element", By.xpath("//h2[normalize-space()='Sending e-mail success!']"));
		private static Button _buttonOK = new Button("OK Button", By.xpath("//button[normalize-space()='OK']"));
		
		public static void populateSendQuoteForm(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Populate Send Quote Form");
			_textBoxEmail.waitForExist(true, 15);
			_textBoxEmail.type(testDataHandler.email);
			_textBoxUsername.waitForExist(true, 15);
			_textBoxUsername.type(testDataHandler.username);
			_textBoxPassword.waitForExist(true, 15);
			_textBoxPassword.type(testDataHandler.password);
			_textBoxConfirmPassword.waitForExist(true, 15);
			_textBoxConfirmPassword.type(testDataHandler.confirmPassword);
		}
		
		public static void clickSend() {
			ReportLog.setTestStep("Click Send");
			_buttonSend.waitForExist(true, 15);
			_buttonSend.click();
			WebControl.waitForPageToLoad(60);
		}
		
		public static void validateEmailSuccess() {
			ReportLog.setTestStep("Validate Email Success");
			_elementSendingEmailSuccess.waitForExist(true, 15);
			_elementSendingEmailSuccess.assertText("Sending e-mail success!");
		}
		
		public static void clickOKButton() {
			ReportLog.setTestStep("Click OK Button");
			_buttonOK.waitForExist(true, 15);
			_buttonOK.click();
		}
	}
}
