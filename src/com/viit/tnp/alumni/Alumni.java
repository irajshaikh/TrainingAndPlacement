package com.viit.tnp.alumni;

public class Alumni {

    private Integer candidateId;
    private Integer studentId;
    private String company;
    private String designation;
    private String pack;
    private Integer scheduleId;
    private String name;

    public Alumni(Integer c_id, String fname, String comp, String des, String packa, Integer sc_id, Integer stuID) {
        this.candidateId = c_id;
        this.company = comp;
        this.studentId = stuID;
        this.designation = des;
        this.pack = packa;
        this.scheduleId = sc_id;
        this.name = fname;

    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPackage() {
        return pack;
    }

    public void setPackage(String pack) {
        this.pack = pack;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
