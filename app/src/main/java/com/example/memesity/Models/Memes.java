package com.example.memesity.Models;

public class Memes {

    private int id_foto_usuari;
    private int id_publicacio;
    private String nom_usuari;
    private String descripcio;

    public Memes(String nom_usuari, String descripcio){ //constructor with nom_usuari and descripcio
        this.nom_usuari = nom_usuari;
        this.descripcio = descripcio;
    }


    public Memes(String nom_usuari, String descripcio, int id_publicacio){ //constructor with nom_usuari and descripcio
        this.nom_usuari = nom_usuari;
        this.descripcio = descripcio;
        this.id_publicacio = id_publicacio;
    }

    public Memes(String nom_usuari, String descripcio, int id_foto_usuari, int id_publicacio){ //constructor with nom_usuari, descripcio, id_foto_usuari and
        this.nom_usuari = nom_usuari;
        this.descripcio = descripcio;
        this.id_foto_usuari = id_foto_usuari;
        this.id_publicacio = id_publicacio;
    }

    public String getNom_usuari(){
        return nom_usuari;
    }

    public void setNom_usuari(String nom_usuari){
        this.nom_usuari = nom_usuari;
    }

    public int getId_foto_usuari() {
        return id_foto_usuari;
    }

    public void setId_foto_usuari(int id_foto_usuari) {
        this.id_foto_usuari = id_foto_usuari;
    }

    public int getId_publicacio() {
        return id_publicacio;
    }

    public void setId_publicacio(int id_publicacio) {
        this.id_publicacio = id_publicacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
