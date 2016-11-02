package com.android.szparag.gpslocationcontroller.backend.models;

import android.support.annotation.DrawableRes;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by ciemek on 02/11/2016.
 */

@RealmClass
public class Policy implements RealmModel {

    @PrimaryKey
    private long                id;
    private String              name;
    private @DrawableRes int    icon;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
