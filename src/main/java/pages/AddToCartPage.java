package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testcases.AddToCartTestCase03;
import org.testcases.CustomerLoginTestCase04;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddToCartPage extends AddToCartTestCase03 {
	
	private Page page;
	private Locator SignIn_Link, EmailLogin, PasswordLogin, SignIn_Button, SignOut_Button, SignOut_Link,
	Men_menu, Tops_Menu, HoodiesSweetShirts_Menu, Size_Button, Color_Button, AddToCart_Button, Items_Link, ChecOut_button, Desc_TabPanel,
	Next_Button, Link_Items, PlaceOrder_Button, Continue_Button, Items_LinkTo;
	
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
		this.Link_Items = page.locator("Mach Street Sweatshirt");
		this.Size_Button = page.locator("S");
		this.Color_Button = page.locator("Black");
		this.AddToCart_Button = page.locator("Add to Cart");
		this.Items_Link = page.locator(".minicart-wrapper");
		this.Items_LinkTo = page.locator(".minicart-wrapper.active");
		this.ChecOut_button = page.locator("Proceed to Checkout");
		this.Next_Button = page.locator("Next");
		this.PlaceOrder_Button = page.locator("Place Order");
		this.Continue_Button = page.locator("Continue Shopping");
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
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Men")).first().hover();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Tops")).first().hover();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Hoodies & Sweatshirts")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Mach Street Sweatshirt")).first().hover();
        page.locator("#maincontent div").filter(new Locator.FilterOptions().setHasText("Mach Street Sweatshirt As low")).nth(3).click();
        page.getByLabel("S", new Page.GetByLabelOptions().setExact(true)).click();
        page.getByLabel("Black").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();

	}
	public void addtocartitemlistPage() {
		Locator spinner = page.locator("//span[@data-bind=\"css: { empty: !!getCartParam('summary_count') == false && !isLoading() }, blockLoader: isLoading\"]");
		spinner.waitFor();
		spinner.isVisible();
		spinner.count();
        boolean menuTxt = page.getByText("You added Mach Street Sweatshirt to your").isEnabled();
        System.out.println(menuTxt);
		page.locator(".minicart-wrapper").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();

	}
	public void addtocartitemShippingPage() {
		Locator spinLoader = page.locator("#checkout-loader");
		spinLoader.waitFor();
		spinLoader.isVisible();
		spinLoader.count();
        page.getByLabel("Table Rate").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText("Please wait...")).first().isVisible();
	}
	public void addtocartitemReviewPaymentsPage() {
		Locator spinReview = page.locator("div").filter(new Locator.FilterOptions().setHasText("Please wait...")).first();
		spinReview.waitFor();
		spinReview.isVisible();
		spinReview.count();
	    page.getByText("My billing and shipping address are the same Robert James Schneider Santolan").textContent();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order")).click();
	}
	public void addtocartsuccessPage() {
		Locator spinSuccess =  page.locator("div").filter(new Locator.FilterOptions().setHasText("Please wait...")).first();
		spinSuccess.waitFor();
		spinSuccess.isVisible();
		spinSuccess.count();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue Shopping")).click();
	}
	public void addtocustLogout() {
		page.getByRole(AriaRole.BANNER).locator("button").filter(new Locator.FilterOptions().setHasText("Change")).click();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();
	    page.navigate("https://magento.softwaretestingboard.com/");
	    
	}

}
