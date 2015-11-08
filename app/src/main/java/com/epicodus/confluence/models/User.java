package com.epicodus.confluence.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by lesliepoole on 11/7/15.
 */
@Table(name = "users", id = "_id")
public class User extends Model{

    @Column(name = "name")
    private String mName;

    public User() {
        super();
    }

    public User(String name) {
        super();
        mName = name;
    }

    public String getName() {
        return mName;
    }

}
