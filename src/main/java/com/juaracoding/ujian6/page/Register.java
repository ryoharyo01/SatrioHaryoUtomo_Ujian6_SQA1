package com.juaracoding.ujian6.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujian6.driver.DriverSingleton;

public class Register {

	private WebDriver driver;
	
	public Register() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "body > p > a")
	private WebElement btnDismiss;
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")
	private WebElement btnMyAccount;
	
	@FindBy(id = "reg_username")
	private WebElement txtUser;
	
	@FindBy(id = "reg_email")
	private WebElement txtEmail;
	
	@FindBy(id = "reg_password")
	private WebElement txtPass;
	
	@FindBy(css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	private WebElement btnRegister;
	
	public void goToRegister() {
		btnDismiss.click();
		btnMyAccount.click();	
	}
	
	public void inputDataRegister(String username, String email, String pass) {
		txtUser.sendKeys(username);
		txtEmail.sendKeys(email);
		txtPass.sendKeys(pass);
		btnRegister.click();
	}
}
