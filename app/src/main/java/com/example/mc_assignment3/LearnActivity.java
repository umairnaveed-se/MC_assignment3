package com.example.mc_assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Character> chars = Arrays.asList('أ', 'ب', 'ت', 'ث', 'ج', 'ح', 'خ', 'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق', 'ک', 'ل', 'م', 'ن', 'و', 'ہ', 'ی');
        List<Integer> indexType = Arrays.asList(1, 10, 5, 6, 3, 1, 1, 5, 6, 4, 7, 7, 3, 7, 3, 5, 6, 1, 1, 9, 2, 2, 4, 9, 8, 9, 1, 3);

        androidx.gridlayout.widget.GridLayout btncontainer = findViewById(R.id.btnCont);
        for (int i = 0; i < chars.size(); i++) {
            Button btn = new Button(this);
            btn.setText(Character.toString(chars.get(i)));
            btn.setLayoutParams(new ViewGroup.LayoutParams(105, 150));
            if(i == 0){
                btn.setBackgroundColor(getResources().getColor(R.color.custom2));
            }else{
                btn.setBackgroundColor(getResources().getColor(R.color.black));
            }
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TextView field = findViewById(R.id.textView5);
                    //field.setText(btn.getText());
                    for(int i =0; i < btncontainer.getChildCount(); i++){
                        View btntemp = btncontainer.getChildAt(i);
                        if(v instanceof Button){
                            btntemp.setBackgroundColor(getResources().getColor(R.color.black));
                        }
                    }
                    btn.setBackgroundColor(getResources().getColor(R.color.custom2));
                    ImageView imgview = findViewById(R.id.imageView2);
                    Context context = imgview.getContext();
                    String imgname = "alphab" + Integer.toString(indexType.get(chars.indexOf(btn.getText().toString().charAt(0))));
                    int id = context.getResources().getIdentifier(imgname, "drawable", context.getPackageName());
                    imgview.setImageResource(id);
                }
            });
            btncontainer.addView(btn);
        }
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}