package br.diego.cadeostudio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import br.diego.cadeostudio.adapter.StudioAdapter;
import br.diego.cadeostudio.core.Controller;
import br.diego.cadeostudio.models.Studio;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, LocationListener {

    private ListView studioListView;

    List<Studio> studios = new ArrayList<>();

    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        populate();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            Log.d("TAG", "Location not available");
        }


        StudioAdapter adapter = new StudioAdapter(
                MainActivity.this, R.layout.item_view, studios);
        studioListView = (ListView) findViewById(R.id.studio_list_view);
        studioListView.setAdapter(adapter);
        studioListView.setOnItemClickListener(MainActivity.this);
    }

    private void populate() {
        int cont = 0;
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
        this.studios.add(new Studio("Studio " + cont++, "Responsavel " + cont++ + " - há 16 km", "16km", "android.resource://" + getPackageName() + "/" + R.drawable.animal1));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Controller.studio = (Studio) adapterView.getItemAtPosition(i);
        startActivity(new Intent(this, DetalheStudioActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(this);
    }


    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        Log.d("LOCATION", String.valueOf(lat) + "_"+ String.valueOf(lng));
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
}
