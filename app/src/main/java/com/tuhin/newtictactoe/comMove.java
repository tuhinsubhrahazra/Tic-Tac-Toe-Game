package com.tuhin.newtictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Math;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class comMove extends AppCompatActivity {

    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //    int arr[] = new int[]
    int cells[];
    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;
    String winStr = null;
    int ti = 0;
    int y = 0;
    int ha = 0;
    boolean gameActive = true;
    MediaPlayer tapmusicPlayer;
    MediaPlayer winmusicplayer;
    // 0 - x
    // 1 - o
    // 2 - Null

//    @SuppressLint("ResourceType")
    public void playerTap(View view) {
        tapmusicPlayer.start();
        ImageView img = (ImageView) view;
        int tapedImage = Integer.parseInt(img.getTag().toString());
        if (gameState[tapedImage] == 2 && gameActive) {
            gameState[tapedImage] = activePlayer;
//            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
            }

            int n = 0;
            int t = 0;

            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] == 2) {
                    n++;
                }
            }

//            System.out.println(n);

            int arr[] = new int[n];

            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] == 2) {
                    arr[t] = i;
                    t++;
                }
            }

            if (n == 0) {
//                winStr = "Match Draw";
//                showDialog(winStr);
                gameActive = false;
                y =1;
            }

            ImageView im = null;
            if (activePlayer == 1 && gameActive) {
//                if(n == 1){
//                    gameActive = false;
//                }
//                int rand = (int) (Math.random() * 8);
                int r = new Random().nextInt(arr.length);
                int rand = arr[r];

                if (rand == 0) {
                    im = (ImageView) findViewById(R.id.imageView15);
                }
                if (rand == 1) {
                    im = (ImageView) findViewById(R.id.imageView16);
                }
                if (rand == 2) {
                    im = (ImageView) findViewById(R.id.imageView17);
                }
                if (rand == 3) {
                    im = (ImageView) findViewById(R.id.imageView18);
                }
                if (rand == 4) {
                    im = (ImageView) findViewById(R.id.imageView19);
                }
                if (rand == 5) {
                    im = (ImageView) findViewById(R.id.imageView20);
                }
                if (rand == 6) {
                    im = (ImageView) findViewById(R.id.imageView11);
                }
                if (rand == 7) {
                    im = (ImageView) findViewById(R.id.imageView21);
                }
                if (rand == 8) {
                    im = (ImageView) findViewById(R.id.imageView13);
                }

                gameState[rand] = activePlayer;
                assert im != null;
                im.setImageResource(R.drawable.o);
            }

//            assert im != null;

            activePlayer = 0;

//            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winPos :winPos)
        {
            if (gameState[winPos[0]] == gameState[winPos[1]] &&
                    gameState[winPos[1]] == gameState[winPos[2]] &&
                    gameState[winPos[0]] != 2) {

                if (gameState[winPos[0]] == 0) {
                    winStr = "X has Won";

                } else if (gameState[winPos[0]] == 1) {
                    winStr = " O has won";

                } else {
                    ti = 1;
//                    winStr = "Match Draw";
                }
                gameStop();
            }
        }
        if(y== 1 && ti == 1){
            winStr = "Match Draw";
            showDialog(winStr);
        }
    }

    public void wind(){
        if(y== 1 && ti == 1){
            winStr = "Match Draw";
            showDialog(winStr);
        }
    }


    public void gameStop(){
//        if(ti == 1){
//            winStr = "Match Draw";
//        }
        ha = 1;
        showDialog(winStr);
        gameActive=false;
    }


//    public void avalableCells(){
//        for(int i=0;i<=gameState.length;i++){
//        if(gameState[i]==2){
//
//        }
//        }
//        }

    public void refreshButton(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);

    }

    public void showDialog(String winStr){

        new AlertDialog.Builder(this)
                .setTitle(winStr)
                .setPositiveButton("Restart Ganme",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog,int which){

                restartButton();
            }
        })
        .show();


    }

    public void restartButton(){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_com_move);

        tapmusicPlayer = MediaPlayer.create(this, R.raw.tapsound);
        winmusicplayer = MediaPlayer.create(this, R.raw.winsound);
    }
}