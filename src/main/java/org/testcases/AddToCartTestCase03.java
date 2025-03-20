package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import pages.AddToCartPage;

public class AddToCartTestCase03 {
	
	Playwright playwright;
	protected Page page;
	Browser browser;
	BrowserContext browserContext;

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		System.out.println(width+"---"+height);
		
		try (Playwright playwright = Playwright.create()) {
		      List<BrowserType> browserTypes = Arrays.asList(
		    	        playwright.chromium(),
		    	        playwright.webkit(),
		    	        playwright.firefox()
		    	      );
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int) height));
            browsercontext.setDefaultTimeout(60000);
            browsercontext.tracing().start(new Tracing.StartOptions()
            		.setScreenshots(true)
            		.setSnapshots(true)
            		.setSources(true));
            Page page = browsercontext.newPage();
            page.navigate("https://magento.softwaretestingboard.com/");
            browsercontext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
            for (BrowserType browserType : browserTypes) {
            	page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + browserType.name() + ".png")));
            }
            System.out.println(page.title());
            
            AddToCartPage addtoCartPage = new AddToCartPage(page);
            addtoCartPage.addtocutSigninLink();
            addtoCartPage.addtocustLoginEmail(null);
            addtoCartPage.addtocustLoginPassword(null);
            addtoCartPage.addtocustLoginButton();
            addtoCartPage.addtocustitemlistPage();
            addtoCartPage.addtocartitemlistPage();
            addtoCartPage.addtocartitemShippingPage();
		    }
	}

}
