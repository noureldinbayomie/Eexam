package com.example.e_exam;

import java.lang.ref.SoftReference;

public class SubjectsClass {

    private  String key;
    private  String facultyUsername;
    private String name;
    private  String proName;
    private  String levelName;
    private String depName;

    public SubjectsClass() {
    }

    public SubjectsClass(String key, String facultyUsername, String name, String proName, String levelName, String depName) {
        this.key = key;
        this.facultyUsername = facultyUsername;
        this.name = name;
        this.proName = proName;
        this.levelName = levelName;
        this.depName = depName;
    }

    public String getKey() {
        return key;
    }

    public String getFacultyUsername() {
        return facultyUsername;
    }

    public String getName() {
        return name;
    }

    public String getProName() {
        return proName;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getDepName() {
        return depName;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public void setFacultyUsername(String facultyUsername) {
        this.facultyUsername = facultyUsername;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
