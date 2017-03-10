package br.diego.cadeostudio.core;

import android.location.Location;

import br.diego.cadeostudio.models.Studio;
import br.diego.cadeostudio.service.LocationService;

/**
 * Created by diego on 21/10/16.
 */
public class Controller {

    private static Controller instance = null;
    public static Studio studio;
    public static LocationService locationService;
    private Location location;


    private Controller(){

    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
