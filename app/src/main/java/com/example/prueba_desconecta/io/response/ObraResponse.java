package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.Obra;

public class ObraResponse {
   private boolean err;
   private int status;
   private int version;
   private Obra obra;

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

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
}
