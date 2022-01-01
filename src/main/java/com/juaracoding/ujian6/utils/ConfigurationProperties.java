package com.juaracoding.ujian6.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.txt")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String userName;
	
	@Value("${myemail}")
	private String email;
	
	@Value("${mypassword}")
	private String password;
	
	@Value("${search1}")
	private String search1;
	
	@Value("${search2}")
	private String search2;
	
	@Value("${displayname}")
	private String displayName;
	
	@Value("${firstname}")
	private String firstName;
	
	@Value("${lastname}")
	private String lastName;
	
	@Value("${company}")
	private String company;
	
	@Value("${address1}")
	private String address1;
	
	@Value("${address2}")
	private String address2;
	
	@Value("${country}")
	private String country;
	
	@Value("${city}")
	private String city;
	
	@Value("${province}")
	private String province;
	
	@Value("${postcode}")
	private String postcode;
	
	@Value("${phone}")
	private String phone;
	
	@Value("${comments}")
	private String comments;
	
	@Value("${color1}")
	private String color1;
	
	@Value("${size1}")
	private String size1;
	
	@Value("${color2}")
	private String color2;
	
	@Value("${size2}")
	private String size2;
	
	@Value("${finish}")
	private String finish;

	public String getBrowser() {
		return browser;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getSearch1() {
		return search1;
	}

	public String getSearch2() {
		return search2;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPhone() {
		return phone;
	}

	public String getComments() {
		return comments;
	}

	public String getColor1() {
		return color1;
	}

	public String getSize1() {
		return size1;
	}

	public String getColor2() {
		return color2;
	}

	public String getSize2() {
		return size2;
	}
	
	public String getFinish() {
		return finish;
	}
}
