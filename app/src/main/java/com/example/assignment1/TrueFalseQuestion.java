package com.example.assignment1;

public class TrueFalseQuestion {

    int question;
    boolean answer;

    TrueFalseQuestion(int q, Boolean a){
        question = q;
        answer = a;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
