import axios from 'axios';

//Service class which executes the call to backend service for generator
export const generateToken = async (inputNumber) => {
  try {
    const response = await axios.get('/generator-service/generate', {
      params: {
        inputNumber,
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error generating token:', error);
    return null;
  }
};