package com.example.prueba_desconecta.ui;

import java.util.ArrayList;

public class Museo {

    private String nombre;
    //private ArrayList<Obra> obras;
    private String id;
    private String tipo;
    private String direccion;
    private String descripcion;


    public Museo(){

    }

   // public ArrayList<Obra> getobralist(){
     //   return getObras();

    //}

   // public Obra getObra(int i){
     //   return getObras().get(i);
  //  }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //public ArrayList<Obra> getObras() {
   //     return obras;
   // }

   // public void setObras(ArrayList<Obra> obras) {
    //    this.obras = obras;
   // }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
