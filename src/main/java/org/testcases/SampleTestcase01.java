package org.testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.beust.jcommander.Parameters;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import testcases.createnewCustomerAccountPage;

public class SampleTestcase01 {
	
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
            Page page = browsercontext.newPage();
//            createnewCustomerAccountPage newcustomer = new createnewCustomerAccountPage(page);
//            newcustomer.navigate();
//            newcustomer.newCustomerURL();
//            newcustomer.firstName("Robert James");
//            
            page.navigate("https://magento.softwaretestingboard.com/");
            System.out.println(page.title());
            
            page.locator("(//a[normalize-space()='Create an Account'])[1]").click();
            page.locator("//input[@id='firstname']").fill("Robert James");
            page.locator("//input[@id='lastname']").fill("Schneider");
            page.locator("//input[@id='email_address']").fill("bobby.schneider@gmail.com");
            page.locator("//input[@id='password']").fill("4skYbT@!hkh6yCi");
            page.locator("//input[@id='password-confirmation']").fill("4skYbT@!hkh6yCi");
            page.locator("//button[@title='Create an Account']").click();
            
            String psTitle = page.title();
            psTitle = "Very Strong";
            System.out.print("Password Strength: " + psTitle);
            
//            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
//            page.getByLabel("First Name").click();
//            page.getByLabel("First Name").fill("Kclyn");
//            page.getByLabel("Last Name").click();
//            page.getByLabel("Last Name").fill("Cabelin");
//            page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).click();
//            page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("kcconsigo@gmail.com");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true)).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*").setExact(true)).fill("Pa$$word12");
//            page.getByLabel("Confirm Password").click();
//            page.getByLabel("Confirm Password").fill("Pa$$word12");
//            page.getByText("Password Strength: Strong").click();
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create an Account")).click();
            
            playwright.close();
          }
            
        }
	

}
