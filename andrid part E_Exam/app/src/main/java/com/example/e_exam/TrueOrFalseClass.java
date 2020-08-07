package com.example.e_exam;

public class TrueOrFalseClass {


    private String key;
    private String question;
    private String correctAnswer;
    private String category;
    private String chapterKey;
    private String SubjectKey;
    private String questionNumber;

    public TrueOrFalseClass() {
    }

    public TrueOrFalseClass(String key, String question, String correctAnswer, String category, String chapterKey, String subjectKey, String questionNumber) {
        this.key = key;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.chapterKey = chapterKey;
        SubjectKey = subjectKey;
        this.questionNumber = questionNumber;
    }

    public String getKey() {
        return key;
    }

    public String getQuestion() {
        return question;
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

    public void setKey(String key) {
        this.key = key;
    }

    public void setQuestion(String question) {
        this.question = question;
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
}
