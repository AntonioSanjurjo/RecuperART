package com.example.prueba_desconecta.ui.Crea_activity;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;


public class PuzzlePiece extends AppCompatImageView {
    //android.support.v7.widget.AppCompatImageView
    //androidx.appcompat.widget.AppCompatImageView
    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;

    public PuzzlePiece(Context context) {
        super(context);
    }
}
