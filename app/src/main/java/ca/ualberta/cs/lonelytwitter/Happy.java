package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    public Happy(){
        super();
    }

    //@Param Date dateTime - date of tweet
    public Happy(Date dateTime){
        super(dateTime);
    }

    public Date getDate(){
        return this._DateTime;
    }

    //@Param Date dateTime - new date of tweet
    public void setDate(Date dateTime){
        this._DateTime = dateTime;
    }

    //@Return String of mood
    public String formatMood(){
        return "Feeling really happy";
    }

}
