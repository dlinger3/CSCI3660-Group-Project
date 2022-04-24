package com.triviapop.questionset;

import androidx.annotation.NonNull;

public class Fact
{
    String fact;

    public Fact(String fact)
    {
        this.fact = fact;
    }

//    public String getFact()
//    {
//        return fact;
//    }

    @NonNull
    @Override
    public String toString()
    {
        return fact;
    }
}
