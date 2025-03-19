package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testcases.AddToCartTestCase03;
import org.testcases.CustomerLoginTestCase04;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddToCartPage extends AddToCartTestCase03 {
	
	private Page page;
	private Locator SignIn_Link, EmailLogin, PasswordLogin, SignIn_Button, SignOut_Button, SignOut_Link,
	Men_menu, Tops_Menu, HoodiesSweetShirts_Menu, Size_Button, Color_Button, AddToCart_Button, Items_Link, ChecOut_button, Desc_TabPanel;
	
	private static final Logger log = LogManager.getLogger(AddToCartPage.class);
	
	public AddToCartPage(Page page) {
		this.page = page;
		this.SignIn_Link = page.locator("Sign In");
		this.EmailLogin = page.locator("Email");
		this.PasswordLogin = page.locator("Password");
		this.SignIn_Button = page.locator("Sign In");
		this.SignOut_Button = page.locator("button");
		this.SignOut_Link = page.locator("Sign Out");
		this.Men_menu = page.locator(" Men");
		this.Tops_Menu = page.locator(" Tops");
		this.HoodiesSweetShirts_Menu = page.locator("Hoodies & Sweatshirts");
		this.Size_Button = page.locator("S");
		this.Color_Button = page.locator("Black");
		this.AddToCart_Button = page.locator("button");
		this.Items_Link = page.locator(" My Cart 4 4 items");
		this.ChecOut_button = page.locator("Proceed to Checkout");
		this.Desc_TabPanel = page.locator("div");
	}
	public void addtocutSigninLink() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
	}
	public String addtocustLoginEmail(String EmailLogin) {
        page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).click();
        page.getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("bobby.schneider@gmail.com");
		return EmailLogin;
	}
	public String addtocustLoginPassword(String PasswordLogin) {
        page.getByLabel("Password").click();
        page.getByLabel("Password").fill("4skYbT@!hkh6yCi");
        return PasswordLogin;
	}
	public void addtocustLoginButton() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
	}
	public void addtocustitemlistPage() {
//		page.hover(null, null);
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Men")).click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Tops")).click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Hoodies & Sweatshirts")).click();
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Mach Street Sweatshirt As low")).getByLabel("S", new Locator.GetByLabelOptions().setExact(true)).click();
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Mach Street Sweatshirt As low")).getByLabel("Black").click();
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Mach Street Sweatshirt As low")).locator("button").click();
        page.getByText("You added Mach Street").textContent();
	}
	public void addtocartitemlistPage() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Cart 4 4 items")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();
        page.navigate("https://magento.softwaretestingboard.com/checkout/#shipping");
        page.locator("#opc-sidebar").getByRole(AriaRole.TABPANEL).locator("div").filter(new Locator.FilterOptions().setHasText("Mach Street Sweatshirt Qty 4")).first().click();
        page.getByText("Mach Street Sweatshirt Qty 4 $248.00 View Details Options Details Size S Color").textContent();
	}
	public void addtocustLogout() {
		page.getByRole(AriaRole.BANNER).locator("button").filter(new Locator.FilterOptions().setHasText("Change")).click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();
	    page.navigate("https://magento.softwaretestingboard.com/");
	}

}
