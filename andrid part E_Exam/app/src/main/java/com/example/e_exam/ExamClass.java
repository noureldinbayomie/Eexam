package com.example.e_exam;

public class ExamClass {
    private String key;
    private String subjectKey;
    private String examTime;
    private String numberOfQuestion;
    private String numberOfChooseQuestion;
    private String numberOfTrueQuestion;
    private String numberOfQuestionCategoryA;
    private String numberOfQuestionCategoryB;
    private String numberOfQuestionCategoryC;


    public ExamClass() {
    }


    public ExamClass(String key, String subjectKey, String examTime, String numberOfQuestion, String numberOfChooseQuestion, String numberOfTrueQuestion, String numberOfQuestionCategoryA, String numberOfQuestionCategoryB, String numberOfQuestionCategoryC) {
        this.key = key;
        this.subjectKey = subjectKey;
        this.examTime = examTime;
        this.numberOfQuestion = numberOfQuestion;
        this.numberOfChooseQuestion = numberOfChooseQuestion;
        this.numberOfTrueQuestion = numberOfTrueQuestion;
        this.numberOfQuestionCategoryA = numberOfQuestionCategoryA;
        this.numberOfQuestionCategoryB = numberOfQuestionCategoryB;
        this.numberOfQuestionCategoryC = numberOfQuestionCategoryC;
    }

    public String getKey() {
        return key;
    }

    public String getSubjectKey() {
        return subjectKey;
    }

    public String getExamTime() {
        return examTime;
    }

    public String getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public String getNumberOfChooseQuestion() {
        return numberOfChooseQuestion;
    }

    public String getNumberOfTrueQuestion() {
        return numberOfTrueQuestion;
    }

    public String getNumberOfQuestionCategoryA() {
        return numberOfQuestionCategoryA;
    }

    public String getNumberOfQuestionCategoryB() {
        return numberOfQuestionCategoryB;
    }

    public String getNumberOfQuestionCategoryC() {
        return numberOfQuestionCategoryC;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setSubjectKey(String subjectKey) {
        this.subjectKey = subjectKey;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public void setNumberOfQuestion(String numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public void setNumberOfChooseQuestion(String numberOfChooseQuestion) {
        this.numberOfChooseQuestion = numberOfChooseQuestion;
    }

    public void setNumberOfTrueQuestion(String numberOfTrueQuestion) {
        this.numberOfTrueQuestion = numberOfTrueQuestion;
    }

    public void setNumberOfQuestionCategoryA(String numberOfQuestionCategoryA) {
        this.numberOfQuestionCategoryA = numberOfQuestionCategoryA;
    }

    public void setNumberOfQuestionCategoryB(String numberOfQuestionCategoryB) {
        this.numberOfQuestionCategoryB = numberOfQuestionCategoryB;
    }

    public void setNumberOfQuestionCategoryC(String numberOfQuestionCategoryC) {
        this.numberOfQuestionCategoryC = numberOfQuestionCategoryC;
    }
}
