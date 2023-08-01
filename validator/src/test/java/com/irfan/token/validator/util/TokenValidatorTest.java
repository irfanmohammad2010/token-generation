package com.irfan.token.validator.util;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TokenValidatorTest {

	@Test
	final void testPerformSanitaryCheck() {
		boolean isValid = TokenValidator.performSanitaryCheck("1234567890123456");
		assert isValid == true;
		
		isValid = TokenValidator.performSanitaryCheck("123456");
		assert isValid == false;
		
		isValid = TokenValidator.performSanitaryCheck("abcdefghijklmnop");
		assert isValid == false;

	}

	@Test
	final void testIsValidLuhnToken() {
		String validToken = "5555865556555856";
		String invalidToken = "5555865556555857";
		assert TokenValidator.isValidLuhnToken(validToken) == true;
	}

}
