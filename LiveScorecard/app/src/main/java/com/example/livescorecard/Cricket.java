package com.example.livescorecard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cricket extends AppCompatActivity {

    ListView simpleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket2);
        Log.d("reached", "reached");


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
                simpleList = findViewById(R.id.simpleGridView);
                productAdapter myAdapter=new productAdapter(getApplicationContext(), (ArrayList<cricketData>) list);
                simpleList.setAdapter(myAdapter);
                setListViewHeightBasedOnChildren(simpleList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        ref.addListenerForSingleValueEvent(valueEventListener);
        ref.removeEventListener(valueEventListener);

    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // Get the Adapter corresponding to ListView
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount() returns the number of data items
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // Calculate the width and height of the child View
            totalHeight += listItem.getMeasuredHeight(); // Count the total height of all children
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight() gets the height occupied by the divider between sub-items
        // params.height finally gets the height required for the complete display of the entire ListView
        listView.setLayoutParams(params);
    }



}



