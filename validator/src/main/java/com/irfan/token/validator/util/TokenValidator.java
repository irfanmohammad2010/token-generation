package com.irfan.token.validator.util;

import org.apache.commons.lang3.StringUtils;

public class TokenValidator {

	public static boolean performSanitaryCheck(String token) {
		if (token.length() != 16) {
			return false;
		} else if (!StringUtils.isNumeric(token)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isValidLuhnToken(String token) {
		char[] digitsArray = token.toCharArray();
		int lastDigit = digitsArray[digitsArray.length - 1] - '0';
		int sum = 0;
		boolean multiplyBy2toggle = true;
		for (int i = 0; i < digitsArray.length - 1; i++) {
			int currentDigit = digitsArray[i] - '0';
			if (multiplyBy2toggle) {
				if (currentDigit > 4) {
					sum = sum + currentDigit * 2 - 9;
				} else {
					sum = sum + currentDigit * 2;
				}
				multiplyBy2toggle = false;
			} else {
				sum += currentDigit;
				multiplyBy2toggle = true;
			}
		}
		if ((sum + lastDigit) % 10 == 0) {
			return true;
		} else {
			return false;
		}

	}

}
