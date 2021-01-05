package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.io.model.MuseuNames;

import java.util.ArrayList;

public class MuseuNamesResponse {
  private boolean err;
  private int status;
  private int version;
  private ArrayList<MuseuNames> ans;


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

    public ArrayList<MuseuNames> getMuseuName() {
        return ans;
    }

    public void setMuseuName(ArrayList<MuseuNames> ans) { this.ans = ans;
    }
}
