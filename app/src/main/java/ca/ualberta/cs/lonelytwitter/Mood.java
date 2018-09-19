package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {

    protected Date _DateTime;

    protected Mood(){
        _DateTime = new Date();
    }

    protected Mood(Date date){
        _DateTime = date;
    }

    public abstract Date getDate();

    public abstract void setDate(Date date);

    public abstract String formatMood();

}
