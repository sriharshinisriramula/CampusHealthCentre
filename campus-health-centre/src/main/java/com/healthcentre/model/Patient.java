
package com.healthcentre.model;

public class Patient {

    private int patientId;
    private String studentId;
    private String patientName;
    private String patientType;
    private int age;
    private String gender;
    private String bloodGroup;
    private String knownAllergies;
    private String emergencyContact;

    public Patient() {

    }

    public Patient(int patientId, String studentId, String patientName,
                   String patientType, int age, String gender,
                   String bloodGroup, String knownAllergies,
                   String emergencyContact) {

        this.patientId = patientId;
        this.studentId = studentId;
        this.patientName = patientName;
        this.patientType = patientType;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.knownAllergies = knownAllergies;
        this.emergencyContact = emergencyContact;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
```
