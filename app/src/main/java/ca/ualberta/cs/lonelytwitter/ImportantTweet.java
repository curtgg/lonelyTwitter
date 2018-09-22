package ca.ualberta.cs.lonelytwitter;

public class ImportantTweet extends Tweet {

    ImportantTweet(){
        super();
    }

    ImportantTweet(String msg){
        super(msg);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}
