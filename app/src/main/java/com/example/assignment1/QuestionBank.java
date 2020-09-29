package com.example.assignment1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuestionBank {

   private ArrayList<TrueFalseQuestion> questions = new ArrayList<TrueFalseQuestion>();


    public QuestionBank(){
        TrueFalseQuestion question1 = new TrueFalseQuestion(R.string.question1,true);
        TrueFalseQuestion question2 = new TrueFalseQuestion(R.string.question2,false);
        TrueFalseQuestion question3 = new TrueFalseQuestion(R.string.question3,true);
        TrueFalseQuestion question4 = new TrueFalseQuestion(R.string.question4,false);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
    }

    public void shuffle(){
        Collections.shuffle(questions);

    }

    public int getQuestionBankSize(){
        return questions.size();
    }
    public int getNextQuestion(int index){
        return questions.get(index).question;
    }

    public boolean checkAnswer(int questionIndex){
        return questions.get(questionIndex).answer;
    }




}
