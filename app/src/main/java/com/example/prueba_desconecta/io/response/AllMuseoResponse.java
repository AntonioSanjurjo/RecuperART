package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.Museo;

import java.util.ArrayList;

public class AllMuseoResponse {

 private boolean error;
 private int status;
 private int version;
 private ArrayList<Museo> Museos;

 public  AllMuseoResponse(){

 }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ArrayList<Museo> getMuseos() {
        return Museos;
    }

    public void setMuseos(ArrayList<Museo> museos) {
        Museos = museos;
    }
}
