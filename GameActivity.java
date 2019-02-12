package com.nitschauhan.mathsgame;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView txtquestion,txtanswer,txtTime,txtScore;
    ImageButton btncorrect,btnwrong;
    boolean isResultCorrect;
    int secods=15;
    public int score=0;
    private boolean stopTimer=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txtquestion =(TextView)findViewById(R.id.txtquestion);
        txtanswer   =(TextView)findViewById(R.id.txtanswer);
        txtScore    =(TextView)findViewById(R.id.txtScore);
        txtTime   =(TextView)findViewById(R.id.txtTime);
        btncorrect=(ImageButton)findViewById(R.id.btncorrect);
        btnwrong  =(ImageButton)findViewById(R.id.btnwrong);
        txtScore.setText("SCORE:"+score);
        timer();
        btncorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyanswer(true);
            }
        });
        btnwrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyanswer(false);
            }
        });
        generatequestion();
    }
    private void generatequestion(){
        isResultCorrect=true;
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);
        int result = a+b;
        float f = random.nextFloat();
        if(f>0.5f){
            result =random.nextInt(1000);
            isResultCorrect=false;
        }
        txtquestion.setText(a + "+" + b);
        txtanswer.setText("=" + result);
    }
    public void verifyanswer(boolean answer){
        if(answer==isResultCorrect){
            score+=5;
            txtScore.setText("SCORE:"+score);
        }else{
            Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            Intent intent1 = new Intent(GameActivity.this,Score_Activity.class);
            intent1.putExtra("score",score);
            startActivity(intent1);
        }
        generatequestion();
    }
    private void timer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                txtTime.setText("TIME:"+secods);
                secods--;
                if(secods==0){
                    stopTimer=true;
                    Intent i = new Intent(GameActivity.this,Score_Activity.class);
                    i.putExtra("score",score);
                    startActivity(i);
                }
                if(stopTimer==false){
                    handler.postDelayed(this,1000);
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopTimer=false;
        finish();
    }
}
