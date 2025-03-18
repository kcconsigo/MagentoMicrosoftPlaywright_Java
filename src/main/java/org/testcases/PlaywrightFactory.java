package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightFactory {
	
	Playwright playwright;
	protected Page page;
	Browser browser;
	BrowserContext browserContext;
	
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		System.out.println(width+"---"+height);

	}

	@Parameters({"appURL", "browserType"})
	public Page launchBrowser(String appURL, String browserType) {
		
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) 1536.0, (int) 864.0));
            browsercontext.setDefaultTimeout(60000);
            browsercontext.tracing().start(new Tracing.StartOptions()
            		.setScreenshots(true)
            		.setSnapshots(true)
            		.setSources(true));
		      Page browserpage = browsercontext.newPage();
		      browserpage.navigate(appURL);
		      browsercontext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		      browserpage.waitForLoadState(LoadState.DOMCONTENTLOADED);
		      browserpage.waitForLoadState(LoadState.NETWORKIDLE);
		    }
		return page;
		
	}
	public void closeBrowser() {
		page.close();
		browser.close();
		playwright.close();
	}

}
