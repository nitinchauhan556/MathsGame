package com.nitschauhan.mathsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnshare,btnplay,btnrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshare=(ImageButton)findViewById(R.id.btnshare);
        btnplay =(ImageButton)findViewById(R.id.btnplay);
        btnrate =(ImageButton)findViewById(R.id.btnrate);

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Maths Game is a easy and fun way to learn maths https://www.googleplay.com");
                startActivity(intent);
            }
        });
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,GameActivity.class);
                startActivity(i);
            }
        });
        btnrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You can open google play and rate us", Toast.LENGTH_SHORT);
            }
        });
    }
}
