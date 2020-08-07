package com.example.e_exam;

public class ChapterClass {
    private String key;
    private  String SubjectKey;
    private  String  chapterName;

    public ChapterClass() {
    }

    public ChapterClass(String key, String subjectKey, String chapterName) {
        this.key = key;
        SubjectKey = subjectKey;
        this.chapterName = chapterName;
    }

    public String getKey() {
        return key;
    }

    public String getSubjectKey() {
        return SubjectKey;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setSubjectKey(String subjectKey) {
        SubjectKey = subjectKey;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}
