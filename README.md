# Token Generation and Validation

**Summary** :  
Generates a random 16 digit token using the digits provided by the user. 
This generated token can then be validated for correctness by using luhn algorithm.

**Installation**:  
Prerequisites:  
* Node >16  
* npm > 9  
* Clone the Repo and run start.bat
* This will run the spring boot applications first and installs the required libraries using npm and start the frontend application

**Tech Stack** :  
The frontend is developed using React. The components are taken from the Material UI library
Frontend is started on localhost:8080 and connects to 2 backend applications on 8081 and 8082. A proxy is being used to overcome CORS issue.
There are 2 backend spring boot applications, one is called to generate a random token based on the input given from the UI.
Other Application can validate a token using Luhn Algorithm
Assumption : The Token Generator Service generates always a random 16 digit token and not a valid luhn token.


**Using the App** :  
Once the App is started, you see an input where you can enter the digits, some sanitory checks are perfomed and validation errors shown for wrong inputs.
On clicking of Generate button, the token is generated using the digits and displayed below with a validate button.
On clicking of validate, if the generated token is valid, the text appears green with a Tick icon beside.
If invalid its shown in red with a error icon.

