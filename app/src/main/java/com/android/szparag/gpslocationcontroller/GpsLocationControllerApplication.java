package com.android.szparag.gpslocationcontroller;

import android.app.Application;

import com.android.szparag.gpslocationcontroller.backend.models.Policy;
import com.android.szparag.gpslocationcontroller.backend.models.Region;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ciemek on 01/11/2016.
 */

public class GpsLocationControllerApplication extends Application {

    private GoogleApiClient googleApiClient;

    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .build();

        realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("locations.realm")
                .deleteRealmIfMigrationNeeded()
                .build();

        realm.setDefaultConfiguration(realmConfiguration);


        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Policy.class).findAll().deleteAllFromRealm();
                realm.where(Region.class).findAll().deleteAllFromRealm();

                Policy homePolicy = realm.createObject(Policy.class, realm.where(Policy.class).count());
                homePolicy.setIcon(R.drawable.ic_hotel_black_24dp);
                homePolicy.setName("Home");

                Policy uniPolicy = realm.createObject(Policy.class, realm.where(Policy.class).count());
                uniPolicy.setIcon(R.drawable.ic_local_library_black_24dp);
                uniPolicy.setName("University");


                Region region;

                region = realm.createObject(Region.class, realm.where(Region.class).count());
                region.setName("Przemysl - home");
                region.setCenter(49.778046, 22.781886);
                region.setPolicy(homePolicy);

                region = realm.createObject(Region.class, realm.where(Region.class).count());
                region.setName("Przemysl - 2LO");
                region.setCenter(49.791420, 22.753957);
                region.setPolicy(uniPolicy);


                region = realm.createObject(Region.class, realm.where(Region.class).count());
                region.setName("Cracow - home");
                region.setCenter(50.071189, 19.923829);
                region.setPolicy(homePolicy);

                region = realm.createObject(Region.class, realm.where(Region.class).count());
                region.setName("Cracow - university");
                region.setCenter(50.066852, 19.917338);
                region.setPolicy(uniPolicy);

                region = realm.createObject(Region.class, realm.where(Region.class).count());
                region.setName("Cracow - university 2");
                region.setCenter(50.065172, 19.920997);
                region.setPolicy(uniPolicy);
            }
        });
    }



    public GoogleApiClient getGoogleApiClient() {
        return googleApiClient;
    }
}
