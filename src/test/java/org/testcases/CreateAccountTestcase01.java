package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.beust.jcommander.Parameters;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import testcases.createnewCustomerAccountPage;

public class CreateAccountTestcase01 {
	
	Playwright playwright;
	protected Page page;
	Browser browser;
	BrowserContext browserContext;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
            
            String psTitle = page.title();
            psTitle = "Very Strong";
            System.out.print("Password Strength: " + psTitle);
            
            playwright.close();
          }
            
        }
	

}
