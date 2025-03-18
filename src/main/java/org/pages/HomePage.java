package org.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.base.BaseClass;
import org.testcases.PlaywrightFactory;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BaseClass {
	
	private static Page page;
	private Locator CreateAccountButton, CreateAccountLink;
	
	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	
	public HomePage(Page page) {
		this.page = page;
		this.CreateAccountLink = page.locator("Create an Account");
	}
	public String getHomePageTitle() {
        String pageTitle = page.title();
		System.out.println("Title of the page: " + pageTitle);
		return pageTitle;
		
	}
	public String getHomePageURL() {
		String pageURL = page.url();
		System.out.println("URL of the page: " + pageURL);
		return pageURL;
	}
	
	public void clickAccountLinkPage() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
		log.info("The browser has launched The Create New Customer Account Page ");
	}
	
}
