# Calcit - Fitness Calculator

Calcit is a web application that enables users to calculate various health-related metrics, including BMI, YMCA, PPM, and PRAL.
![](Start1.webp)


## Features

- *BMI Calculator:* Calculate Body Mass Index (BMI) based on weight and height.
- *YMCA Calculator:* Estimate abdominal obesity risk using the YMCA formula.
- *PPM Calculator:* Calculate Basal Metabolic Rate (BMR) using the Harris-Benedict equation.
- *PRAL Calculator:* Calculate Potential Renal Acid Load (PRAL) based on dietary intake.
	
## Installation

1. Clone the repository:
```git clone https://github.com/KingaP00/BMICalculators```
2. To connect to the database, you need to first create it in MySQL Workbench and name it "calcit." Then, run the db.sql file located in the resources folder – tables should be generated for you. In the same folder, there's an application.properties file where you need to input the appropriate username and password for MySQL. When you run the project, the console should display a message indicating that it is running.
3. Use command:
	-  ```npm install``` - Installing all possible packages defined in the package.json file in all its sections – dependencies, devDependencies, peerDependencies, optionalDependencies (those that are not required for the package to function).
	- ``` npm run compile:sass ``` - Compiling SCSS into plain CSS.

## Usage
Create an account and log in.
Next choose the calculator you want to use from the navigation menu.
Enter the required input values.
Click the "Calculate" button.
View the results on the screen.

## Technologies Used
- Java
- Spring Boot
- Thymeleaf
- HTML, CSS

## License
This project is licensed under the MIT License - see more  in https://opensource.org/license/mit/
