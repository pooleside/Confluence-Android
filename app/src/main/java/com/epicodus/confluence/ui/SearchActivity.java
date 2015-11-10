package com.epicodus.confluence.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.confluence.R;
import com.epicodus.confluence.adapters.TweetAdapter;
import com.epicodus.confluence.models.Tag;
import com.epicodus.confluence.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends ListActivity {

    private EditText mSearchText;
    private Button mSearchButton;
    private TextView mEmptyText;
    private TweetAdapter mAdapter;
    private ArrayList<Tweet> mTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchText = (EditText) findViewById(R.id.searchText);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mEmptyText = (TextView) findViewById(android.R.id.empty);
        mTweets = new ArrayList<>();
        mAdapter = new TweetAdapter(this, mTweets);
        setListAdapter(mAdapter);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = "#" + mSearchText.getText().toString();
                Tag hashtag = Tag.find(tag);

                if (hashtag == null ){
                    Toast.makeText(SearchActivity.this, mSearchText.getText().toString() + " not found", Toast.LENGTH_LONG).show();
                    mSearchText.setText("");

                }else {
                    mTweets.clear();
                    List<Tweet> tweetsToAdd = hashtag.getTweets();
                    for(Tweet tweet : tweetsToAdd){
                        mTweets.add(tweet);
                    }
                    mAdapter.notifyDataSetChanged();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
