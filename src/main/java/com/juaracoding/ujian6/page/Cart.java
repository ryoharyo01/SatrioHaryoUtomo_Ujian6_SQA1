package com.juaracoding.ujian6.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.ujian6.driver.DriverSingleton;

public class Cart {
	private WebDriver driver;
	private Select select;
	
	public Cart() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > div > a")
	private WebElement btnHome;
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > a")
	private WebElement btnSearch;
	
	@FindBy(css = "#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	private WebElement txtSearch;
	
	@FindBy(css = "#product-1301 > div.single-product-content > div.summary.entry-summary > a")
	private WebElement btnCompare;
	
	@FindBy(css = "#DataTables_Table_0 > tbody > tr.add-to-cart.odd > td > a")
	private WebElement btnOptions;
	
	@FindBy(css = "#product-1301 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAddShoes;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div.noo-product-item.one.noo-product-sm-4.not_featured.post-1348.product.type-product.status-publish.has-post-thumbnail.product_cat-sun-glasses.product_tag-sun-glasses.product_tag-women.has-featured.first.instock.shipping-taxable.purchasable.product-type-variable > div > div.noo-product-thumbnail > div.noo-product-slider.owl-carousel.owl-theme > div.owl-wrapper-outer.autoHeight > div > div.owl-item.active > a")
	private WebElement btnGlass;
	
	@FindBy(id = "pa_color")
	private WebElement selectColor;
	
	@FindBy(id = "pa_size")
	private WebElement SelectSize;
	
	@FindBy(css = "#product-1348 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAddGlass;
	
	public void searchProduct(String product) {
		btnSearch.click();
		txtSearch.sendKeys(product);
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void addGlass(String color, String size) {
		btnGlass.click();
		
		select = new Select(selectColor);
		select.selectByVisibleText("Black");
		
		select = new Select(SelectSize);
		select.selectByVisibleText("One");
		
		btnAddGlass.click();
	}
	
	public void addShoes(String color, String size) {
		btnCompare.click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}	
		
		driver.switchTo().frame(0);
		btnOptions.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}	
		select = new Select(selectColor);
		select.selectByVisibleText("Nude");
		
		select = new Select(SelectSize);
		select.selectByVisibleText("36");
		
		btnAddShoes.click();
	}
}
