package org.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class CustLoginTestCaseTestNG {
	
	static Playwright playwright = null;
	static Browser browser;
	Page page;
	BrowserContext browserContext;
	
	private static final Logger log = LogManager.getLogger(CustLoginTestCaseTestNG.class);
	
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
//	 @Test(groups = "regression")
//	 public void navigateURL() {
//	   System.out.println("This is to automated magento web application"); 
//       page.navigate("https://magento.softwaretestingboard.com/");
//	   page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//	   page.waitForLoadState(LoadState.NETWORKIDLE);
//       System.out.println(page.title());
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
//		page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
//		page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
//		page.getByRole(AriaRole.BANNER).getByText("Welcome, Robert James").click();
//		log.info("The Customer is on Customer Login Page ");
//	 }
	 @Test(groups = "regression")
	 public void custLogin() {
		   System.out.println("This is to automated magento web application"); 
	       page.navigate("https://magento.softwaretestingboard.com/");
		   page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		   page.waitForLoadState(LoadState.NETWORKIDLE);
	       System.out.println(page.title());
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
			page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
			page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
			page.getByRole(AriaRole.BANNER).getByText("Welcome, Robert James").click();
			log.info("The Customer is on Customer Login Page ");
	 }
	 @Test(groups = "regression")
	 public void custLogout() {
		   System.out.println("This is to automated magento web application"); 
	       page.navigate("https://magento.softwaretestingboard.com/");
		   page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		   page.waitForLoadState(LoadState.NETWORKIDLE);
	       System.out.println(page.title());
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
			page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
			page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
			page.getByRole(AriaRole.BANNER).getByText("Welcome, Robert James").click();
			log.info("The Customer is on Customer Login Page ");
			page.getByRole(AriaRole.BANNER).locator("button").filter(new Locator.FilterOptions().setHasText("Change")).click();
		    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();
		    page.navigate("https://magento.softwaretestingboard.com/");
	 }

}
