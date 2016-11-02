package com.android.szparag.gpslocationcontroller.backend.models;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by ciemek on 02/11/2016.
 */

@RealmClass
public class Region implements RealmModel{

    @PrimaryKey
    private long    id;
    private String  name;
    private double  centerLat;
    private double  centerLon;
    private Policy  policy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getCenter() {
        return new LatLng(centerLat, centerLon);
    }

    public double getCenterLat() {
        return centerLat;
    }

    public double getCenterLon() {
        return centerLon;
    }

    public void setCenter(LatLng center) {
        centerLat = center.latitude;
        centerLon = center.longitude;
    }

    public void setCenter(double centerLat, double centerLon) {
        this.centerLat = centerLat;
        this.centerLon = centerLon;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
