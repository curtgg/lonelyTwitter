package ca.ualberta.cs.lonelytwitter;

public class NormalTweet extends Tweet {

<<<<<<< HEAD
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
=======
    NormalTweet(){
        super();
    }

    NormalTweet(String msg){
        super(msg);
    }

    @Override
    public Boolean isImportant(){
        return false;
>>>>>>> master
    }
}
