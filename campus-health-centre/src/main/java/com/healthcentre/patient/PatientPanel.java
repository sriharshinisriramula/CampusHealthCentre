```java
package com.healthcentre.patient;

import com.healthcentre.dao.PatientDAO;
import com.healthcentre.model.Patient;

import javax.swing.*;
import java.awt.*;

public class PatientPanel extends JPanel {

    private JTextField patientIdField;
    private JTextField studentIdField;
    private JTextField patientNameField;
    private JTextField patientTypeField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField bloodGroupField;
    private JTextField allergiesField;
    private JTextField emergencyContactField;

    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton clearButton;

    private PatientDAO patientDAO;

    public PatientPanel() {

        patientDAO = new PatientDAO();

        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(9, 2, 10, 10));

        patientIdField = new JTextField();
        studentIdField = new JTextField();
        patientNameField = new JTextField();
        patientTypeField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();
        bloodGroupField = new JTextField();
        allergiesField = new JTextField();
        emergencyContactField = new JTextField();

        formPanel.add(new JLabel("Patient ID:"));
        formPanel.add(patientIdField);

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Patient Name:"));
        formPanel.add(patientNameField);

        formPanel.add(new JLabel("Patient Type:"));
        formPanel.add(patientTypeField);

        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);

        formPanel.add(new JLabel("Gender:"));
        formPanel.add(genderField);

        formPanel.add(new JLabel("Blood Group:"));
        formPanel.add(bloodGroupField);

        formPanel.add(new JLabel("Known Allergies:"));
        formPanel.add(allergiesField);

        formPanel.add(new JLabel("Emergency Contact:"));
        formPanel.add(emergencyContactField);

        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(clearButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addPatient());
        updateButton.addActionListener(e -> updatePatient());
        deleteButton.addActionListener(e -> deletePatient());
        searchButton.addActionListener(e -> searchPatient());
        clearButton.addActionListener(e -> clearFields());
    }

    private Patient getPatientFromFields() {

        int patientId = Integer.parseInt(patientIdField.getText());
        String studentId = studentIdField.getText();
        String patientName = patientNameField.getText();
        String patientType = patientTypeField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        String bloodGroup = bloodGroupField.getText();
        String knownAllergies = allergiesField.getText();
        String emergencyContact = emergencyContactField.getText();

        return new Patient(
                patientId,
                studentId,
                patientName,
                patientType,
                age,
                gender,
                bloodGroup,
                knownAllergies,
                emergencyContact
        );
    }

    private void addPatient() {

        try {
```
