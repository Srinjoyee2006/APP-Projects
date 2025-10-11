import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    // Swing components
    JLabel nameLabel, ageLabel, emailLabel;
    JTextField nameField, ageField, emailField;
    JButton submitButton;

    // Database URL, username, password
    String url = "jdbc:mysql://localhost:3306/yourDB";
    String username = "root";
    String password = "password";

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Labels
        nameLabel = new JLabel("Name:");
        ageLabel = new JLabel("Age:");
        emailLabel = new JLabel("Email:");

        // Text fields
        nameField = new JTextField();
        ageField = new JTextField();
        emailField = new JTextField();

        // Button
        submitButton = new JButton("Register");
        submitButton.addActionListener(this);

        // Add components to frame
        add(nameLabel); add(nameField);
        add(ageLabel); add(ageField);
        add(emailLabel); add(emailField);
        add(new JLabel()); add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Input validation method
    private boolean validateInputs() {
        if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int age = Integer.parseInt(ageField.getText());
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Enter a valid age!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!emailField.getText().contains("@")) {
            JOptionPane.showMessageDialog(this, "Enter a valid email!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if (validateInputs()) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();

            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, age);
                pst.setString(3, email);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Student registered successfully!");
                    nameField.setText("");
                    ageField.setText("");
                    emailField.setText("");
                }

                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
