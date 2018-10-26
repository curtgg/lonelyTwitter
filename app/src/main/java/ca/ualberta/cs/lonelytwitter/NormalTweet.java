package ca.ualberta.cs.lonelytwitter;

public class NormalTweet extends Tweet {

    NormalTweet(String msg){
        super(msg);
    }

    @Override
    public Boolean isImportant(){
        return false;
    }
}
