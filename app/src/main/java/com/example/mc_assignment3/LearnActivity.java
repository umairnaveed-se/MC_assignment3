package com.example.mc_assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Arrays;
import java.util.List;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        List<Character> chars = Arrays.asList('أ', 'ب', 'ت', 'ث', 'ج', 'ح', 'خ', 'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق', 'ک', 'ل', 'م', 'ن', 'و', 'ہ', 'ی');
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
                    TextView field = findViewById(R.id.textView5);
                    field.setText(btn.getText());
                    for(int i =0; i < btncontainer.getChildCount(); i++){
                        View btntemp = btncontainer.getChildAt(i);
                        if(v instanceof Button){
                            btntemp.setBackgroundColor(getResources().getColor(R.color.black));
                        }
                    }
                    btn.setBackgroundColor(getResources().getColor(R.color.custom2));
                }
            });
            btncontainer.addView(btn);
        }
    }
}