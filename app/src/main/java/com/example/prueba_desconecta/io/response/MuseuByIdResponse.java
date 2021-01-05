package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.io.model.Museo;

public class MuseuByIdResponse {
    private boolean err;
    private int status;
    private int version ;
    private Museo ans;

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

    public Museo getMuseu() {
        return ans;
    }

    public void setMuseu(Museo ans) {
        this.ans = ans;
    }
}
