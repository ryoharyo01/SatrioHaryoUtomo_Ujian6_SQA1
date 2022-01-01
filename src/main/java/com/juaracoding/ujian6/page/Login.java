package com.juaracoding.ujian6.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujian6.driver.DriverSingleton;

public class Login {
	private WebDriver driver;
	
	public Login() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_login")
	private WebElement txtUser;
	
	@FindBy(id = "user_pass")
	private WebElement txtPass;
	
	@FindBy(id = "wp-submit")
	private WebElement btnLogin;
	
	@FindBy(css = "#post-8 > div > div > div > p:nth-child(2) > strong:nth-child(1)")
	private WebElement txtDisplayName;
	
	public void goToLoggedIn(String username, String password) {		
		txtUser.sendKeys(username);
		txtPass.sendKeys(password);
		btnLogin.click();
	}

	public String getTxtDisplayName() {
		return txtDisplayName.getText();
	}
}
