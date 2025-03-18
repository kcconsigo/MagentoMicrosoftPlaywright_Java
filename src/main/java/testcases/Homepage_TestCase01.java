package testcases;

import org.base.BaseClass;
import org.pages.HomePage;
import org.testcases.PlaywrightFactory;
import org.testcases.PlaywrightJavaFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class Homepage_TestCase01 extends BaseClass{
	
	PlaywrightJavaFactory pw;
	Page page;
	HomePage homePage;
	
	public void createDBConn() {
		System.out.println("Creating DB Connection");
	}
	
    public void closeDBConn() {
		System.out.println("Closing DB Connection");
	}
    @BeforeClass
    @Parameters({ "appURL", "browserType" })
	public void setUp(String appURL, String browserType) {
    	pw = new PlaywrightJavaFactory();
    	page = pw.launchBrowser(appURL, browserType);
    	homePage = new HomePage(page);
    	
	}
    @Test
    public void homePageTitle() {
    	String actTitle = homePage.getHomePageTitle();
    	Assert.assertEquals(actTitle, "Home Page");
    	
    }
    @Test
    public void homePageURL() {
    	String actURL = homePage.getHomePageURL();
    	Assert.assertEquals(actURL, "https://magento.softwaretestingboard.com/");
    }
    @Test 
    public void accountLinkPage() {
    	homePage.clickAccountLinkPage();
    }
    @AfterClass
    public void tearDown() {
    	page.context().browser().close();
    }
    
	@BeforeMethod
	public void custLaunchBrowser() {
		System.out.println("Executing Browser Page");
	}
	
	@AfterMethod
	public void custCloseBrowser() {
		System.out.println("Executing Closing the Browser Page");
	}
	
	@Test(priority=0)
	public void createNewCustAccount() {
		System.out.println("Executing Create New Customer Account Page");
	}

}
