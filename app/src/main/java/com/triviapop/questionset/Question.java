package com.triviapop.questionset;

import androidx.annotation.NonNull;

public class Question
{
    String question;

    public Question(String question)
    {
        this.question = question;
    }

//    public String getQuestion()
//    {
//        return question;
//    }

    @NonNull
    @Override
    public String toString()
    {
        return question;
    }
}
