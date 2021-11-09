package com.example.mc_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ExamActivity extends AppCompatActivity {
    List<String> ques = Arrays.asList("Which alphabet is from Makharij # 2","Which alphabet is from Makharij # 7", "Which alphabet is from Makharij # 4", "Which alphabet is from Makharij # 11", "Which alphabet is from Makharij # 12");
    List<Character> correct = Arrays.asList('ح', 'ض', 'ق', 'د', 'ظ');
    List<Character> mcqs1 = Arrays.asList('ث', 'ط', 'ح', 'ن', 'ب', 'أ', 'ق', 'ض', 'ق', 'ر', 'س', 'ص', 'ل', 'د', 'ی', 'و', 'ظ', 'ع', 'خ', 'ب');
    List<Character> ans = Arrays.asList('-','-','-','-','-');

    int indexQues = 0;
    int indexMcqs = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        RadioGroup mcq = findViewById(R.id.mcqs);
        TextView question = findViewById(R.id.textView5);
        question.setText(ques.get(indexQues));

        int count = mcq.getChildCount();
        for (int i=0;i<count;i++) {
            RadioButton rb = (RadioButton) mcq.getChildAt(i);
            rb.setText(Character.toString(mcqs1.get(indexMcqs)));
            indexMcqs++;
        }
    }
    public void next(View view){
        int id = view.getId();
        Button btn = findViewById(id);
        if(btn.getText().equals("Next")){
            RadioGroup mcq = findViewById(R.id.mcqs);
            mcq.clearCheck();
            indexQues++;
            TextView question = findViewById(R.id.textView5);
            question.setText(ques.get(indexQues));
            int count = mcq.getChildCount();
            for (int i=0;i<count;i++) {
                RadioButton rb = (RadioButton) mcq.getChildAt(i);
                rb.setText(Character.toString(mcqs1.get(indexMcqs)));
                indexMcqs++;
            }
            if(indexQues >= 4){
                btn.setText("Finish");
            }
        }else{
            indexQues++;
            int count=0;
            for(int i=0;i<ans.size();i++){
                if(ans.get(i).equals(correct.get(i))){
                    count++;
                }
            }
            String res= Integer.toString(count)+"/5";
            Intent intent = new Intent(this, resultActivity.class);
            intent.putExtra("key", res);
            startActivity(intent);
        }
    }
    public void checkRadio(View view){
        if(indexQues <= 4){
            int id = view.getId();
            RadioButton rb = findViewById(id);
            ans.set(indexQues,rb.getText().charAt(0));
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(ExamActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("You already completed quiz!");
            alertDialog.show();
        }
    }
}