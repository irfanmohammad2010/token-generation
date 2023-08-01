package com.irfan.token.validator.model;

import java.util.Objects;

public class ValidatorResponseModel {

	public ValidatorResponseModel(boolean isValid, String errorMessage) {
		super();
		this.isValid = isValid;
		this.errorMessage = errorMessage;
	}

	private boolean isValid;

	private String errorMessage;

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessage, isValid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidatorResponseModel other = (ValidatorResponseModel) obj;
		return Objects.equals(errorMessage, other.errorMessage) && isValid == other.isValid;
	}

}
