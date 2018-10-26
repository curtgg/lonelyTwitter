package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

<<<<<<< HEAD
public class LonelyTwitterActivity extends Activity {
=======
public class LonelyTwitterActivity extends Activity implements PopupMenu.OnMenuItemClickListener {
>>>>>>> master

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
<<<<<<< HEAD
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

=======
	private ArrayList<Mood> moodList = new ArrayList<Mood>();
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> listAdapter;

    /** Called when the activity is first created. */
>>>>>>> master
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button moodButton = (Button) findViewById(R.id.moodButton);
		Button clearButton = (Button) findViewById(R.id.clear);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) { //Set listener
				String text = bodyText.getText().toString();
<<<<<<< HEAD
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
=======
				try{
					ImportantTweet newTweet = new ImportantTweet();
					newTweet.setMessage(text);
					tweets.add(newTweet); //add new tweet to list
				} catch (TweetTooLongException e){
					Log.d("Exception", "Tweet too long"); //error
				}
				listAdapter.notifyDataSetChanged(); //notify
				saveInFile();//save
			}
		});

		moodButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				PopupMenu popup = new PopupMenu(LonelyTwitterActivity.this,v);
				popup.setOnMenuItemClickListener(LonelyTwitterActivity.this);
				MenuInflater inflater = popup.getMenuInflater();
				inflater.inflate(R.menu.menu,popup.getMenu());
				popup.show();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				deleteInFile();
				tweets.clear();
				listAdapter.notifyDataSetChanged();
>>>>>>> master
			}
		});
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
			case R.id.happyBtn:
				moodList.add(new Happy());//add mood
				return true;
			case R.id.sadBtn:
				moodList.add(new Sad());//add mood
				return true;
			default:
				return false;
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
<<<<<<< HEAD
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}


	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}


	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
=======
		listAdapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(listAdapter);
	}

	/*
	 *
	 *	Load from file
	 *
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type typeListTweets = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweets = gson.fromJson(reader, typeListTweets);
		} catch(Exception e){
			Log.d("Exception",e.toString());
		}
	}

	/*
	 * Save to file
	 */
	private void saveInFile() {

		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,osw);
			osw.flush();
			osw.close();
		} catch(Exception e){}
	}

	private void deleteInFile(){
		try {
			File dir = getFilesDir();
			File f = new File(dir, FILENAME);
			f.delete();//delete file
		} catch (Exception e){
			Log.d("exception", e.toString());
>>>>>>> master
		}
	}
}