import axios from 'axios';

//Service class which executes the call to backend service for validator

export const validateToken = async (token) => {
  try {
    const response = await axios.get('/validator-service/validate', {params: {
        token,
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error validating token:', error);
    return null;
  }
};