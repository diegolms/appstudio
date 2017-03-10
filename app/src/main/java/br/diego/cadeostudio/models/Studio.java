package br.diego.cadeostudio.models;

/**
 * Created by diego on 08/03/17.
 */
public class Studio {
    private String nome;
    private String dono;
    private String imageUrl;
    private double latitude;
    private double longitude;


    public Studio(String nome, String dono, String imageUrl, double latitude, double longitude) {
        this.nome = nome;
        this.dono = dono;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Studio() {
    }

    public String getNome() {
        return nome;
    }

    public String getDono() {
        return dono;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
