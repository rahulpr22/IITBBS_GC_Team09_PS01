package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AdminDashboard extends AppCompatActivity {
    LinearLayout cricket,football, badminton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        cricket= findViewById(R.id.admincricketcard);
        football= findViewById(R.id.adminfootballcard);
        badminton= findViewById(R.id.adminbadmintoncard);

        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,AdminCricket.class);
                i.putExtra("sport","cricket");
                startActivity(i);
            }
        });

    }
}