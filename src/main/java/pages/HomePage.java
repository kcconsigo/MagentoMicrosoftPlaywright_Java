package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import base.BasePage;

public class HomePage extends BasePage {
	
	public Page page;
	public Locator CreateAccountButton, CreateAccountLink;
	
	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	
	public HomePage(Page page) {
		super(page);
		this.page = page;
		this.CreateAccountLink = page.locator("Create an Account");
	}
	
	public void clickAccountLinkPage() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
		page.locator("Create an Account").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(60000));
		log.info("The browser has launched The Create New Customer Account Page ");
	}
	
}
