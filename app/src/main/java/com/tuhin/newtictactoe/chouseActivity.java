package com.tuhin.newtictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chouseActivity extends AppCompatActivity {

    public void player(View view){
        Intent intent = new Intent(this,gameActivity.class);
        startActivity(intent);
    }

    public void phone(View view){
        Intent intent = new Intent(this,comMove.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chouse);
    }
}