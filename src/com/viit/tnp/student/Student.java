/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.student;

public class Student {

    int studentId, isActive, departmentId, personId;
    float  marksFirstYear, marksSecondYear, marksThirdYear;
    String username, firstName;
    int academicYear;

    public Student(int personId, float marksFirstYear, float marksSecondYear, float marksThirdYear,
            int isActive, int departmentId, int date) {
        this.personId = personId;
        this.marksFirstYear = marksFirstYear;
        this.marksSecondYear = marksSecondYear;
        this.marksThirdYear = marksThirdYear;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.academicYear = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Student(float marksFirstYear, float marksSecondYear, float marksThirdYear,
            int isActive, int departmentId, int date) {
        this.marksFirstYear = marksFirstYear;
        this.marksSecondYear = marksSecondYear;
        this.marksThirdYear = marksThirdYear;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.academicYear = date;
    }

    public Student() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getMarksFirstYear() {
        return marksFirstYear;
    }

    public void setMarksFirstYear(int marksFirstYear) {
        this.marksFirstYear = marksFirstYear;
    }

    public float getMarksSecondYear() {
        return marksSecondYear;
    }

    public void setMarksSecondYear(int marksSecondYear) {
        this.marksSecondYear = marksSecondYear;
    }

    public float getMarksThirdYear() {
        return marksThirdYear;
    }

    public void setMarksThirdYear(int marksThirdYear) {
        this.marksThirdYear = marksThirdYear;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

}
