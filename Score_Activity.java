package com.nitschauhan.mathsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score_Activity extends AppCompatActivity {
    TextView rscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_);
        rscore = (TextView)findViewById(R.id.rscore);
        Intent intent = new Intent();
        int score = getIntent().getIntExtra("score",0);
        rscore.setText("SCORE :"+score);
    }
}
