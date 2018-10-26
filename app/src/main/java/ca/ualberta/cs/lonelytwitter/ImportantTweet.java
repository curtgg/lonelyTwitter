package ca.ualberta.cs.lonelytwitter;

public class ImportantTweet extends Tweet {
    ImportantTweet(String msg){
        super(msg);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
