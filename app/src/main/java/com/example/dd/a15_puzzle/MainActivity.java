package com.example.dd.a15_puzzle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static final int FIELD_SIZE = 4;
    public static final int STEP = 280;
    public static final int TILE_SIZE = 280;

    private Button[][] tiles = new Button[FIELD_SIZE][FIELD_SIZE];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      createTilesArray();

      mixTiles();

      displayTiles();



    }


    private void createTilesArray(){

        Button button;

        //FrameLayout frameLayout = (FrameLayout)findViewById(R.id.mainView);


        for (int i = 0; i < FIELD_SIZE; i++) {

            for (int j = 0; j < FIELD_SIZE; j++) {

                button = new Button(this);

                tiles[i][j] = button;

                // button.setHeight(TILE_SIZE) не работает, нагуглил что надо так:
                // сохрани ссылку https://stackoverflow.com/questions/15897553/change-height-of-android-button-through-code
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(TILE_SIZE, TILE_SIZE);
                button.setLayoutParams(params);

                //button.setX((i + 1) * STEP);
                //button.setY((j + 1) * STEP);

                //frameLayout.addView(button); // !!!!!!!!!!!!!

                // так же создается лишняя кнопка, вместо пустого тайла.

            }

        }



        tiles[0][0].setBackgroundResource(R.drawable.tile_1);
        tiles[1][0].setBackgroundResource(R.drawable.tile_2);
        tiles[2][0].setBackgroundResource(R.drawable.tile_3);
        tiles[3][0].setBackgroundResource(R.drawable.tile_4);


        tiles[0][1].setBackgroundResource(R.drawable.tile_5);
        tiles[1][1].setBackgroundResource(R.drawable.tile_6);
        tiles[2][1].setBackgroundResource(R.drawable.tile_7);
        tiles[3][1].setBackgroundResource(R.drawable.tile_8);

        tiles[0][2].setBackgroundResource(R.drawable.tile_9);
        tiles[1][2].setBackgroundResource(R.drawable.tile_10);
        tiles[2][2].setBackgroundResource(R.drawable.tile_11);
        tiles[3][2].setBackgroundResource(R.drawable.tile_12);

        tiles[0][3].setBackgroundResource(R.drawable.tile_13);
        tiles[1][3].setBackgroundResource(R.drawable.tile_14);
        tiles[2][3].setBackgroundResource(R.drawable.tile_15);

    }

    private void mixTiles(){

        Button tmp;

        Random rnd = new Random();

        int i1, i2, j1, j2; // номера тайлов, которые меняем местами (например тайл 2-2 и тайл 2-1)

        //rnd.nextInt(FIELD_SIZE);

        for (int i = 0; i < 100; i++) {

            // выбираем 2 рандомных тайла
            i1 = rnd.nextInt(FIELD_SIZE);
            i2 = rnd.nextInt(FIELD_SIZE);
            j1 = rnd.nextInt(FIELD_SIZE);
            j2 = rnd.nextInt(FIELD_SIZE);


            // меняем их местами через временную переменную
            tmp = tiles[i1][i2];
            tiles[i1][i2] = tiles[j1][j2];
            tiles[j1][j2] = tmp;
        }


    }


    private void displayTiles(){


        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.mainView);


        for (int i = 0; i < FIELD_SIZE; i++) {

            for (int j = 0; j < FIELD_SIZE; j++) {

                tiles[i][j].setX( (i+1) * STEP );
                tiles[i][j].setY( (j+1) * STEP );

                frameLayout.addView(tiles[i][j]); // !!!!!!!!!!!!!



            }

        }
    }

}
