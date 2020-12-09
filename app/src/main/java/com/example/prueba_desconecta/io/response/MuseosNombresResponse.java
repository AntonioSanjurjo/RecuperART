package com.example.prueba_desconecta.io.response;

import java.util.ArrayList;

public class MuseosNombresResponse {
  private boolean err;
  private int status;
  private int version;
  private ArrayList<String> Nombres;


    public boolean isErr() {
        return err;
    }

    public void setErr(boolean err) {
        this.err = err;
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

    public ArrayList<String> getNombres() {
        return Nombres;
    }

    public void setNombres(ArrayList<String> nombres) {
        Nombres = nombres;
    }
}
