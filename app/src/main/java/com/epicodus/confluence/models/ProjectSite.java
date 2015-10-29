package com.epicodus.confluence.models;

/**
 * Created by lesliepoole on 10/29/15.
 */
public class ProjectSite {
    private String mName;
    private String mDescription;
    private int mImage;

    public ProjectSite (String name, String description, int image) {
        mName = name;
        mDescription = description;
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }


    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
