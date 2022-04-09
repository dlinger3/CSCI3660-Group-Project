package com.triviapop.questProcessing;

import androidx.annotation.NonNull;

import com.triviapop.QuestionSetCaller;

public class QuestionSet
{
    private Question question;
    private AnswerSet answers;
    private Fact fact;

    public QuestionSet(Question ques, AnswerSet answers, Fact fact)
    {
        this.question = ques;
        this.answers = answers;
        this.fact = fact;
    }

    @NonNull
    public String getQuestion()
    {
        return question.toString();
    }

    public AnswerSet getAnswerSet()
    {
        return answers;
    }

    public String getFact()
    {
        return fact.toString();
    }
}
