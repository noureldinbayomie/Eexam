package com.example.e_exam;

public class LevelClass {
    private  String key;
    private  String facultyUsername;
    private  String levelName;


    public LevelClass() {
    }

    public LevelClass(String key, String facultyUsername, String levelName) {
        this.key = key;
        this.facultyUsername = facultyUsername;
        this.levelName = levelName;
    }


    public String getKey() {
        return key;
    }

    public String getFacultyUsername() {
        return facultyUsername;
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

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
