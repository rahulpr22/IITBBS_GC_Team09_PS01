package com.example.livescorecard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MatchAdapter extends ArrayAdapter {
    private Context mcontext;

    public MatchAdapter(@NonNull Context context, ArrayList<matchData> matchList){
        super(context, 0, matchList);
        this.mcontext=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }
        matchData matchdata = (matchData) getItem(position);
        TextView team1 = listitemView.findViewById(R.id.Team1);
        TextView team2 = listitemView.findViewById(R.id.Team2);
        TextView t1Score= listitemView.findViewById(R.id.t1score);
        TextView t2Score= listitemView.findViewById(R.id.t2score);
        Button b= listitemView.findViewById(R.id.viewScore);
        team1.setText(matchdata.getTeam1());
        team2.setText(matchdata.getTeam2());
        t1Score.setText(matchdata.getTeam1Score());
        t2Score.setText(matchdata.getTeam2Score());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcontext,matchSummary.class);
                i.putExtra("team1",matchdata.getTeam1());
                i.putExtra("team2",matchdata.getTeam2());
                i.putExtra("team1Score",matchdata.getTeam1Score());
                i.putExtra("team2Score",matchdata.getTeam2Score());
                i.putExtra("striker",matchdata.getStriker1());
                i.putExtra("nonStriker",matchdata.getStriker2());
                i.putExtra("striker1Runs",matchdata.getStriker1Runs());
                i.putExtra("striker2Runs",matchdata.getStriker2Runs());
                i.putExtra("bowler",matchdata.getBowler());
                i.putExtra("bowlerStats",matchdata.getBowlerStats());
                i.putExtra("team1Overs",matchdata.getTeam1OversPlayed());
                i.putExtra("team2Overs",matchdata.getTeam2OversPlayed());
                mcontext.startActivity(i);
            }
        });


        return listitemView;
    }
}
