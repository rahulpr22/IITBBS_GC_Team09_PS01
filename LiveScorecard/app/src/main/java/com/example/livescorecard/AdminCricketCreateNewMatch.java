package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminCricketCreateNewMatch extends AppCompatActivity {
    EditText t1n,t2n,t1s,t2s,s1,s2,s1r,s2r,t1o,t2o,b,bstat,date;
    TextView create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cricket_create_new_match);

        date= findViewById(R.id.mdate);
        t1n= findViewById(R.id.team1Name);
        t2n= findViewById(R.id.team2Name);
        t1s=findViewById(R.id.team1cedit);
        t2s=findViewById(R.id.team2cedit);
        s1=findViewById(R.id.Striker1cedit);
        s2=findViewById(R.id.Striker2cedit);
        s1r= findViewById(R.id.Striker1Runscedit);
        s2r= findViewById(R.id.Striker2Runscedit);
        t1o= findViewById(R.id.team1Overscedit);
        t2o= findViewById(R.id.team2Overscedit);
        b= findViewById(R.id.bowlercedit);
        bstat= findViewById(R.id.bowlerstatcedit);
        create= findViewById(R.id.cricketcUpdate);

        long t1overs=0;
        long t2overs=0;
        if(!t1o.getText().toString().equals(""))
            t1overs= Long.valueOf(t1o.getText().toString());
        if(!t2o.getText().toString().equals(""))
            t2overs= Long.valueOf(t2o.getText().toString());


        cricketData data= new cricketData(date.getText().toString(),t1n.getText().toString(),t2n.getText().toString(),t1s.getText().toString(),t2s.getText().toString(),s1.getText().toString(),
                s2.getText().toString(),b.getText().toString(),s1r.getText().toString(),s2r.getText().toString(),bstat.getText().toString(),t1overs,
                t2overs,"match");


        DatabaseReference fbDb = null;
        if (fbDb == null) {
            fbDb = FirebaseDatabase.getInstance().getReference();
        }


        fbDb.child("cricket")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // get total available quest
                        int size = (int) dataSnapshot.getChildrenCount();
                        size++;
                        data.setMatchId("match"+size);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test",data.getTeam1());
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cricket");

                ref.setValue(data);
                Intent i = new Intent(AdminCricketCreateNewMatch.this, AdminCricket.class);
                startActivity(i);
            }
        });
    }
}