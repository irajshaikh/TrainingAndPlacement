/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viit.tnp.student;

/**
 *
 * @author iraj
 */
public class Student {

    int studentId, marksFirstYear, marksSecondYear, marksThirdYear, isActive,
            departmentId, personId;
    String date;

    public Student(int marksFirstYear, int marksSecondYear, int marksThirdYear,
            int isActive, int departmentId, String date) {
        this.marksFirstYear = marksFirstYear;
        this.marksSecondYear = marksSecondYear;
        this.marksThirdYear = marksThirdYear;
        this.isActive = isActive;
        this.departmentId = departmentId;
        this.date = date;
    }

    public int getMarksFirstYear() {
        return marksFirstYear;
    }

    public void setMarksFirstYear(int marksFirstYear) {
        this.marksFirstYear = marksFirstYear;
    }

    public int getMarksSecondYear() {
        return marksSecondYear;
    }

    public void setMarksSecondYear(int marksSecondYear) {
        this.marksSecondYear = marksSecondYear;
    }

    public int getMarksThirdYear() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
