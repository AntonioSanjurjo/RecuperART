package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.Museo;

import java.util.ArrayList;

public class AllMuseusResponse {

 private boolean err;
 private int status;
 private int version;
 private ArrayList<Museo> ans;

 public AllMuseusResponse(){

 }

    public boolean isError() {
        return err;
    }

    public void setError(boolean error) {
        this.err = error;
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
        return ans;
    }

    public void setMuseos(ArrayList<Museo> museos) {
        ans = museos;
    }
}
