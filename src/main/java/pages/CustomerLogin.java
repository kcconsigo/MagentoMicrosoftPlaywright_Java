package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testcases.CustomerLoginTestCase04;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CustomerLogin extends CustomerLoginTestCase04 {
	
	private Page page; 
	private Locator EmailPasswordLogin, PasswordLogin, SignIn_Button, SignIn_Link, SignOut_Button, SignOut_Link;
	
	private static final Logger log = LogManager.getLogger(CustomerLoginTestCase04.class);
	
	public CustomerLogin(Page page) {
		super();
		this.page = page;
		this.EmailPasswordLogin = page.locator("Email");
		this.PasswordLogin = page.locator("Password");
		this.SignIn_Button = page.locator("Sign In");
		this.SignIn_Link = page.locator("Sign In");
		this.SignOut_Button = page.locator("button");
		this.SignOut_Link = page.locator("Sign Out");
	}
	
	public void custLogin() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
		page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
		page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
//		String str = page.textContent("Welcome, Test User");
		page.getByRole(AriaRole.BANNER).getByText("Welcome, Robert James").click();
		log.info("The Customer is on Customer Login Page ");
	}
	public void custLogout() {
		page.getByRole(AriaRole.BANNER).locator("button").filter(new Locator.FilterOptions().setHasText("Change")).click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();
	    page.navigate("https://magento.softwaretestingboard.com/");
	}

}
