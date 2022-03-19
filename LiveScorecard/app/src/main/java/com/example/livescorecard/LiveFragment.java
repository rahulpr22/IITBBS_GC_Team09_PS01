package com.example.livescorecard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class LiveFragment extends Fragment {
    public ListView simleList;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
    private Boolean bool;

    private LinearLayoutManager mManager;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=database.getReference();
    public LiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_live, container, false);
        ArrayList<matchData> data = new ArrayList<>();
        simleList= (ListView)v.findViewById(R.id.listviewMatches);
        simleList.setAdapter(new MatchAdapter(getActivity(),data));
        return v;
    }

    public void getData(){
        if (FirebaseDatabase.getInstance() != null)
        {
            FirebaseDatabase.getInstance().goOffline();
        }
        FirebaseDatabase.getInstance().goOnline();

//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference numberRef = rootRef.child("cricket");
//        ValueEventListener eventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                List<matchData> list= new ArrayList<>();
//                if(dataSnapshot.exists()) {
//                    Log.d("TAG", "Number exists!");
//                    matchData m= dataSnapshot.getValue(matchData.class);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        };
//        numberRef.addListenerForSingleValueEvent(eventListener);
    }
}