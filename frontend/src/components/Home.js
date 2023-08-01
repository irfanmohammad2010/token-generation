import { useState } from 'react';
import { generateToken } from '../api/generatorService';
import { validateToken } from '../api/validatorService';
import { validateNumber } from '../utils/utils';
import { TextField, Button, Box, Typography } from '@mui/material';
import ErrorIcon from '@mui/icons-material/Error';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';

//Displays the home page which consists of an input field and a button to generate and validate the token
export default function Home() {
	const [inputNumber, setInputNumber] = useState('');
	const [generatedToken, setGeneratedToken] = useState('');
	const [error, setError] = useState('');
	const [errorText, setErrorText] = useState('');
	const [isTokenValid, setIsTokenValid] = useState('');
	const [color, setColor] = useState('black');

	const handleInputChange = (event) => {
		let validCheck = validateNumber(event.target.value);
		if (validCheck.isValid) {
			setError(false);
			setErrorText('');
			setInputNumber(parseInt(event.target.value));
		}
		else {
			setError(true);
			setErrorText(validCheck.error);
			setInputNumber('');
			setGeneratedToken('');
		}
	}
	const handleGenerateToken = () => {
		generateToken(inputNumber)
			.then((response) => {
				if (response) {
					setGeneratedToken(response.token);
					setIsTokenValid(null);
					setColor('black');
				}
			});

	};

	const renderValidityIcon = () => {
		if (!isTokenValid) {
			return null;
		}
		else if (!isTokenValid.valid) {
			return (
				<ErrorIcon />

			)
		}
		else {
			return (
				<CheckCircleIcon />
			)
		}
	}


	const handleValidateToken = () => {
		validateToken(generatedToken.replaceAll('-', ''))
			.then((response) => {
				if (response) {
					setIsTokenValid(response);
					setColor(response.valid ? 'green' : 'red');

				}
			})
			.catch((error) => {
				setValidationResult('');
				console.error('Error validating token:', error);
			});
	};

	return (
		<Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
			<h1>Token Generator and Validator</h1>
			<Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', marginBottom: '2rem' }}>
				<TextField
					label='Enter the digits to generate token from'
					variant='outlined'
					type='number'
					value={inputNumber}
					onChange={handleInputChange}
					onKeyDown={(event) => {
						if (event.key === 'Enter') {
							handleGenerateToken();
						}
					}}
					error={error}
					helperText={errorText}
					inputProps={{ style: { fontSize: '2rem' } }}
					sx={{ fontSize: '1.5rem', marginRight: '1rem', marginBottom: '1rem' }}
				/>
				<Button variant='contained'
					onClick={handleGenerateToken} s
					x={{ fontSize: '1rem' }}>Generate</Button>
			</Box>
			{generatedToken && (
				<Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
					<Box sx={{ display: 'flex', flexDirection: 'row', alignItems: 'center', color: { color } }}>
						<Typography variant='body1' sx={{ fontSize: '2rem', marginRight: '1rem' }}>
							{generatedToken}
						</Typography>
						{renderValidityIcon()}
					</Box>
					<Button variant='contained' onClick={handleValidateToken}
						sx={{ fontSize: '1rem' }} >Validate
					</Button>
				</Box>)}
		</Box>
	);
}