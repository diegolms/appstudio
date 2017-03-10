package br.diego.cadeostudio.service;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import br.diego.cadeostudio.Utils.Constants;
import br.diego.cadeostudio.core.Controller;

/**
 * Created by diegolopes on 09/03/17.
 */

public class LocationService extends Service implements LocationListener {

    private LocationManager locationManager;
    private Context context;
    private static final int LOCATION_INTERVAL = 1000;
    private static final float LOCATION_DISTANCE = 10f;


    public LocationService(Context context){
        this.context = context;
        Log.i(Constants.TAG, "Iniciou GPS");

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {


            if (checkGPSState(context)) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, this);
                Controller.getInstance().setLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
                Log.d(Constants.TAG, "LOCALIZAÇÃO GPS");
            }
            if (checkNetworkState(context)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, this);
                Controller.getInstance().setLocation(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
                Log.d(Constants.TAG, "LOCALIZAÇÃO REDE");
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i(Constants.TAG, "lat: " + location.getLatitude() + " lng: " + location.getLongitude() + "tipo :" + location.getProvider());
        Controller.getInstance().setLocation(location);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            if (ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.removeUpdates(this);
                Log.i(Constants.TAG, "LocationService . Destroyed");

            }
        }


    }

    public void removeUpdates(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
    }



    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public boolean checkGPSState(Context context) {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public boolean checkNetworkState(Context context) {
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}
