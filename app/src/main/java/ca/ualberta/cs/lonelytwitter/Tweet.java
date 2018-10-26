package ca.ualberta.cs.lonelytwitter;

<<<<<<< HEAD
import java.util.Date;

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return message;
    }

    public abstract Boolean isImportant();


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
=======
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
>>>>>>> master
}
