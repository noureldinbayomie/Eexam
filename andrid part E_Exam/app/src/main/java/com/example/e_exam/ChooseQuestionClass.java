package com.example.e_exam;

public class ChooseQuestionClass {

    private String key;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String correctAnswer;
    private String category;
    private String chapterKey;
    private String SubjectKey;
    private String questionNumber;


    public ChooseQuestionClass() {
    }

    public ChooseQuestionClass(String key, String question, String a, String b, String c, String d, String correctAnswer, String category, String chapterKey, String subjectKey, String questionNumber) {
        this.key = key;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.chapterKey = chapterKey;
        SubjectKey = subjectKey;
        this.questionNumber = questionNumber;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setChapterKey(String chapterKey) {
        this.chapterKey = chapterKey;
    }

    public void setSubjectKey(String subjectKey) {
        SubjectKey = subjectKey;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getKey() {
        return key;
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getChapterKey() {
        return chapterKey;
    }

    public String getSubjectKey() {
        return SubjectKey;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }
}
