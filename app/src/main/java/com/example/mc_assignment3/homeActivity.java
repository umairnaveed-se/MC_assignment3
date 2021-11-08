package com.example.mc_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void openLearnActivity(View view){
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }
    public void openExamActivity(View view){
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }
}