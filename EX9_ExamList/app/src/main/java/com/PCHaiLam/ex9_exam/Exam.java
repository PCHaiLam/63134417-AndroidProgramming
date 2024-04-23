package com.PCHaiLam.ex9_exam;

public class Exam {
    private String name;
    private String date;
    private String cmt;

    public Exam(String name, String date, String cmt) {
        this.name = name;
        this.date = date;
        this.cmt = cmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
}
