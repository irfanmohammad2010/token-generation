package com.irfan.token.validator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfan.token.validator.model.ValidatorResponseModel;
import com.irfan.token.validator.util.TokenValidator;

@RestController
public class ValidatorRestController {

	@GetMapping("/validate")
	public ResponseEntity<Object> validateToken(@RequestParam(value = "token", required = false) String token) {
		if (!TokenValidator.performSanitaryCheck(token)) {
			return new ResponseEntity<Object>(
					new ValidatorResponseModel(false, "Please provide a valid 16 digit token (XXXX-XXXX-XXXX-XXXX)"),
					HttpStatus.BAD_REQUEST);
		} else if (!TokenValidator.isValidLuhnToken(token)) {
			return new ResponseEntity<Object>(new ValidatorResponseModel(false, null), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>(new ValidatorResponseModel(true, null), HttpStatus.ACCEPTED);

		}
	}

}
