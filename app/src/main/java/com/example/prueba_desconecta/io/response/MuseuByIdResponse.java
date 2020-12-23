package com.example.prueba_desconecta.io.response;

import com.example.prueba_desconecta.ui.PreviewMuseo;

public class MuseuByIdResponse {
    private boolean err;
    private int status;
    private int version ;
    private PreviewMuseo ans;

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

    public PreviewMuseo getMuseu() {
        return ans;
    }

    public void setAns(PreviewMuseo ans) {
        this.ans = ans;
    }
}
