package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Badminton extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);

        Log.d("reached", "reached");


        if (FirebaseDatabase.getInstance() != null)
        {
            FirebaseDatabase.getInstance().goOffline();
        }
        FirebaseDatabase.getInstance().goOnline();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("badminton");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<badmintonData> list = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    badmintonData p = ds.getValue(badmintonData.class);
                    list.add(p);
                }
                Log.d("TAG", String.valueOf(list.size())); //To see is not emplty
                lv = findViewById(R.id.simpleGridView2);
                BadmintonAdapter myAdapter=new BadmintonAdapter(getApplicationContext(), (ArrayList<badmintonData>) list);
                lv.setAdapter(myAdapter);
                Cricket.setListViewHeightBasedOnChildren(lv);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        ref.addListenerForSingleValueEvent(valueEventListener);
        ref.removeEventListener(valueEventListener);
    }
}