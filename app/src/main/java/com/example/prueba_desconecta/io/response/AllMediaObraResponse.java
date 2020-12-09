package com.example.prueba_desconecta.io.response;

import java.util.ArrayList;

public class AllMediaObraResponse {
    private boolean err;
    private int status;
    private int version;
    private ArrayList<String> mediasobras;


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

    public ArrayList<String> getMediasobras() {
        return mediasobras;
    }

    public void setMediasobras(ArrayList<String> mediasobras) {
        this.mediasobras = mediasobras;
    }
}
