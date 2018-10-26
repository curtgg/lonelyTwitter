package ca.ualberta.cs.lonelytwitter;


public class TweetTooLongException extends Exception {
    TweetTooLongException(){
        super("Tweet longer than 140 chars");
    }
}
