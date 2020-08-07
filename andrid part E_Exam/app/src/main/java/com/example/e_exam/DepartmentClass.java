package com.example.e_exam;

public class DepartmentClass {

    private  String key;
    private  String facultyUsername;
    private  String levelKey;
    private  String departmentName;
private  String levelName;
    public DepartmentClass() {
    }

    public DepartmentClass(String key, String facultyUsername, String levelKey, String departmentName, String levelName) {
        this.key = key;
        this.facultyUsername = facultyUsername;
        this.levelKey = levelKey;
        this.departmentName = departmentName;
        this.levelName = levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFacultyUsername(String facultyUsername) {
        this.facultyUsername = facultyUsername;
    }

    public void setLevelKey(String levelKey) {
        this.levelKey = levelKey;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getKey() {
        return key;
    }

    public String getFacultyUsername() {
        return facultyUsername;
    }

    public String getLevelKey() {
        return levelKey;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
