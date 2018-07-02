package com.example.dd.a15_puzzle;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createTiles();

    }


    public void createTiles(){

        System.out.println("createTiles start");

        ImageButton tile_1 = new ImageButton(this);
        tile_1.setImageResource(R.drawable.tile_1);

        tile_1.setX(500);
        tile_1.setY(500);

        System.out.println(tile_1.getX());


    }





}
