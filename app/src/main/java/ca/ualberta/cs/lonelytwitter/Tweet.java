package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private final static Integer MAX_CHARS=140;
    private ArrayList<Mood> moods = new ArrayList<Mood>();

    Tweet(){
        this.date = new Date();
        this.message = "default message";
    }

    Tweet(String msg){
        this.date = new Date();
        this.message = msg;
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate() {return this.date;}

    public void setMessage(String msg) throws TweetTooLongException {
        if(msg.length() > MAX_CHARS){
            throw new TweetTooLongException();
        }else{
            this.message = msg;
        }
    }

    public String toString(){
        return this.message + " | " + this.date;
    }

    protected void addMood(Mood mood){
        this.moods.add(mood);
    }

    public abstract Boolean isImportant();
}
