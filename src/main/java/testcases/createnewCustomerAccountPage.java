package testcases;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class createnewCustomerAccountPage {
	
	private final Page page ;
	private final Locator newCustomerlink ;
	private final Locator firstNameInputField ;
	
	public createnewCustomerAccountPage(Page page) {
		this.page = page;
		this.newCustomerlink = page.locator("//a[text()='Create an Account']/@href");
		this.firstNameInputField = page.locator("//input[@id='firstname']");
		
	}
	public void navigate() {
		page.navigate("https://magento.softwaretestingboard.com/");
	}
	public void newCustomerURL() {
		newCustomerlink.click();
	}
	public void firstName(String textField) {
		firstNameInputField.fill(textField);
		firstNameInputField.press("Enter");
	}

}