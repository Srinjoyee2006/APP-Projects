# 🌟 APP Projects  

Welcome to **APP Projects**, a collection of beginner-to-intermediate level **Java Swing applications** demonstrating GUI development, event handling, and database integration using **Java** and **JDBC**.  

These projects focus on building strong core skills in Java programming and user interface design.  

---

## 🚀 Projects Included  

### 🧮 1.Calculator App  
A simple yet responsive **GUI-based calculator** built using **Java Swing**.  
It performs basic arithmetic operations like **addition**, **subtraction**, **multiplication**, and **division**.  

#### ✨ Features  
- User-friendly interface with responsive buttons  
- Real-time input and result display  
- Supports clear (`C`) and equals (`=`) operations  
- Demonstrates event-driven programming using ActionListeners  

#### ▶️ Run the Project  
bash
javac CalculatorApp.java
java CalculatorApp
###🧾 2. Student Registration Form
A Java Swing + JDBC project that allows users to register students by entering their details and storing them in a MySQL database.

✨ Features
Input fields for Name, Age, and Email

Input validation for empty fields, age, and email format

Database integration using JDBC

Success and error message handling

🗄️ Database Setup
sql
Copy code
CREATE DATABASE yourDB;

USE yourDB;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    email VARCHAR(50)
);
▶️ Run the Project
bash
Copy code
javac StudentRegistrationForm.java
java StudentRegistrationForm
🛠️ Tech Stack
Technology	Purpose
☕ Java	Core programming language
🖼️ Swing	GUI design and event handling
🗃️ JDBC	Database connectivity
💾 MySQL	Data storage and management

⚙️ Setup Instructions
Clone this repository

bash
Copy code
git clone https://github.com/Srinjoyee2006/APP-Projects.git
Open the project folder in your preferred IDE (Eclipse / IntelliJ / VS Code).

Ensure you have MySQL installed and running.

Update your MySQL username and password in the Java file.

Compile and run the Java programs using the terminal or your IDE.

💡 Future Enhancements
Add scientific calculator features (square root, percentage, power, etc.)

Display registered students in a table format within the GUI

Add an option to export student data to CSV or PDF

Upgrade UI using JavaFX or custom styling
