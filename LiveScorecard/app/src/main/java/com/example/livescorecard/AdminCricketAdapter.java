package com.example.livescorecard;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdminCricketAdapter extends ArrayAdapter {
    private Context mcontext;

    public AdminCricketAdapter(@NonNull Context context, ArrayList<cricketData> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.mcontext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        cricketData product = (cricketData) getItem(position);
        TextView t1 = listitemView.findViewById(R.id.adminCricketTeam1);
        TextView t2 = listitemView.findViewById(R.id.adminCricketTeam2);
        TextView t1s = listitemView.findViewById(R.id.admint1score);
        TextView t2s = listitemView.findViewById(R.id.admint2score);
        TextView date = listitemView.findViewById(R.id.adminCricketdate);

        TextView view = listitemView.findViewById(R.id.adminUpdateScore);
        t1.setText(product.getTeam1());
        t2.setText(product.getTeam2());
        t1s.setText(product.getTeam1Score());
        t2s.setText(product.getTeam2Score());
        date.setText(product.getDate());
        Log.d("reached",product.getTeam1());
        //desc.setText(product.getDescription());
        //Log.d("test2","logo "+product.getLogo());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, matchSummary.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                i.putExtra("t1", product.getTeam1());
                i.putExtra("t2", product.getTeam2());
                i.putExtra("t1s", product.getTeam1Score());
                i.putExtra("t2s", product.getTeam2Score());
                i.putExtra("t1overs", product.getTeam1OversPlayed());
                i.putExtra("t2overs", product.getTeam2OversPlayed());
                i.putExtra("s1runs", product.getStriker1Runs());
                i.putExtra("s1", product.getStriker1());
                i.putExtra("s2runs", product.getStriker2Runs());
                i.putExtra("s2", product.getStriker2());
                i.putExtra("bowler", product.getBowler());
                i.putExtra("bstats", product.getBowlerStats());
                i.putExtra("mid",product.getMatchId());
                i.putExtra("obj", (Parcelable) product);
                mcontext.startActivity(i);
            }
        });

        return listitemView;
    }
}
