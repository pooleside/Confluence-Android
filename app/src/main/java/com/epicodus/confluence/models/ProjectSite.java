package com.epicodus.confluence.models;

/**
 * Created by lesliepoole on 10/29/15.
 */
public class ProjectSite {
    private String mName;
    private String mDescription;
    private int mImage;

    public ProjectSite(String name, String description, int image) {

        mName = name;
        mDescription = description;
        mImage = image;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
