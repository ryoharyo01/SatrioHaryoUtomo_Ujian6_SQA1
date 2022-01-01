package com.juaracoding.ujian6.driver;

import com.juaracoding.ujian6.utils.Constants;

public class DriverStrategyImplementer {

	public static DriverStrategy chooseStrategy(String strategy) {
		if (strategy.equalsIgnoreCase(Constants.CHROME)) {
			return new Chrome();
		}else if(strategy.equalsIgnoreCase(Constants.FIREFOX)) {
			return new Firefox();
		}else {
			return null;
		}
	}
}
