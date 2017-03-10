package br.diego.cadeostudio.Utils;

import android.location.Location;

/**
 * Created by diego on 08/03/17.
 */
public class Util {

    public static String getDistanceBetweenTwoPoints(double latitudeAtual, double longitudeAtual, double latitude, double longitude) {

        Location locationA = new Location("point A");
        locationA.setLatitude(latitudeAtual);
        locationA.setLongitude(longitudeAtual);
        Location locationB = new Location("point B");
        locationB.setLatitude(latitude);
        locationB.setLongitude(longitude);
        double distance = locationA.distanceTo(locationB)/1000.0;

        if (distance > 1.0) {
            return String.format("%.1f km", distance);
        }
        return String.format("%d m", (int) (distance * 1000));

    }

}
