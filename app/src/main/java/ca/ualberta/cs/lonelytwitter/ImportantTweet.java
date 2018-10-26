package ca.ualberta.cs.lonelytwitter;

<<<<<<< HEAD
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super(message);
=======
public class ImportantTweet extends Tweet {

    ImportantTweet(){
        super();
    }

    ImportantTweet(String msg){
        super(msg);
>>>>>>> master
    }

    @Override
    public Boolean isImportant(){
<<<<<<< HEAD
        return Boolean.TRUE;
    }


=======
        return true;
    }
>>>>>>> master
}
