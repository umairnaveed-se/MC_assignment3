package com.example.mc_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String value = getIntent().getExtras().getString("key");
        TextView res = findViewById(R.id.textView6);
        res.setText(value);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
    pubic void share(View view){

    }
}