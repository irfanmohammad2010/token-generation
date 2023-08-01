
package com.irfan.token.generator.util;

import org.junit.jupiter.api.Test;

class GenerateRandomTokenTest {

	@Test
	final void testGenerateToken() {
		String randomToken = GenerateRandomToken.generateToken("1234");
		assert randomToken.length() == 19;
		assert randomToken.split("-").length == 4;
	}

}
