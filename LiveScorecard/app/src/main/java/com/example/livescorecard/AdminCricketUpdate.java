package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AdminCricketUpdate extends AppCompatActivity {
    EditText t1s,t2s,s1,s2,s1r,s2r,t1o,t2o,b,bstat;
    TextView update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cricket_update);


        t1s=findViewById(R.id.team1sedit);
        t2s=findViewById(R.id.team2sedit);
        s1=findViewById(R.id.Striker1edit);
        s2=findViewById(R.id.Striker2edit);
        s1r= findViewById(R.id.Striker1Runsedit);
        s2r= findViewById(R.id.Striker2Runsedit);
        t1o= findViewById(R.id.team1Oversedit);
        t2o= findViewById(R.id.team2Oversedit);
        b= findViewById(R.id.bowleredit);
        bstat= findViewById(R.id.bowlerstatedit);

        String mid= getIntent().getStringExtra("mid");
        cricketData data= getIntent().getParcelableExtra("obj");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cricket").child(mid);
        data.setTeam1Score(t1s.getText().toString());

//        ref.updateChildren(updates);
//        timeRef.updateChildren(timeUpdates);

    }
}