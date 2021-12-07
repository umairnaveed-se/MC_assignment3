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
        String text = "You scored " + value + "!";
        TextView res = findViewById(R.id.textView6);
        res.setText(text);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }
    public void share(View view){
        String value = getIntent().getExtras().getString("key");
        String shareText = "I scored " + value + " in Emission points!";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}