package com.irfan.token.generator.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfan.token.generator.model.TokenResponseModel;
import com.irfan.token.generator.util.GenerateRandomToken;

@RestController
public class GeneratorRestController {

	@GetMapping("/generate")
	public ResponseEntity<Object> generateToken(
			@RequestParam(value = "inputNumber") String inputNumber) {
		if (!StringUtils.isNumeric(inputNumber)) {
			return new ResponseEntity<>(new TokenResponseModel( null, "Please provide a valid number"),
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new TokenResponseModel( GenerateRandomToken.generateToken(inputNumber), null),
				HttpStatus.ACCEPTED);

	}

}
