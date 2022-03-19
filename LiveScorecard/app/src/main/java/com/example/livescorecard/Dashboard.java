package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {
    LinearLayout cricket,football, badminton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cricket= findViewById(R.id.cricketcard);
        football= findViewById(R.id.footballcard);
        badminton= findViewById(R.id.badmintoncard);

        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this,MainActivity.class);
                i.putExtra("sport","cricket");
                startActivity(i);
            }
        });

        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this,MainActivity.class);
                i.putExtra("sport","football");
                startActivity(i);
            }
        });

        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this,MainActivity.class);
                i.putExtra("sport","badminton");
                startActivity(i);
            }
        });
    }
}