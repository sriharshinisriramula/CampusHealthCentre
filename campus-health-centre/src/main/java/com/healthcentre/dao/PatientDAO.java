
package com.healthcentre.dao;

import com.healthcentre.DBConnection;
import com.healthcentre.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO PATIENT " +
                "(PATIENT_ID, STUDENT_ID, PATIENT_NAME, PATIENT_TYPE, AGE, " +
                "GENDER, BLOOD_GROUP, KNOWN_ALLERGIES, EMERGENCY_CONTACT) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, patient.getPatientId());
            statement.setString(2, patient.getStudentId());
            statement.setString(3, patient.getPatientName());
            statement.setString(4, patient.getPatientType());
            statement.setInt(5, patient.getAge());
            statement.setString(6, patient.getGender());
            statement.setString(7, patient.getBloodGroup());
            statement.setString(8, patient.getKnownAllergies());
            statement.setString(9, patient.getEmergencyContact());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE PATIENT SET " +
                "STUDENT_ID = ?, " +
                "PATIENT_NAME = ?, " +
                "PATIENT_TYPE = ?, " +
                "AGE = ?, " +
                "GENDER = ?, " +
                "BLOOD_GROUP = ?, " +
                "KNOWN_ALLERGIES = ?, " +
                "EMERGENCY_CONTACT = ? " +
                "WHERE PATIENT_ID = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patient.getStudentId());
            statement.setString(2, patient.getPatientName());
            statement.setString(3, patient.getPatientType());
            statement.setInt(4, patient.getAge());
            statement.setString(5, patient.getGender());
            statement.setString(6, patient.getBloodGroup());
            statement.setString(7, patient.getKnownAllergies());
            statement.setString(8, patient.getEmergencyContact());
            statement.setInt(9, patient.getPatientId());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM PATIENT WHERE PATIENT_ID = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, patientId);

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public Patient getPatientById(int patientId) {

        String sql = "SELECT * FROM PATIENT WHERE PATIENT_ID = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new Patient(
                        resultSet.getInt("PATIENT_ID"),
                        resultSet.getString("STUDENT_ID"),
                        resultSet.getString("PATIENT_NAME"),
                        resultSet.getString("PATIENT_TYPE"),
                        resultSet.getInt("AGE"),
                        resultSet.getString("GENDER"),
                        resultSet.getString("BLOOD_GROUP"),
                        resultSet.getString("KNOWN_ALLERGIES"),
                        resultSet.getString("EMERGENCY_CONTACT")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM PATIENT ORDER BY PATIENT_ID";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Patient patient = new Patient(
                        resultSet.getInt("PATIENT_ID"),
                        resultSet.getString("STUDENT_ID"),
                        resultSet.getString("PATIENT_NAME"),
                        resultSet.getString("PATIENT_TYPE"),
                        resultSet.getInt("AGE"),
                        resultSet.getString("GENDER"),
                        resultSet.getString("BLOOD_GROUP"),
                        resultSet.getString("KNOWN_ALLERGIES"),
                        resultSet.getString("EMERGENCY_CONTACT")
                );

                patients.add(patient);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return patients;
    }
}
```
