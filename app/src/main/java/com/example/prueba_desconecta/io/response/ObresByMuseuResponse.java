package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.Obra;

import java.util.ArrayList;

public class ObresByMuseuResponse {

    private boolean err;
    private int status;
    private int version;
    private ArrayList<Obra> ans;

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

    public ArrayList<Obra> getAns() {
        return ans;
    }

    public void setAns(ArrayList<Obra> ans) {
        this.ans = ans;
    }
}
