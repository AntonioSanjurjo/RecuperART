package com.example.prueba_desconecta.io.response;

public class MediaObraResponse {

    private boolean err;
    private int status;
    private int version;
    private String ans;

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

    public String getMediaObra(){
        return ans;
    }

    public void setMediaObra(String ans) {
        this.ans = ans;
    }
}
