package com.example.myapplication.moodtracker;

import java.util.Date;

/**
 * Created by <VOTRE-NOM> on <DATE-DU-JOUR>.
 */
public class Mood {
    private Date registerDate = new Date();
    private String comment;
    private int moodState;

    /**
     * Mood  en int
     * 0 = triste
     * 1 = déçu
     * 2 = normal
     * 3 = heureux
     * 4 = super heureux
     *
     */


    public Mood(String comment, int moodState) {
        this.comment = comment;
        this.moodState = moodState;
        this.registerDate  = new Date();
    }

    public String getComment() {
        return comment;
    }

    public int getMoodState() {
        return moodState;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "comment='" + comment + ''' +
        ", moodState=" + moodState + ''' +
        "registerDate='" + registerDate.toString() + ''' +
        '}';
    }

}
