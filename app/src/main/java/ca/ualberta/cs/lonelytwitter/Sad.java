package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    public Sad(){
        super();
    }

    public Sad(Date dateTime){
        super(dateTime);
    }

    public Date getDate(){
        return this._DateTime;
    }

    public void setDate(Date dateTime){
        this._DateTime = dateTime;
    }

    public String formatMood(){
        return "Feeling really sad";
    }

}