package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.Museo;
import com.example.prueba_desconecta.ui.Obra;

import java.util.ArrayList;

public class MuseuResponse {

   private boolean err;
   private int status;
   private int version;
   private Museo museo;


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

    public Museo getMuseo() {
        return museo;
    }

    public void setMuseo(Museo museo) {
        this.museo = museo;
    }
}
