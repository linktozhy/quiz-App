package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    TextView questionText;
    Button tButton;
    Button fButton;
    ProgressBar developmentBar;
    boolean done = false;
    int questionIndex = 0;
    TrueFalseQuestion questionBank[];
    int attemptNumber = 0;
    AlertDialog.Builder builder;
    int score = 0;
    int allAttempts[] = new int[10];
    QuestionBank bank;
    int totalQuestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = (TextView) findViewById(R.id.question);
        tButton = (Button) findViewById(R.id.trueButton);
        fButton = (Button) findViewById(R.id.falseButton);
        developmentBar = (ProgressBar)findViewById(R.id.progressBar);
        bank = new QuestionBank();
        developmentBar.setMax(bank.getQuestionBankSize());
        builder = new AlertDialog.Builder(this);
        totalQuestionNumber = bank.getQuestionBankSize();


        questionText.setText(R.string.question1);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (bank.checkAnswer(questionIndex)){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        score++;
                    }else {
                        Toast.makeText(getApplicationContext(),"inCorrect",Toast.LENGTH_SHORT).show();
                    }
                    questionIndex++;
                    if (totalQuestionNumber == questionIndex) {
                        done = true;
                        developmentBar.setProgress(questionIndex);
                        report();
                    }
                    else {
                        done = false;
                        developmentBar.setProgress(questionIndex);
                        questionText.setText(bank.getNextQuestion(questionIndex));
                    }

            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (!bank.checkAnswer(questionIndex)){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        score++;
                    }else {
                        Toast.makeText(getApplicationContext(),"inCorrect",Toast.LENGTH_SHORT).show();
                    }
                    questionIndex++;
                    if (totalQuestionNumber == questionIndex) {
                        done = true;
                        developmentBar.setProgress(questionIndex);
                        report();
                    }

                    else {
                        done = false;
                        developmentBar.setProgress(questionIndex);
                        questionText.setText(bank.getNextQuestion(questionIndex));
                    }
                
            }
        });
    }


public void report (){
    builder.setMessage("Your Score is: " + score + " out of "+bank.getQuestionBankSize())
            .setPositiveButton("Repeat", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    done=false;
                    questionIndex = 0;
                    score = 0;
                    developmentBar.setProgress(0);
                    bank.shuffle();
                    questionText.setText(bank.getNextQuestion(questionIndex));
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            allAttempts[attemptNumber] = score;
            attemptNumber++;
            done=false;
            questionIndex = 0;
            score = 0;
            developmentBar.setProgress(0);
        }
    });
    AlertDialog alert = builder.create();
    alert.setTitle("Result");
    alert.show();

}


}
