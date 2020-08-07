package com.example.e_exam;

public class ProfessorClass {

    private String username;
    private String nickname;
    private  String email;
    private String  password;
    private  String faculty;

    public ProfessorClass() {
    }


    public ProfessorClass(String username, String nickname, String email, String password, String faculty) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.faculty = faculty;
    }


    public String getFaculty() {
        return faculty;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
