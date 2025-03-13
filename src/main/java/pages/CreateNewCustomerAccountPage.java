package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateNewCustomerAccountPage {
	
	private Page page;
	private Locator FirstName;
	private Locator LastName;
	private Locator Email;
	private Locator Password;
	private Locator ConfirmPassword;
	private Locator CreateAccButton;
	
	public CreateNewCustomerAccountPage(Page page) {
		this.page = page;
		this.FirstName = page.locator("//input[@id='firstname']");
		this.LastName = page.locator("//input[@id='lastname']");
		this.Email = page.locator("//input[@id='email_address']");
		this.Password = page.locator("//input[@id='password']");
		this.ConfirmPassword = page.locator("//input[@id='password-confirmation']");
		this.CreateAccButton = page.locator("Create an Account");
	}
	public String createFirstName(String FirstName) {
		page.locator("//input[@id='firstname']").fill("Robert James");
		return FirstName;
		
	}
	public String createLastName(String LastName) {
		page.locator("//input[@id='lastname']").fill("Schneider");
		return LastName;
		
	}
	public String createEmail(String Email) {
		page.locator("//input[@id='email_address']").fill("bobby.schneider@gmail.com");
		return Email;
		
	}
	public String createPassword(String Password) {
		page.locator("//input[@id='password']").fill("4skYbT@!hkh6yCi");
		return Password;
		
	}
	public String createConfirmPassword(String ConfirmPassword) {
		page.locator("//input[@id='password-confirmation']").fill("4skYbT@!hkh6yCi");
		return ConfirmPassword;
		
	}
	public void createAccntButton() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create an Account")).click();
	}
	
	

}
