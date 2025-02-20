package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class SignInPageTestcase02 {
	

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
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int) height));
            Page page = browsercontext.newPage();
            page.navigate("https://magento.softwaretestingboard.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
            page.getByLabel("Email").click();
            page.getByLabel("Email").fill("bobby.schneider@gmail.com");
            page.getByLabel("Password").click();
            page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
            
            playwright.close();
          }
	}

}
