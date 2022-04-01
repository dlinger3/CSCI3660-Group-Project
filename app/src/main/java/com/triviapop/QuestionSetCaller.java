package com.triviapop;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.triviapop.questProcessing.AnswerSet;
import com.triviapop.questProcessing.Fact;
import com.triviapop.questProcessing.Question;
import com.triviapop.questProcessing.QuestionSet;

import java.util.HashMap;
import java.util.LinkedList;

public class QuestionSetCaller extends SQLiteOpenHelper
{
    public QuestionSetCaller(Context context)
    {
        super(context, "QuestionSets.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase questionDB)
    {
        questionDB.execSQL("CREATE TABLE History_Questions(questID TEXT, question TEXT, answerID TEXT, factID TEXT, PRIMARY KEY (questID), FOREIGN KEY (answerID) REFERENCES History_Answers(answerID), FOREIGN KEY (factID) REFERENCES History_Facts(factID))");
        questionDB.execSQL("CREATE TABLE Entertainment_Questions(questID TEXT, question TEXT, answer_set_ID TEXT, factID TEXT, PRIMARY KEY (questID), FOREIGN KEY (answer_set_ID) REFERENCES Entertainment_Answers(answerID), FOREIGN KEY (factID) REFERENCES Entertainment_Facts(factID))");
        questionDB.execSQL("CREATE TABLE Science_Questions(questID TEXT, question TEXT, answerID TEXT, factID TEXT, PRIMARY KEY (questID), FOREIGN KEY (answerID) REFERENCES Science_Answers(answerID), FOREIGN KEY (factID) REFERENCES Science_Facts(factID))");

        questionDB.execSQL("CREATE TABLE History_Answers(answerID TEXT, answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");
        questionDB.execSQL("CREATE TABLE Entertainment_Answers(answerID TEXT, answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");
        questionDB.execSQL("CREATE TABLE Science_Answers(answerID TEXT, answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");

        questionDB.execSQL("CREATE TABLE History_Facts(factID TEXT, fact TEXT, PRIMARY KEY (factID))");
        questionDB.execSQL("CREATE TABLE Entertainment_Facts(factID TEXT, fact TEXT, PRIMARY KEY (factID))");
        questionDB.execSQL("CREATE TABLE Science_Facts(factID TEXT, fact TEXT, PRIMARY KEY (factID))");

        populateHistoryTables(questionDB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase questionDB, int i, int i1)
    {
        questionDB.execSQL("DROP TABLE IF EXISTS History_Questions");
        questionDB.execSQL("DROP TABLE IF EXISTS Entertainment_Questions");
        questionDB.execSQL("DROP TABLE IF EXISTS Science_Questions");

        questionDB.execSQL("DROP TABLE IF EXISTS History_Answers");
        questionDB.execSQL("DROP TABLE IF EXISTS Entertainment_Answers");
        questionDB.execSQL("DROP TABLE IF EXISTS Science_Answers");

        questionDB.execSQL("DROP TABLE IF EXISTS History_Facts");
        questionDB.execSQL("DROP TABLE IF EXISTS Entertainment_Facts");
        questionDB.execSQL("DROP TABLE IF EXISTS Science_Facts");

        onCreate(questionDB);
    }

    private void populateHistoryTables(SQLiteDatabase questionDB)
    {
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest1', 'How long was the 100 Years War?', 'answ1', 'fact1')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest2', 'In what year did the Second World War start?', 'answ2', 'fact2')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest3', 'Which of the following is NOT considered an ancient world wonder?', 'answ3', 'fact3')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest4', 'Which dynasty were the rulers of Russia during Russia’s 1917 “October Revolution”?', 'answ4', 'fact4')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest5', 'Which of the following nations were NOT one of the nations to participate in the Battle of Waterloo?', 'answ5', 'fact5')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest6', 'In what year did the first humans land on the Moon?', 'answ6', 'fact6')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest7', 'During the American Civil War, what Confederate state did the Union General William T. Sherman conduct his historical “Sherman’s March to the Sea”?', 'answ7', 'fact7')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest8', 'In what Shakespearean play would one hear the phrase, “A horse! A horse! My kingdom for a horse!”', 'answ8', 'fact8')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest9', 'The Ptolemy dynasty were rulers of which ancient kingdom?', 'answ9', 'fact9')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest10', 'In a last-ditch effort to win the war, what famous battle during World War Two was Nazi Germanys last major offensive?', 'answ10', 'fact10')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest11', 'Which US President signed into law the “Indian Removal Act” that would lead to the infamous “Trail of Tears”', 'answ11', 'fact11')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest12', 'During the Fourth Crusade, which city within the Byzantine Empire was sacked?', 'answ12', 'fact12')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest13', 'Prior to being named New York, what name did the US city hold?', 'answ13', 'fact13')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest14', 'What year was NATO established?', 'answ14', 'fact14')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest15', 'Which volcano erupted in 79 CE leading to the destruction of the city of Pompeii?', 'answ15', 'fact15')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest16', 'In 1905, which famous scientist published their work in the Annalen der Physik detailing their revolutionary discovery of special relativity.', 'answ16', 'fact16')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest17', 'In 1939 the Soviet Union invaded which country leading to the start of the Winter War?', 'answ17', 'fact17')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest18', 'Who was the first female American astronaut to go to space?', 'answ18', 'fact18')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest19', 'In what year did Carl Benz invent what is widely considered to be the world’s first automobile?', 'answ19', 'fact19')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Questions(questID, question, answerID, factID) " +
                                "VALUES ('quest20', 'Which famous mathematician and scientist is often considered to be the father of Computer Science and is most famous for breaking the “Enigma Code” during World War Two?', 'answ20', 'fact20')"
                );

        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //########################################################################      DATA FOR HISTORY_ANSWER IS INSERTED HERE    ################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################

        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ1', '100 years', '105 years', '116 years', '98 years', '116 years')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ2', '1938', '1939', '1940', '1941', '1939')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ3', 'The Colossus of Rhodes', 'The Hanging Gardens of Babylon', 'Christ the Redeemer Monument', 'The Great Pyramid of Giza', 'Christ the Redeemer Monument')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ4', 'The Rurik dynasty', 'The Donskoy dynasty', 'The Alexandrovich dynasty', 'The Romanov dynasty', 'The Romanov dynasty')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ5', 'England', 'France', 'Prussia', 'Russia', 'Russia')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ6', '1969', '1968', '1970', '1967', '1969')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ7', 'Alabama', 'Georgia', 'North Carolina', 'South Carolina', 'Georgia')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ8', 'Hamlet', 'Macbeth', 'Richard III', 'Henry V', 'Richard III')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ9', 'Rome', 'Persia', 'Egypt', 'Greece', 'Egypt')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ10', 'The Invasion of Normandy', 'The Battle of the Bulge', 'The Battle of Stalingrad', 'The Battle of Iwo Jima', 'The Battle of the Bulge')"
                );

        //TODO LEFT OFF BELOW THIS LINE
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ11', 'Andrew Jackson', 'Henry Harrison', 'John Quincy Adams', 'James Buchanan', 'Andrew Jackson')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ12', 'Thessalonica', 'Athens', 'Constantinople', 'Dyrrachium', 'Constantinople')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ13', 'New Amsterdam', 'New Whales', 'Saint Augustine', 'Albany', 'New Amsterdam')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ14', '1945', '1946', '1948', '1949', '1949')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ15', 'Mount Etna', 'Mount Amiata', 'Mount Sabatini', 'Mount Vesuvius', 'Mount Vesuvius')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ16', 'Werner Heisenberg', 'Nikola Tesla', 'Albert Einstein', 'Ernest Rutherford', 'Albert Einstein')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ17', 'Sweden', 'Norway', 'Finland', 'Poland', 'Finland')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ18', 'Kitty O’Brien Joyner', 'Sally Ride', 'Anna Lee Fisher', 'Mary Jackson', 'Sally Ride')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ19', '1902', '1891', '1901', '1885', '1885')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer)" +
                                "VALUES('answ20', 'Alan Turing', 'Howard Aiken', 'John Vincent Atanasoff', 'Konrad Zuse', 'Alan Turing')"
                );

    }

    private void populateEntertainmentTables(SQLiteDatabase questionDB)
    {
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
    }

    private void populateScienceTables(SQLiteDatabase questionDB)
    {
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
//        questionDB.execSQL("INSERT INTO ");
    }

    public HashMap<String, QuestionSet> getQuestionSet(String tablePrefix)
    {
        Question question;
        AnswerSet answerSet;
        Fact fact;
        QuestionSet questionSetData;
//        LinkedList<String> questionData = new LinkedList<>();
//        LinkedList<String[]> answerData = new LinkedList<>();
//        LinkedList<String> factData = new LinkedList<>();
        HashMap<String, QuestionSet> quizSet = new HashMap<>();

        SQLiteDatabase dbHelper = this.getReadableDatabase();
        String TABLE_NAME = tablePrefix + "_Questions";

        try
        {
            Cursor query = dbHelper.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY RAND() LIMIT 10", null);
            query.moveToFirst();
            String[] answerOptions;
            String answerID;
            for(int i = 0; i < 10; i++)
            {
                question = new Question(query.getString(1));
                answerID = query.getString(2);
                answerOptions = getAnswersFromTable(tablePrefix+"_Answers", answerID);
                answerSet = new AnswerSet(answerOptions);
                String factID = query.getString(3);
                String factText = getFactFromTable(tablePrefix+"_Facts", factID);
                fact = new Fact(factText);
                questionSetData = new QuestionSet(question, answerSet, fact);
                quizSet.put("Question " + (i+1), questionSetData);
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

        return quizSet;
    }

    private String getFactFromTable(String TABLE_NAME, String factID)
    {
        SQLiteDatabase dbHelper = this.getReadableDatabase();
        Cursor query = null;
        String factText = null;
        try
        {
            query = dbHelper.rawQuery("SELECT " + factID + " FROM " + TABLE_NAME, null);
            factText = query.getString(1);
            Log.i("DEBUG", TABLE_NAME + " queried successfully");
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            Log.i("ERROR", TABLE_NAME + " query failed");
        }
        return factText;
    }


    private String[] getAnswersFromTable(String TABLE_NAME, String answerID)
    {
        SQLiteDatabase dbHelper = this.getReadableDatabase();
        Cursor query = null;
        try
        {
            query = dbHelper.rawQuery("SELECT " + answerID + " FROM " + TABLE_NAME, null);
            Log.i("DEBUG", TABLE_NAME + " queried successfully");
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            Log.i("ERROR", TABLE_NAME + " query failed");
        }
        return new String[]{query.getString(1), query.getString(2), query.getString(3), query.getString(4), query.getString(5)};
    }
}
