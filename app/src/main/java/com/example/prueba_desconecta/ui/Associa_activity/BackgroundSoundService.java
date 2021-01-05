package com.example.prueba_desconecta.ui.Associa_activity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

import com.example.prueba_desconecta.R;

public class BackgroundSoundService extends Service {
    MediaPlayer musicPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Transacciones entre APP y recursos exteriores
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(this, R.raw.lluvia);
        //musicPlayer.setLooping(true); // Set looping
        musicPlayer.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        musicPlayer.start();
        Toast.makeText(getApplicationContext(), "Reproduciendo en segundo plano", Toast.LENGTH_SHORT).show();
        return startId;
    }

    public void onStart(Intent intent, int startId) {
    }

    @Override
    public void onDestroy() {
        musicPlayer.stop();
        musicPlayer.release();
    }

    @Override
    public void onLowMemory() {
    }

}

