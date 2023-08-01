package com.irfan.token.generator.model;

import java.util.Objects;

public class TokenResponseModel {

	public TokenResponseModel(String token, String errorMessage) {
		super();
		this.token = token;
		this.errorMessage = errorMessage;
	}

	private String token;

	private String errorMessage;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessage, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenResponseModel other = (TokenResponseModel) obj;
		return Objects.equals(errorMessage, other.errorMessage) && Objects.equals(token, other.token);
	}

}
