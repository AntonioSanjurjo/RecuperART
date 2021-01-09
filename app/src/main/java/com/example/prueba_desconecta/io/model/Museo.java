package com.example.prueba_desconecta.io.model;

import java.util.ArrayList;

public class Museo {
    private int id;
    private String nom;
    private ArrayList<PreviewObra> obras;
    private TipusMuseu tipus;
    private String direccio;
    private String descripcio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<PreviewObra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<PreviewObra> obras) {
        this.obras = obras;
    }

    public TipusMuseu getTipus() {
        return tipus;
    }

    public void setTipus(TipusMuseu tipus) {
        this.tipus = tipus;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
