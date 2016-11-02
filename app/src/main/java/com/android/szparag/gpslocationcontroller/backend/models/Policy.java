package com.android.szparag.gpslocationcontroller.backend.models;

import android.support.annotation.DrawableRes;

/**
 * Created by ciemek on 02/11/2016.
 */

public class Policy {

    public Policy(CharSequence name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public CharSequence         name;
    public @DrawableRes int     icon;
}
