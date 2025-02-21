package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

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
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int) height));
            browsercontext.tracing().start(new Tracing.StartOptions()
            		.setScreenshots(true)
            		.setSnapshots(true)
            		.setSources(true));
            Page page = browsercontext.newPage();
            page.navigate("https://magento.softwaretestingboard.com/");
            browsercontext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
            System.out.println(page.title());
		      page.navigate("https://magento.softwaretestingboard.com/");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
		      page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).click();
		      page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
		      page.getByLabel("Password").click();
		      page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
		      page.waitForLoadState(LoadState.LOAD);
		      page.waitForLoadState(LoadState.NETWORKIDLE);
		      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Pants")).click();
		      page.getByText("Aether Gym Pant").click();
		      page.getByLabel("33").click();
		      page.getByLabel("32").click();
		      page.getByLabel("33").click();
		      page.getByLabel("Blue").click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
		      page.getByText("You added Aether Gym Pant to").click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("shopping cart")).click();
		      page.locator("#shopping-cart-table").getByTitle("Aether Gym Pant ").click();
		      page.navigate("https://magento.softwaretestingboard.com/checkout/cart/");
		      page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Aether Gym Pant Aether Gym")).locator("dl").click();
		      page.getByText("$59.20").nth(1).click();
		      page.getByText("$59.20").nth(2).click();
		      page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Order Total $")).locator("span").click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();
		      page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Loading...")).click();
		    }

	}

}
