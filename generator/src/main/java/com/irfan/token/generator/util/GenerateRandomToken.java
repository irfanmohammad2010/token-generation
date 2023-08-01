package com.irfan.token.generator.util;


import java.util.Random;

public class GenerateRandomToken {
	private static Random random = new Random();

	public static String generateToken(String inputNumber) {
		StringBuilder builder = new StringBuilder();
		int length = inputNumber.length();
		builder.append(inputNumber.charAt(random.nextInt(length)));
		for (int i = 1; i < 16; i++) {
			if (i % 4 == 0)
				builder.append("-");
			builder.append(inputNumber.charAt(random.nextInt(length)));
		}
		return builder.toString() ;
		
		
	}

}
