package com.juaracoding.ujian6.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.ujian6.driver.DriverSingleton;

public class Checkout {
	private WebDriver driver;
	private Select select;
	
	public Checkout() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#nav-menu-item-cart > a")
	private WebElement btnCart;
	
	@FindBy(css = "#post-6 > div > div > div.cart-collaterals > div.cart_totals > div > a")
	private WebElement btnCheckout;
	
	@FindBy(id = "billing_first_name")
	private WebElement txtFirstName;
	
	@FindBy(id = "billing_last_name")
	private WebElement txtLastName;
	
	@FindBy(id = "billing_company")
	private WebElement txtCompany;
	
	@FindBy(id = "billing_country")
	private WebElement SelectCountry;
	
	@FindBy(id = "billing_address_1")
	private WebElement txtAddress1;
	
	@FindBy(id = "billing_address_2")
	private WebElement txtAddress2;
	
	@FindBy(id = "billing_city")
	private WebElement txtCity;
	
	@FindBy(id = "billing_state")
	private WebElement selectState;
	
	@FindBy(id = "billing_postcode")
	private WebElement txtPin;
	
	@FindBy(id = "billing_phone")
	private WebElement txtPhone;
	
	@FindBy(id = "order_comments")
	private WebElement txtComments;
	
	@FindBy(id = "terms")
	private WebElement ckbTerms;
	
	@FindBy(id = "place_order")
	private WebElement btnOrder;
	
	@FindBy(className = "woocommerce-thankyou-order-received")
	private WebElement txtThankyou;
	
	public void proceedToCheckout() {
		btnCart.click();
		btnCheckout.click();
	}
	
	public void placeOrder(String firstname, String lastname, String company, String country, String addr1, String addr2, String city, String state, String postcode, String phone, String comments) {
			txtFirstName.sendKeys(firstname);
			txtLastName.sendKeys(lastname);
			txtCompany.sendKeys(company);
			select = new Select(SelectCountry);
			select.selectByVisibleText(country);
			txtAddress1.sendKeys(addr1);
			txtAddress2.sendKeys(addr2);
			txtCity.sendKeys(city);
			select = new Select(selectState);
			select.selectByVisibleText(state);
			txtPin.sendKeys(postcode);
			txtPhone.sendKeys(phone);
			txtComments.sendKeys(comments);
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}	
			
			ckbTerms.click();
			
			btnOrder.click();
	}
	
	public String getThankyou() {
		return txtThankyou.getText();
	}
}
