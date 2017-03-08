package br.diego.cadeostudio.core;

import br.diego.cadeostudio.models.Studio;

/**
 * Created by diego on 21/10/16.
 */
public class Controller {

    private static Controller instance = null;
    public static Studio studio;


    private Controller(){

    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
}
