package com.epicodus.confluence.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by lesliepoole on 11/7/15.
 */
@Table(name = "tweets", id ="_id")
public class Tweet extends Model {

    @Column(name = "Content")
    private String mContent;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    @Column(name = "User")
    private User mUser;

    public Tweet() {
        super();
    }

    public Tweet(String content, User user) {
        mContent = content;
        mUser = user;
        mCreatedAt = new Date().getTime();
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("PST"));
        return formatter.format(mCreatedAt);
    }

    public static List<Tweet> all() {
        return new Select()
                .from(Tweet.class)
                .execute();
    }

    public static Tweet find(String tweet)  {
        return new Select()
                .from(Tweet.class)
                .where("Content = ?", tweet)
                .executeSingle();
    }

    public List<Response> response() {

        return getMany(Response.class,"tweet");}

    public void parseHashTags() {
        String[] words = mContent.split("\\s+");

        for (String word : words) {
            if (word.startsWith("#")) {
                Tag tag = Tag.newTag(word);
                TagTweet tagTweet = new TagTweet(tag, this);
                tagTweet.save();
            }
        }
    }
}

