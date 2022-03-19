package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class matchSummary extends AppCompatActivity {
    TextView t1,t2,t1s,t2s,t1oname,t2oname,t1o,t2o,s1,s2,s1r,s2r,b,bst;
    String mid="";
    ImageView refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);

        Intent i=getIntent();
        t1=findViewById(R.id.t1Sum);
        t2=findViewById(R.id.t2Sum);
        t1s= findViewById(R.id.t1ScoreSum);
        t2s= findViewById(R.id.t2ScoreSum);
        t1oname= findViewById(R.id.t1overs);
        t2oname= findViewById(R.id.t2overs);
        t1o= findViewById(R.id.team1Overs);
        t2o= findViewById(R.id.team2Overs);
        s1= findViewById(R.id.Striker1);
        s2= findViewById(R.id.Striker2);
        s1r= findViewById(R.id.Striker1Runs);
        s2r= findViewById(R.id.Striker2Runs);
        b= findViewById(R.id.bowler);
        bst= findViewById(R.id.bowlerStats);
        refresh= findViewById(R.id.refresh);
        mid= i.getStringExtra("mid");
        t1.setText(i.getStringExtra("t1"));
        t2.setText(i.getStringExtra("t2"));
        t1s.setText(i.getStringExtra("t1s"));
        t2s.setText(i.getStringExtra("t2s"));
        t1oname.setText(i.getStringExtra("t1")+" Overs Completed");
        t2oname.setText(i.getStringExtra("t2")+" Overs Completed");
        t1o.setText(String.valueOf((int) i.getLongExtra("t1overs",Long.valueOf("0"))));
        t2o.setText(String.valueOf((int) i.getLongExtra("t2overs",Long.valueOf("0"))));
        s1.setText(i.getStringExtra("s1")+"*");
        s1r.setText(i.getStringExtra("s1runs"));
        s2.setText(i.getStringExtra("s2"));
        s2r.setText(i.getStringExtra("s2runs"));
        b.setText("Current Bowler: "+i.getStringExtra("bowler")+"*");
        bst.setText(i.getStringExtra("bstats"));

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myRef;
                myRef = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference matchRefrence = myRef.child("cricket/"+mid);


                matchRefrence.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        cricketData obj= dataSnapshot.getValue(cricketData.class);
                        t1.setText(obj.getTeam1());
                        t2.setText(obj.getTeam2());
                        t1s.setText(obj.getTeam1Score());
                        t2s.setText(obj.getTeam2Score());
                        t1oname.setText(obj.getTeam1()+" Overs Completed");
                        t2oname.setText(obj.getTeam2()+" Overs Completed");
                        t1o.setText(String.valueOf((obj.getTeam1OversPlayed() )));
                        t2o.setText(String.valueOf((obj.getTeam2OversPlayed() )));
                        s1.setText(obj.getStriker1()+"*");
                        s1r.setText(obj.getStriker1Runs());
                        s2.setText(obj.getStriker2());
                        s2r.setText(obj.getStriker2Runs());

                        b.setText("Current Bowler: "+obj.getBowler()+"*");
                        bst.setText(obj.getBowlerStats());
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

            }
        });
    }
}