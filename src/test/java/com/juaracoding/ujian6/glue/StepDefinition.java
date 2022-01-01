package com.juaracoding.ujian6.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujian6.config.AutomationFrameworkConfiguration;
import com.juaracoding.ujian6.driver.DriverSingleton;
import com.juaracoding.ujian6.page.Cart;
import com.juaracoding.ujian6.page.Checkout;
import com.juaracoding.ujian6.page.Login;
import com.juaracoding.ujian6.page.Register;
import com.juaracoding.ujian6.utils.ConfigurationProperties;
import com.juaracoding.ujian6.utils.Constants;
import com.juaracoding.ujian6.utils.Log;
import com.juaracoding.ujian6.utils.TestCases;
import com.juaracoding.ujian6.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

	private WebDriver driver;
	private Register register;
	private Login login;
	private Cart cart;
	private Checkout checkout;
	ExtentTest extentTest;
	TestCases[] tests = TestCases.values();
	static ExtentReports report = new ExtentReports("src/main/resources/Report.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		register = new Register();
		login = new Login();
		cart = new Cart();
		checkout = new Checkout();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		//Log.getLogData(Log.class.getName());
		//Log.startTest(tests[Utils.testCount].getTestName());
	}
	
	// Register
	@Given("^User go to the Website")
	public void user_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		//Log.info("INFO: Navigating to " + Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("^User click My Account button")
	public void user_click_My_Account_button() {
		register.goToRegister();
		extentTest.log(LogStatus.PASS, "User go to the Website");
	}
	
	@When("^User input username email password and click register")
	public void user_input_username_email_password_and_click_register() {
		register.inputDataRegister(configurationProperties.getUserName(), configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username email password and click register");
	}
	
	@Then("^User go to Login page")
	public void user_go_to_Login_page() {
		 extentTest.log(LogStatus.PASS, "User go to Login page");
	}
	
	//Login
	@When("^User input username password and click login")
	public void user_input_username_password_and_click_login() {
		login.goToLoggedIn(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username password and click login");
	}
	
	@Then("^User go to My Account page")
	public void user_go_to_My_Account_page() {
		assertEquals(configurationProperties.getDisplayName(), login.getTxtDisplayName());
		extentTest.log(LogStatus.PASS, "User go to My Account page");
	}
	
	//Add to Cart item shoes
	@When("^User click search type keyword shoes and press enter")
	public void user_click_search_type_keyword_shoes_and_press_enter() {
		cart.searchProduct(configurationProperties.getSearch1());
		extentTest.log(LogStatus.PASS, "User click search type keyword shoes and press enter");
	}
	
	@When("^User click compare click select option choose color size and click add to cart")
	public void user_click_compare_click_select_option_choose_color_size_and_click_add_to_cart() {
		cart.addShoes(configurationProperties.getColor1(),configurationProperties.getSize1());
		extentTest.log(LogStatus.PASS, "User click compare click select option choose color size and click add to cart");
	}
	
	@Then("^User go to search shoes page")
	public void user_go_to_search_shoes_page() {
		extentTest.log(LogStatus.PASS, "User go to search shoes page");
	}
	
	//Add to Cart item  glass
	@When("^User click search type keyword glass and press enter")
	public void user_click_search_type_keyword_glass_and_press_enter() {
		cart.searchProduct(configurationProperties.getSearch2());
		extentTest.log(LogStatus.PASS, "User click search type keyword glass and press enter");
	}
	
	@When("^User click product choose color size and click add to cart")
	public void user_click_product_choose_color_size_and_click_add_to_cart() {
		cart.addGlass(configurationProperties.getColor2(),configurationProperties.getSize2());
		extentTest.log(LogStatus.PASS, "User click product choose color size and click add to cart");
	}
	
	@Then("^User go to search glass page")
	public void user_go_to_search_glass_page() {
		extentTest.log(LogStatus.PASS, "User go to search glass page");
	}
	
	//Checkout
	@When("^User click icon cart and click proceed to checkout")
	public void user_click_icon_cart_and_click_proceed_to_checkout() {
		checkout.proceedToCheckout();
		extentTest.log(LogStatus.PASS, "User click icon cart and click proceed to checkout");
	}
	
	@When("^User input billing details and click place order")
	public void user_input_billing_details_and_click_place_order() {
		checkout.placeOrder(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getCompany(), configurationProperties.getCountry(), configurationProperties.getAddress1(), configurationProperties.getAddress2(), configurationProperties.getCity(), configurationProperties.getProvince(), configurationProperties.getPostcode(), configurationProperties.getPhone(), configurationProperties.getComments());
		extentTest.log(LogStatus.PASS, "User input billing details and click place order");
	}
	
	@Then("^User go to order details page")
	public void user_go_to_order_details_page() {
		assertEquals(configurationProperties.getFinish(), checkout.getThankyou());
		extentTest.log(LogStatus.PASS, "User go to order details page");
	}
	
	@After
	public void closeObject() {
		//Log.endTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
		report.endTest(extentTest);
		report.flush();
	}
}
