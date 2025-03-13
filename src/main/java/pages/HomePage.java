package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
	
	public Page page;
	public Locator CreateAccountButton, CreateAccountLink;
	
	
	public HomePage(Page page) {
		this.page = page;
//		this.firstName = page.locator("//input[@id='firstname']");
//		this.lastName = page.locator("//input[@id='lastname']");
//		this.Email = page.locator("//input[@id='email_address']");
//		this.Password = page.locator("//input[@id='password']");
//		this.ConfirmPassword = page.locator("//input[@id='password-confirmation']");
		this.CreateAccountButton = page.locator("Create an Account");
		this.CreateAccountLink = page.locator("Create an Account");
	}
	
	public void clickAccountLinkPage() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
	}
	
	public void clickCreateAccountButton() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create an Account")).click();
	}

//	public String createPersonalInformation(String text) {
//		firstName.fill(text);
//		lastName.fill(text);
//		Email.fill(text);
//		Password.fill(text);
//		ConfirmPassword.fill(text);
//		return text;
//		
//	}
	
	public void createAccountBtn() {
		CreateAccountButton.click();
	}

}
