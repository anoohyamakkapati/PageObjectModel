package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.Guru99HomePage;
import PageFactory.Guru99Login;




public class TestLoginWithPageFactory {

	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.anoohya.com/V4/");
	}

	
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct(){
		//Create Login Page object
	objLogin = new Guru99Login(driver);
	//Verify login page title
	String loginPageTitle = objLogin.getLoginTitle();
	Assert.assertTrue(loginPageTitle.toLowerCase().contains("anoohya bank"));
	//login to application
	objLogin.loginTo("mgr123", "mgr!23");
	// go the next page
	objHomePage = new HomePage(driver);
	//Verify home page
	Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
	
}
