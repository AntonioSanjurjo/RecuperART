package com.example.prueba_desconecta.ui;

public class Obra {

    

private String tipo;
private int id;
private String descripcion;
private String autor;
private PreviewMuseo museo;
private String museuNom;
private String nom;


public Obra(){

}


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public PreviewMuseo getMuseo() {
        return museo;
    }

    public void setMuseo(PreviewMuseo museo) {
        this.museo = museo;
    }

    public String getMuseuNom() {
        return museuNom;
    }

    public void setMuseuNom(String museuNom) {
        this.museuNom = museuNom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
