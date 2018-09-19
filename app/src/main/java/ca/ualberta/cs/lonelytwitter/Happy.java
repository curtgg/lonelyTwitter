package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    public Happy(){
        super();
    }

    public Happy(Date dateTime){
        super(dateTime);
    }

    public Date getDate(){
        return this._DateTime;
    }

    public void setDate(Date dateTime){
        this._DateTime = dateTime;
    }

    public String formatMood(){
        return "Feeling really happy";
    }

}
