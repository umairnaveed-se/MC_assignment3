package com.example.mc_assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRepo(View view){
        Uri uri = Uri.parse("https://github.com/umairnaveed-se/MC_assignment3/tree/master");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void openApp(View view){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
}