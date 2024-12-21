package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Link;
import auto.framework.web.Page;
import auto.framework.web.WebControl;

public class TricentisLandingPage extends PageBase {
	public static Page page = new Page("Tricentis Landing Page", "https://sampleapp.tricentis.com/101/");
	
	public static class LandingPage{
		// Locators for the navigation links
		private static Link _linkAutomobile = new Link("Automobile Link", By.xpath("//div[@class='main-navigation']//a[@id='nav_automobile']"));
		private static Link _linkTruck = new Link("Truck Link", By.xpath("//div[@class='main-navigation']//a[@id='nav_truck']"));
		private static Link _linkMotorcycle = new Link("Motorcycle Link", By.xpath("//div[@class='main-navigation']//a[@id='nav_motorcycle']"));
		private static Link _linkCamper = new Link("Camper Link", By.xpath("//div[@class='main-navigation']//a[@id='nav_camper']"));
		
		// Method to validate the visibility of the navigation tabs (Automobile, Truck, Motorcycle, Camper)
		public static void validateTricentisTabsDisplay() {
			ReportLog.setTestStep("Validate Reference Tabs");
			_linkAutomobile.waitForExist(true, 15);
			_linkAutomobile.verifyDisplayed();
			_linkTruck.waitForExist(true, 15);
			_linkTruck.verifyDisplayed();
			_linkMotorcycle.waitForExist(true, 15);
			_linkMotorcycle.verifyDisplayed();
			_linkCamper.waitForExist(true, 15);
			_linkCamper.verifyDisplayed();
		}
		
		// Method to click on the "Automobile" tab and navigate to the automobile insurance section
		public static void clickAutomobileTab() {
			ReportLog.setTestStep("Click Automobile Tab");
			_linkAutomobile.waitForExist(true, 15);
			_linkAutomobile.click();
			WebControl.waitForPageToLoad(60);
		}
		
	}
}
