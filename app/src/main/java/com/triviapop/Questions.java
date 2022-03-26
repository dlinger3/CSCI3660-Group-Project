package com.triviapop;

public class Questions
{
    private String choiceA = "";
    private String choiceB = "";
    private String choiceC = "";
    private String choiceD = "";
    private String questionText = "";

    public Questions(String[] questionData)
    {
        questionText = questionData[0];
        choiceA = questionData[1];
        choiceB = questionData[2];
        choiceC = questionData[3];
        choiceD = questionData[4];
    }

    public String getQuestionText()
    {
        return this.questionText;
    }

    public String[] getAnswerArray()
    {
        return new String[]{choiceA, choiceB, choiceC, choiceD};

    }
}