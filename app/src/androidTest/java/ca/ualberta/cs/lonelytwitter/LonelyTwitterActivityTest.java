package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 * Edited by Cgoud for Lab 7
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity","LonelyTwitterActivity");
    }

    public void testAddTweet(){
        solo.enterText((EditText) solo.getView(R.id.body), "test add tweet"); // add text
        solo.clickOnButton("Save");//hit save
        solo.clearEditText((EditText) solo.getView(R.id.body)); // clear text
        assertTrue(solo.waitForText("test add tweet")); // check for new entry exists now
    }

    @Override
    public void setUp(){
        Activity activity = getActivity();
        solo = new Solo(getInstrumentation(),activity);
    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();
    }


}