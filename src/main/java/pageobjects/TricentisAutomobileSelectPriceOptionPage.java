package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.Page;
import auto.framework.web.RadioButton;
import auto.framework.web.WebControl;

public class TricentisAutomobileSelectPriceOptionPage extends PageBase {
	public static Page page = new Page("Tricentis Automobile Select Price Option Page", "https://sampleapp.tricentis.com/101/app.php");
	
	public static class SelectPriceOptionPage{
		private static RadioButton _radioButtonUltimate = new RadioButton("Ultimate RadioButton", By.xpath("//input[@id='selectultimate']/.."));
		private static Button _buttonNext = new Button("Next Button", By.xpath("//button[@id='nextsendquote']"));
		
		public static void populateSelectPriceOption() {
			ReportLog.setTestStep("Populate Select Price Option");
			_radioButtonUltimate.waitForExist(true, 15);
			_radioButtonUltimate.click();
			WebControl.waitForPageToLoad(60);
		}
		
		public static void clickNext() {
			ReportLog.setTestStep("Click Next");
			_buttonNext.waitForExist(true, 15);
			_buttonNext.click();
		}
	}
}
