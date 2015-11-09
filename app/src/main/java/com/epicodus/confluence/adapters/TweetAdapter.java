package com.epicodus.confluence.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.confluence.R;
import com.epicodus.confluence.models.Tweet;


import java.util.ArrayList;

/**
 * Created by lesliepoole on 11/8/15.
 */
public class TweetAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Tweet> mTweets;

    public TweetAdapter(Context context, ArrayList<Tweet> tweets) {
        mTweets = tweets;
        mContext = context;
    }

    //method looking for size of the collection-how many layouts to inflate
    @Override
    public int getCount() {
        return mTweets.size();
    }
    //method to find the tweet object at a specific position
    @Override
    public Object getItem(int position) {
        return mTweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //method used to inflate the view.  Before this can be implemented, need to create an
    //innerclass that will hold our view objects from the tweet layout.  Create below.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.tweet_list_item, null);
            holder = new ViewHolder();
            holder.nameLabel = (TextView) convertView.findViewById(R.id.nameLabel);
            holder.dateLabel = (TextView) convertView.findViewById(R.id.dateLabel);
            holder.tweetLabel = (TextView) convertView.findViewById(R.id.tweetLabel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Tweet tweet = mTweets.get(position);

        holder.dateLabel.setText(tweet.getFormattedTime());
        if(tweet.getUser() != null)
        {holder.nameLabel.setText("By: " + tweet.getUser().getName());}
        holder.tweetLabel.setText(tweet.getContent());

        return convertView;

    }

    //the innnerclass discussed above
    private static class ViewHolder {
        TextView nameLabel;
        TextView tweetLabel;
        TextView dateLabel;
    }
}
