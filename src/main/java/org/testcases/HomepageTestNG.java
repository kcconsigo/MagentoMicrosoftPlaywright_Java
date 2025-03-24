package org.testcases;

import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import pages.HomePage;

public class HomepageTestNG {
	
	static Playwright playwright = null;
	static Browser browser;
	Page page;
	BrowserContext browserContext;

	
	@Test(priority = 1)
	public void testCase1() {
	 System.out.println("This is the A Normal Test Case"); 
	}
	
    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
    	browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterMethod
    void closeContext() {
    	browserContext.close();
    }
	 @Test(groups = "regression")
	 public void navigateURL() {
	   System.out.println("This is to automated magento web application"); 
       page.navigate("https://magento.softwaretestingboard.com/");
	   page.waitForLoadState(LoadState.DOMCONTENTLOADED);
	   page.waitForLoadState(LoadState.NETWORKIDLE);
       System.out.println(page.title());
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
       page.locator("//input[@id='firstname']").click();
       page.locator("//input[@id='firstname']").fill("Robert James");
       page.locator("//input[@id='lastname']").click();
       page.locator("//input[@id='lastname']").fill("Schneider");
       page.locator("//input[@id='email_address']").click();
       page.locator("//input[@id='email_address']").fill("bobby.schneider@gmail.com");
       page.locator("//input[@id='password']").click();
       page.locator("//input[@id='password']").fill("4skYbT@!hkh6yCi");
       page.locator("//input[@id='password-confirmation']").click();
       page.locator("//input[@id='password-confirmation']").fill("4skYbT@!hkh6yCi");
       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create an Account")).click();
	 }
	 @Test
	 public void shouldClickButton() {
	   System.out.println("This is the A Normal Test Case");
	 }
}
