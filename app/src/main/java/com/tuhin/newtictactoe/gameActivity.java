package com.tuhin.newtictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.media.Image;

public class gameActivity extends AppCompatActivity {

    int showRef = 0;
    int ti =0;
    // 0 - x
    // 1 - o
    // 2 - Null
    boolean gameActive = true;
    String winStr = null;
    int activePlayer = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPos = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    MediaPlayer tapmusicPlayer;
    MediaPlayer winmusicplayer;

    public void playerTap(View view) {
        tapmusicPlayer.start();
        ImageView img = (ImageView) view;
        int tapedImage = Integer.parseInt(img.getTag().toString());
        if (gameState[tapedImage] == 2 && gameActive) {
            gameState[tapedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Its O's turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Its X's turn - Tap to Play");
            }
//            else if (gameState[winPos[0]] != 2){
//                ti = 1;
//            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winPos : winPos) {
            if (gameState[winPos[0]] == gameState[winPos[1]] &&
                    gameState[winPos[1]] == gameState[winPos[2]] &&
                    gameState[winPos[0]] != 2) {
//                somebody has won
//                String winStr = null;
                if (gameState[winPos[0]] == 0) {
                    winStr = "X has Won";
//                    showRef = 1;
                } else if (gameState[winPos[0]] == 1) {
                    winStr = " O has won";
//                    showRef = 1;
                } else {
                    ti = 1;
                }
                gameStop();

            }

        }
    }

    public void gameStop(){
        showDialog(winStr);
        gameActive = false;
    }

    public void refreshButton(View view){

        TextView status = findViewById(R.id.status);
        status.setText("Its X's turn - Tap to Play ");
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
//        }
    }

    public void showDialog(String winStr){
        winmusicplayer.start();
        new AlertDialog.Builder(this)
                .setTitle(winStr)
                .setPositiveButton("Restart Ganme", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        restartButton();
                    }
                })
                .show();


    }

    public void restartButton(){

        TextView status = findViewById(R.id.status);
        status.setText("Its X's turn - Tap to Play ");
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
            {
                @Override
                public void onSystemUiVisibilityChange(int visibility)
                {
                    if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                    {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
        }

        tapmusicPlayer = MediaPlayer.create(this, R.raw.tapsound);
        winmusicplayer = MediaPlayer.create(this, R.raw.winsound);

        Intent intent = getIntent();
    }
}
