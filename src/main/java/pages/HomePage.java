package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testcases.HomePageTestcase01;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BasePage;

public class HomePage extends HomePageTestcase01 {
	
	private Page page;
	private Locator CreateAccountButton, CreateAccountLink;
	
	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	
	public HomePage(Page page) {
		super();
		this.page = page;
		this.CreateAccountLink = page.locator("Create an Account");
	}
	
	public void clickAccountLinkPage() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
		log.info("The browser has launched The Create New Customer Account Page ");
	}
	
}
