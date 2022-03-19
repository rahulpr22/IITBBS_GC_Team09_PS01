package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        update= findViewById(R.id.cricketUpdate);
        Intent i= getIntent();
        String mid= getIntent().getStringExtra("mid");
        cricketData data= (cricketData) i.getSerializableExtra("obj");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test",data.getTeam1());
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cricket").child(mid);
                Log.d("reached",ref.child("date").toString());
                data.setTeam1Score(t1s.getText().toString());
                data.setTeam2Score(t2s.getText().toString());
                data.setStriker1(s1.getText().toString());
                data.setStriker1Runs(s1r.getText().toString());
                data.setStriker2(s2.getText().toString());
                data.setStriker2Runs(s2r.getText().toString());
                long t1overs=0;
                long t2overs=0;
                if(!t1o.getText().toString().equals(""))
                    t1overs= Long.valueOf(t1o.getText().toString());
                if(!t2o.getText().toString().equals(""))
                    t2overs= Long.valueOf(t2o.getText().toString());

                data.setTeam1OversPlayed(t1overs);
                data.setTeam2OversPlayed(t2overs);
                data.setBowler(b.getText().toString());
                data.setBowlerStats(bstat.getText().toString());
                ref.setValue(data);
                Intent i = new Intent(AdminCricketUpdate.this, AdminCricket.class);
                startActivity(i);
            }
        });

//        ref.updateChildren(updates);
//        timeRef.updateChildren(timeUpdates);

    }
}