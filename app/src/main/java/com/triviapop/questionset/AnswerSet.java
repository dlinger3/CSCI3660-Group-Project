package com.triviapop.questionset;

public class AnswerSet
{
    String A, B, C, D, correctAnswer;

    public AnswerSet(String[] answerSet)
    {
        this.A = answerSet[0];
        this.B = answerSet[1];
        this.C = answerSet[2];
        this.D = answerSet[3];
        this.correctAnswer = answerSet[4];
    }

    public String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public String getC() {
        return C;
    }

    public String getD() {
        return D;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getAnswerArray()
    {
        return new String[]{getA(), getB(), getC(), getD(), getCorrectAnswer()};
    }
}
