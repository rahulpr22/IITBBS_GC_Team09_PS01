package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminCricket extends AppCompatActivity {
    TextView createnew;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cricket);

        createnew= findViewById(R.id.createnewCricket);
        createnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(AdminCricket.this, AdminCricketCreateNewMatch.class);
                startActivity(i);
            }
        });
        if (FirebaseDatabase.getInstance() != null)
        {
            FirebaseDatabase.getInstance().goOffline();
        }
        FirebaseDatabase.getInstance().goOnline();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("cricket");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<cricketData> list = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    cricketData p = ds.getValue(cricketData.class);
                    Log.d("TAG",p.getBowler()+" :)");
                    list.add(p);
                }
                Log.d("TAG", String.valueOf(list.size())); //To see is not emplty
                lv= findViewById(R.id.adminCricketView);
                AdminCricketAdapter myAdapter=new AdminCricketAdapter(getApplicationContext(), (ArrayList<cricketData>) list);
                lv.setAdapter( myAdapter);
                Cricket.setListViewHeightBasedOnChildren(lv);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        ref.addListenerForSingleValueEvent(valueEventListener);
        ref.removeEventListener(valueEventListener);

    }
}