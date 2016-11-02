package com.android.szparag.gpslocationcontroller.backend.models;

import android.location.Location;

/**
 * Created by ciemek on 02/11/2016.
 */

public class Region {

    public Region(CharSequence name, Location center, Policy policy) {
        this.name = name;
        this.center = center;
        this.policy = policy;
    }

    private CharSequence    name;
    private Location        center;
    private Policy          policy;

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public Location getCenter() {
        return center;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
