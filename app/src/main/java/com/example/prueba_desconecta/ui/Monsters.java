package com.example.prueba_desconecta.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba_desconecta.R;

public class Monsters extends AppCompatActivity {
    String getThemeku;
    String themeku = "";
    String SHARED_PREFS = "codeTheme";

    TextView subtitlepage;
    Button btncontinue;
    ImageView icontheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_monster);

        subtitlepage = findViewById(R.id.subtitlepage);
        btncontinue = findViewById(R.id.btncontinue);
        icontheme = findViewById(R.id.icontheme);

        // give an event to next activity
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Monsters.this, Descubre.class);
                startActivity(a);
            }
        });
        changeOurTheme();

    }

    public void changeOurTheme(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        getThemeku = sharedPreferences.getString(themeku, "");

        if(getThemeku.equals("blue")) {
            icontheme.setImageResource(R.drawable.icmob);
            btncontinue.setBackgroundResource(R.drawable.bgblue);
            subtitlepage.setText("The water is beautiful of blue");
        }
        else if(getThemeku.equals("green")) {
            icontheme.setImageResource(R.drawable.icmog);
            btncontinue.setBackgroundResource(R.drawable.bggreen);
            subtitlepage.setText("Nature and Green are friends");
        }
        else if(getThemeku.equals("purple")) {
            icontheme.setImageResource(R.drawable.icmop);
            btncontinue.setBackgroundResource(R.drawable.bgpurple);
            subtitlepage.setText("Shiny even in the dark");
        }
        else if(getThemeku.equals("orange")) {
            icontheme.setImageResource(R.drawable.icmoc);
            btncontinue.setBackgroundResource(R.drawable.bgorange);
            subtitlepage.setText("Orange is like a yellow");
        }

    }
}
