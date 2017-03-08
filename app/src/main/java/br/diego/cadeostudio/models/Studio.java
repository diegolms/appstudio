package br.diego.cadeostudio.models;

/**
 * Created by diego on 08/03/17.
 */
public class Studio {
    private String nome;
    private String dono;
    private String imageUrl;
    private String distancia;


    public Studio(String nome, String dono, String distancia, String imageUrl) {
        this.nome = nome;
        this.dono = dono;
        this.distancia = distancia;
        this.imageUrl = imageUrl;
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

    public String getDistancia() {
        return distancia;
    }

}
