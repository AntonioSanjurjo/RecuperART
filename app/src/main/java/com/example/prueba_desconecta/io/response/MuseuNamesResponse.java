package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.MuseuNames;

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

    public ArrayList<MuseuNames> getAns() {
        return ans;
    }

    public void setAns(ArrayList<MuseuNames> ans) { this.ans = ans;
    }
}
