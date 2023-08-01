//util functions to do some sanitory checks for number

export const validateNumber = (inputNumber) => {
	if (!(parseInt(inputNumber) == 0 || parseInt(inputNumber))) {
		return { isValid: false, error: "Please enter a valid number in digits 0-9" };
	}
	else if (inputNumber.length > 10) {

		return { isValid: false, error: "Length should be less than 10 digits" };

	}
	else {
		return { isValid: true };
	}

};