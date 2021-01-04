package com.example.prueba_desconecta.io.response;

import android.graphics.Bitmap;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class WordCloud {
    private boolean err;
    private int status;
    private int version;
    private Bitmap ans;
    private String text = "";
    private RequestBody body =
            RequestBody.create(MediaType.parse("text/plain"), text);

    private Object service;
  //  private Call<ResponseBody> call = service.getStringRequestBody(body);
    //private Response<ResponseBody> response = call.execute();
 //   private String value = response.body().string();

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

    public Bitmap getAns() {
        return ans;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAns(Bitmap ans) {
        this.ans = ans;
    }

}
