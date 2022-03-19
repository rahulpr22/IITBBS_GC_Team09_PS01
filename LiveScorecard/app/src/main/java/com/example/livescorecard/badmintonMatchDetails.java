package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class badmintonMatchDetails extends AppCompatActivity {

    TextView p1,p2,set1,set2;
    ImageView r;
    String mid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton_match_details);
        r= findViewById(R.id.brefresh);
        p1= findViewById(R.id.p1Name);
        p2= findViewById(R.id.p2Name);
        set1= findViewById(R.id.p1setScores);
        set2= findViewById(R.id.p2setScores);

        Intent i = getIntent();
        badmintonData b= (badmintonData) i.getSerializableExtra("obj");
        String x1= b.getSet1Stats().split(",")[0].toString()+"  " +
         b.getSet2Stats().split(",")[0].toString()+ "  "+
         b.getSet3Stats().split(",")[0].toString() ;

        String x2= b.getSet1Stats().split(",")[1].toString()+"  " +
         b.getSet2Stats().split(",")[1].toString()+ "  "+
         b.getSet3Stats().split(",")[1].toString() ;

        p1.setText(b.getPlayer1());
        p2.setText(b.getPlayer2());
        set1.setText(x1);
        set2.setText(x2);
        mid=b.getMatchId();
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myRef;
                myRef = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference matchRefrence = myRef.child("badminton/"+mid);


                matchRefrence.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        badmintonData obj= dataSnapshot.getValue(badmintonData.class);
                        String x1= obj.getSet1Stats().split(",")[0].toString()+"  " +
                                obj.getSet2Stats().split(",")[0].toString()+ "  "+
                                obj.getSet3Stats().split(",")[0].toString() ;

                        String x2= obj.getSet1Stats().split(",")[1].toString()+"  " +
                                obj.getSet2Stats().split(",")[1].toString()+ "  "+
                                obj.getSet3Stats().split(",")[1].toString() ;
                        p1.setText(obj.getPlayer1());
                        p2.setText(obj.getPlayer2());
                        set1.setText(x1);
                        set2.setText(x2);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

            }
        });
    }
}