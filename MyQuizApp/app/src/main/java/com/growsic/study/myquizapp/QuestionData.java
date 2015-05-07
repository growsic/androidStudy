package com.growsic.study.myquizapp;

/**
 * Created by a13918 on 2015/05/07.
 */
public class QuestionData {
    private String mDescription;
    private String[] mChoices;
    private String mAnswer;
    private String mCommentary;

    public QuestionData(String description, String[] choices, String answer, String commentary) {
        this.mDescription = description;
        this.mChoices = choices;
        this.mAnswer = answer;
        this.mCommentary = commentary;

    }

    public String getDescription() {
        return mDescription;
    }

    public String[] getmChoices() {
        return mChoices;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public String getCommentary() {
        return mCommentary;
    }
}
