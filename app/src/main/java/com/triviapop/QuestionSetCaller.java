package com.triviapop;

import android.content.ContentValues;
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
    private static final int NUMBER_QUESTIONS_IN_QUIZ = 10;
    public QuestionSetCaller(Context context)
    {
        super(context, "QuestionSets.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase questionDB)
    {
        try
        {
            questionDB.execSQL("CREATE TABLE History_Questions(questID VARCHAR(8), question TEXT, answerID VARCHAR(8), factID VARCHAR(8), PRIMARY KEY (questID), FOREIGN KEY (answerID) REFERENCES History_Answers(answerID), FOREIGN KEY (factID) REFERENCES History_Facts(factID))");
            questionDB.execSQL("CREATE TABLE Entertainment_Questions(questID VARCHAR(8), question TEXT, answerID VARCHAR(8), factID VARCHAR(8), PRIMARY KEY (questID), FOREIGN KEY (answerID) REFERENCES Entertainment_Answers(answerID), FOREIGN KEY (factID) REFERENCES Entertainment_Facts(factID))");
            questionDB.execSQL("CREATE TABLE Science_Questions(questID VARCHAR(8), question TEXT, answerID VARCHAR(8), factID VARCHAR(8), PRIMARY KEY (questID), FOREIGN KEY (answerID) REFERENCES Science_Answers(answerID), FOREIGN KEY (factID) REFERENCES Science_Facts(factID))");

            questionDB.execSQL("CREATE TABLE History_Answers(answerID VARCHAR(8), answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");
            questionDB.execSQL("CREATE TABLE Entertainment_Answers(answerID VARCHAR(8), answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");
            questionDB.execSQL("CREATE TABLE Science_Answers(answerID VARCHAR(8), answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, correctAnswer TEXT, PRIMARY KEY(answerID))");

            questionDB.execSQL("CREATE TABLE History_Facts(factID VARCHAR(8), fact TEXT, PRIMARY KEY (factID))");
            questionDB.execSQL("CREATE TABLE Entertainment_Facts(factID VARCHAR(8), fact TEXT, PRIMARY KEY (factID))");
            questionDB.execSQL("CREATE TABLE Science_Facts(factID VARCHAR(8), fact TEXT, PRIMARY KEY (factID))");

            populateScienceTables(questionDB);
            populateHistoryTables(questionDB);
            populateEntertainmentTables(questionDB);
        }
        catch (SQLException sqle)
        {
            Log.e("ERROR", "Error in database creation");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase questionDB, int i, int i1)
    {
        Log.i("INFO", "db upgrade has been called");
        questionDB.execSQL("DROP TABLE History_Questions");
        questionDB.execSQL("DROP TABLE Entertainment_Questions");
        questionDB.execSQL("DROP TABLE Science_Questions");

        questionDB.execSQL("DROP TABLE History_Answers");
        questionDB.execSQL("DROP TABLE Entertainment_Answers");
        questionDB.execSQL("DROP TABLE Science_Answers");

        questionDB.execSQL("DROP TABLE History_Facts");
        questionDB.execSQL("DROP TABLE Entertainment_Facts");
        questionDB.execSQL("DROP TABLE Science_Facts");

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


        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //########################################################################      DATA FOR HISTORY_FACT IS INSERTED HERE    ################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        //##########################################################################################################################################################################################################
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                "VALUES('factTest', 'HELLO ARE YOU WORKING')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact1', 'The Battle of Agincourt marked a pivotal moment in the 100 Years War where King Henry V the king of England dealt a crushing blow to the French army. King Henry was named the heir to France in the Treaty of Troyes but would die before he would have a chance to claim that title. Eventually, disputes over the succession of France’s throne would lead to more war between France and England.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact2', 'While Nazi Germany began annexing neighboring nations as early as 1938 with the “Anschluss” of Austria, World War Two did not officially begin until the invasion of Poland in 1939. ')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact3', 'Christ the Redeemer Monument began construction in 1922 when the Brazilian Catholic Circle of Rio began garnering support for the construction of a monument atop Mount Corcovado')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact4', 'While the name of Russia’s 1917 Revolution is often referred to as the “October Revolution”, the revolution actually began in November of 1917')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact5', 'The Battle of Waterloo saw the nations of Prussia and England fighting against Napoleans French Army. While Russia was not one of the participants in the battle, French and Russian armies had clashed with each other just three years prior to the Battle of Waterloo during Napoleons invasion of Russia.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact6', 'NASA scientists were worried about the possibility of the Apollo 11 crew returning from the moon with germs never seen on Earth before. As a precaution, upon their return, the Astronauts had to immediately enter into a quarantine facility to ensure they were not contaminated with any pathogens.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact7', 'General Sherman began the military campaign on November 15th and would last until December 21st of 1864. During his march to Savannah, Sherman targeted military and industrial infrastructure with the intent to break the backbone of the economic and transportation capabilities of the Confederacy')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact8', 'The quote occurs in Act 5 of Shakespeare’s Richard III play after King Richards horse is killed in battle. During the play King Richard is willing to give anything in order to have a horse to aid him in his battle against his enemy Richmond.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact9', 'The Ptolemy dynasty includes historical figures such as the famous Egyptian Queen Cleopatra, who would also be the last queen of the Ptolemy bloodline.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact10', 'During the offensive, conquering the Belgian city of Antwerp was the intended objective in an effort to split and eliminate Allied forces on the Western Front and try to force them to negotiate on terms more favorable to the Axis powers.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact11', 'Signed into law in 1830, the “Indian Removal Act” would go on to displace the vast majority of Native Americans living East of the Mississippi River. Jackson and his administration would often times ignore the legal requirements of the bill, which led to thousands of Native Americans deaths during their forced resettlement westwards.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact12', 'The city of Constantinople was sacked in 1204 after leaders of the Fourth Crusade, for economic and political reasons, decided to lay siege to the city. The Crusader’s original destination was to topple the Egyptian Ayyubid Sultanate, the most powerful Muslim kingdom at the time, in order to try to reclaim the holy city of Jerusalem.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact13', 'New York was founded in 1624 originally being settled by the Dutch. They would name the colony New Amsterdam two years later. When the English took control of the area in 1664, the city was renamed to New York.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact14', 'NATO was established in 1949 after a devastated post-war Europe was recovering. The aim of the treaty was to provide economic relief and security from fascist or communist coups in recovering countries and to provide a means for a unified military response in case of invasion from the USSR in European countries.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact15', 'The explosion of Mount Vesuvius in 79 CE remains to be one of the most catastrophic volcanic eruptions of all time. To this day only about two-thirds of the city of Pompeii has been excavated by scientists.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact16', 'Einstein’s theory of relativity remains to be one of the most important discoveries in the field of physics to this day, and helped pave the way for new technologies such as GPS and new understandings of the universe with discoveries like gravitational waves.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact17', 'Despite having significantly superior military capabilities, the Soviet Union faced heavy casualties during the invasion, calling into question the capabilities of the Soviet military by Germany. Germany would go on to invade the USSR in 1941 during Operation Barbarossa.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact18', 'Sally Ride became the first female astronaut in 1983 when she entered space aboard the Space Shuttle Challenger. In her years after NASA, Sally Ride founded her own company called Sally Ride Science which aimed to help other women break into math and science fields that were largely dominated by men.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact19', 'While a very early version of what modern vehicles have become, this vehicle was patented and shown to the world in 1886 and was known as a Motorwagen. It would go on to become the first commercially available automobile in history in 1888.')"
                );
        questionDB.execSQL
                (
                        "INSERT INTO History_Facts(factID, fact)" +
                                " VALUES('fact20', 'Alan Turing’s breaking of the “Enigma Code” is considered to be a pivotal moment of history during World War Two and was a major contribution to the downfall of Axis powers. Sadly, Turing died in 1954 after a possible suicide just two years after the British government prosecuted him for being gay.')"
                );



    }

    private void populateEntertainmentTables(SQLiteDatabase questionDB)
    {
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest1', 'Out of the following films which one holds the title for most Oscar award wins?', 'answ1', 'fact1')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest2', 'As of 2021 how many Fast and the Furious films have been released?', 'answ2', 'fact2')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest3', 'In the 2016 film Arrival by Denis Villeneuve Amy Adams plays the role of Louise Banks. Louise Banks is a professor in what field?', 'answ3', 'fact3')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest4', 'In the series Breaking Bad Walter White takes on the alias of what famous physicist?', 'answ4', 'fact4')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest5', 'What was the name of The Beatles debut album?', 'answ5', 'fact5')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest6', 'What is the next line in this quote from Star Wars: Revenge of the Sith: So this is how liberty dies ____?', 'answ6', 'fact6')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest7', 'What is the name of the villain in the 1988 film Die Hard?', 'answ7', 'fact7')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest8', 'Who took on the role of the Joker in Christopher Nolan’s Batman film The Dark Knight?', 'answ8', 'fact8')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest9', 'What video game sci-fi series has the player face off against a galactic threat known as The Reapers?', 'answ9', 'fact9')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest10', 'What MMO (Massively Multiplayer Online) video game holds the record for having the highest number of players of all time?', 'answ10', 'fact10')");
        questionDB.execSQL("INSERT INTO Entertainment_Questions(questID, question, answerID, factID) " + "VALUES ('quest11', 'What actress that has a prominent role in the Marvel Cinematic Universe also had a brief career as a pop star when she was younger?', 'answ11', 'fact11')");

        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ1', 'Slumdog Millionaire', 'Gone with the Wind', 'Lord of the Rings: The Return of the King', 'The Last Emperor', 'Lord of the Rings: The Return of the King')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ2', '7', '8', '9', '10', '9')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ3', 'Linguistics', 'Biology', 'Physics', 'Chemistry', 'Linguistics')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ4', ' Einstein', 'Heisenberg', 'Tesla', 'Schrodinger', 'Heisenberg')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ5', ' With The Beatles', 'A Hard Days Night', 'Let It Be', 'Please Please Me', 'Please Please Me')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ6', ' within total darkness.', 'with thunderous applause.', 'and the senate dies with it.', 'with overwhelming applause', 'with thunderous applause.')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ7', 'Colonel William Stuart', 'Hans Gruber', ' Simon Gruber', ' Alec Trevelyan', 'Hans Gruber')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ8', ' Gary Oldman', 'Tom Hardy', 'Heath Ledger', 'Christian Bale', 'Heath Ledger')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ9', 'Dead Space', 'Mass Effect', 'Metroid Prime', 'Halo', 'Mass Effect')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ10', 'Elder Scrolls Online', 'Star Wars: The Old Republic', 'World of Warcraft', 'Eve Online', 'World of Warcraft')");
        questionDB.execSQL("INSERT INTO Entertainment_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ11', 'Brie Larson', ' Scarlett Johansson', 'Elizabeth Olsen', 'Zoe Saldana', 'Brie Larson')");

        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact1', 'The Lord of the Rings: The Return of the King was nominated for 11 Oscars and was the winner of all 11 nominations. It is currently tied with two other films that also hold 11 Oscar wins.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact2', 'The Fast and the Furious was released in 2001. Since then 8 additional films have been created with more productions planned. Short films and spin off movies have also been made. It is the 7th highest grossing film series of all time.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact3', 'Louise Banks was a professor in Linguistics when she is called in by the US military to try to communicate with mysterious aliens that had just arrived to Earth in pods around the world.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact4', 'Walter White takes on the alias of Heisenberg a famous physicist that is best known for his contributions to quantum mechanics and his discovery of the uncertainty principle')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact5', 'The Beatles released their debut album Please Please Me in 1963. Ten of Fourteen songs on the track were recorded in just a single day as the group tried to capitalize on their recent success in the releases of their second single that had reached number 1 on most UK music charts.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact6', 'The line of dialogue is said by Padme during the unveiling of Palpatines plans for a galactic empire.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact7', 'The role of Hans Gruber would be the first ever on-screen role for Alan Rickman. At the time Rickman had a background in theater and originally was not fond of the offer to play the role of Hans Gruber.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact8', 'Heath Ledger had originally been one of the first actors considered for the role of Batman in the first film in the trilogy. He and the director reportedly both agreed he was not the right fit for the role and would later be offered the role of the Joker in the second film of the trilogy.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact9', 'In Mass Effect The Reapers are an advanced ancient machine race that returns every 50 thousand years to eradicate life in the galaxy. Players take on the role of Commander Shepherd and are tasked with not only defeating the Reapers but convincing others that they actually even exist to begin with.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact10', 'Since 2004 when it launched World of Warcraft has seen 117655554 unique accounts throughout its lifetime. To this day World of Warcraft remains one of the most popular MMOs of all time.')");
        questionDB.execSQL("INSERT INTO Entertainment_Facts(factID, fact) " + "VALUES ('fact11', 'Brie Larson had a brief career as a pop star and released her debut album in 2005 titled Finally Out of P.E.')");
    }

    private void populateScienceTables(SQLiteDatabase questionDB)
    {
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest1', 'The layers of earth can be broken down into three categories: which of the following is NOT one of those categories?', 'answ1', 'fact1')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest2', 'Of the following stars which is the star that is the next closest star to Earth other than the Sun?', 'answ2', 'fact2')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest3', 'What is the powerhouse of the cell for most eukaryotic organisms?', 'answ3', 'fact3')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest4', 'Of the following which is the largest living animal on Earth in terms of weight?', 'answ4', 'fact4')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest5', 'What is the estimated age of the universe according to leading theories?', 'answ5', 'fact5')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest6', 'Which of the Newton Laws of Motion would describe the phenomenon of: A body at rest will remain at rest and a body in motion at a constant velocity will remain in motion in a straight line unless acted upon by an outside force?', 'answ6', 'fact6')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest7', 'What is the name of the mysterious force that is believed to be the reason that the expansion of the universe is accelerating and makes up approximately 68% of the universe?', 'answ7', 'fact7')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest8', 'What is the element symbol for silver on the periodic table of elements?', 'answ8', 'fact8')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest9', 'What was the name of the last supercontinent that formed on Earth?', 'answ9', 'fact9')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest10', 'Out of the following: which of these is NOT one of the layers of Earths atmosphere?', 'answ10', 'fact10')");
        questionDB.execSQL("INSERT INTO Science_Questions(questID, question, answerID, factID) " + "VALUES ('quest11', 'In computing what does CPU stand for?', 'answ11', 'fact11')");

        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ1', 'The Core layers', 'The Mantle layers', 'The Crust layers', 'The Magma layers', 'The Magma layers')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ2', 'Proxima Centauri', 'Barnards Star', 'Sirius', 'Wolf 359', 'Proxima Centauri')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ3', 'The nucleolus', 'The mitochondria', 'The cytoplasm', 'The endoplasmic reticulum.', 'The mitochondria')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ4', ' Giraffe', 'Rhino', 'Elephant', 'Hippopotamus', 'Elephant')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ5', '12.2 billion years old', '940.7 million years old', '6000', '13.8 billion years old', '13.8 billion years old')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ6', 'Newtons 1st Law of Motion', ' Newtons 2nd Law of Motion', 'Newtons 3rd Law of Motion', 'Newtons 4th Law of Motion', 'Newtons 1st Law of Motion')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ7', ' The Strong Nuclear Force', ' Electromagnetism', 'Dark Energy', 'Gravity', 'Dark Energy')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ8', 'Si', 'Zr', 'Ag', 'Sr', 'Ag')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ9', 'Laurasia', 'UR', 'Pangaea', 'Euroamerica', 'Pangaea')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ10', 'Troposphere', 'Thermosphere', 'Lithosphere', 'Lithosphere', 'Lithosphere')");
        questionDB.execSQL("INSERT INTO Science_Answers(answerID, answerA, answerB, answerC, answerD, correctAnswer) " + "VALUES('answ11', 'Central Power Unit', 'Central Processing Unit', 'Core Power Unit', 'Common Processing Unit', 'Central Processing Unit')");

        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact1', 'While much of the layer that makes up the Earths mantle consist of magma there is not a layer that is referred to as the Magma Layers. The magma from the Earths mantle can be pushed through holes and cracks in the Earths crust which can lead to volcanic eruptions.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact2', 'At 4.246 light years away Proxima Centauri was discovered in 1915 and resides in a triple star system called Alpha Centauri. Using the current fastest human made object in space that moves at a speed of 250000kmh. It would still take thousands of years to arrive at Proxima Centauri')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact3', 'The mitochondria is responsible for releasing energy from food that an organism consumes in a process known as cellular respiration. This process produces the majority of a cells access to chemical energy in an organism leading to it commonly being referred to as the powerhouse of the cell')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact4', 'Elephants are the largest living land animal on the planet. The African Bush Elephant can weigh up to  17600 lbs. Elephants are also exceptionally intelligent animals and have been observed displaying signs of complex emotions such as grief and compassion and have been seen using tools exhibit signs of self-awareness and can possibly even understand non-verbal communication.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact5', 'Leading theories have measured the age of the universe using observations from cosmic microwave background radiation which is a form of cosmic noise that is leftover radiation from the Big Bang. Interestingly some of the static that you would see on old analog TVs when not tuned to a channel comes from this cosmic background radiation as the TV tries to obtain a radio signal.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact6', 'Newtons Laws of Motion along with his other works in Calculus and Gravity were published in his book The Principia Mathematic in 1687. To date the discoveries and advancements in science and math made by Newton continue to be one of the most revolutionary works there is and has helped lead to countless other discoveries. Growing up his mother had hoped he would be a farmer.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact7', 'While dark energy continues to elude detection by scientists it is hypothesized that Dark Energy would make up the 5th fundamental force of nature and could give answers about questions that involve the expansion of the universe. It is estimated that roughly 68% of the universe is comprised of Dark Energy 27% is Dark Matter, and less than 5% accounts for all other observable matter and energy such as stars/ planets and gravitational forces in the Cosmos.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact8', 'While Ag might appear to have no relation to the element it is a symbol for at first glance Ag is actually short for argentums which is the Latin word for silver.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact9', 'The last supercontinent to form on Earth existed approximately 200-300 million years ago. The next supercontinent to form will see Asia and the Americas joined together in its earliest stages forming the new supercontinent Amasia. Throughout time Earth has formed seven supercontinents.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact10', 'The Lithosphere is apart of Earths outermost shell that is made up of Earths crust and the upper mantle. There are multiple layers that make up Earths atmosphere. The other layers of the atmosphere include the Mesosphere and Exosphere.')");
        questionDB.execSQL("INSERT INTO Science_Facts(factID, fact) " + "VALUES ('fact11', 'In 1974 the Intel 4004 became the worlds first micro processing unit and was capable of processing 92600 instruction per minute. Today consumer CPUs are capable of processing more than 3000000000 instructions per second. With new discoveries and technologies in Quantum Computing the speed at which computers can process commands could once again be on the verge of increasing significantly.')");
    }

    public LinkedList<QuestionSet> getQuestionSet(String tablePrefix)
    {
        Question question;
        AnswerSet answerSet;
        Fact fact;
        QuestionSet questionSetData;
        LinkedList<QuestionSet> quizSet = new LinkedList<>();

        SQLiteDatabase dbHelper = this.getReadableDatabase();
        String TABLE_NAME = tablePrefix + "_Questions";

        Log.d("DEBUG", "TABLE IS: " + tablePrefix);
        try
        {
            Cursor query = dbHelper.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY RANDOM() LIMIT 10", null);
            query.moveToFirst();
            Log.d("DEBUG", "QUERY SIZE: " + query.getCount());
            String[] answerOptions;
            String answerID;
            for(int i = 0; i < NUMBER_QUESTIONS_IN_QUIZ; i++)
            {
                //This is the question text
                question = new Question(query.getString(1));
                Log.d("DEBUG", "Question pulled is: " + query.getString(1));
                Log.d("DEBUG", "Question count is: " + i);
                //This is the primary key for the answers table
                answerID = query.getString(2);
                //Perform a query on the answer table and returns a string[]
                answerOptions = getAnswersFromTable(dbHelper,tablePrefix+"_Answers", answerID);
                answerSet = new AnswerSet(answerOptions);
                //This is the primary key for the fact table
                String factID = query.getString(3);
                //Performs a query on the fact table and returns a string
                String factText = getFactFromTable(dbHelper,tablePrefix+"_Facts", factID);
                fact = new Fact(factText);
                //creates a QuestionSet object from the queries returned data
                questionSetData = new QuestionSet(question, answerSet, fact);
                //Adds the QuestionSet to the HashMap
                quizSet.addLast(questionSetData);
                //Move to the next row within
                query.moveToNext();
            }
            query.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

        Log.d("DEBUG", "RANDOM QUERY COMPLETED SUCCESSFULLY");
        return quizSet;
    }

    private String getFactFromTable(SQLiteDatabase dbHelper, String TABLE_NAME, String id)
    {
        Log.i("INFO", "searching for facts...");
        Cursor query = null;
        try {
            query = dbHelper.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE factID='" + id + "'", null);
            Log.d("DEBUG", "facts queried successfully");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            Log.e("ERROR", "facts query failed");
        }
        Log.d("DEBUG", "Column count is: " + query.getColumnCount());
        query.moveToFirst();
        String fact = query.getString(1);
        query.close();

        return fact;
    }


    private String[] getAnswersFromTable(SQLiteDatabase dbHelper, String TABLE_NAME, String id)
    {
        Log.i("INFO", "ENTERED getAnswersFromTable()");
        Cursor query = null;
        try
        {
            query = dbHelper.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE answerID='" + id + "'", null);
            Log.d("DEBUG", "answers queried successfully");
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            Log.e("ERROR", "answers query failed");
        }
        Log.d("DEBUG", "Column count is: " + query.getColumnCount());
        query.moveToFirst();
        String answerA = query.getString(1);
        String answerB = query.getString(2);
        String answerC = query.getString(3);
        String answerD = query.getString(4);
        String correctAnswer = query.getString(5);
        query.close();

        return new String[]{answerA, answerB, answerC, answerD, correctAnswer};
    }
}
