package com.android.szparag.gpslocationcontroller;

import android.app.Application;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by ciemek on 01/11/2016.
 */

public class GpsLocationControllerApplication extends Application {

    private GoogleApiClient googleApiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .build();
    }


    public GoogleApiClient getGoogleApiClient() {
        return googleApiClient;
    }
}
