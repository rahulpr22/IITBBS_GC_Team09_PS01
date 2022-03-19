package com.example.livescorecard;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BadmintonAdapter extends ArrayAdapter {
    private Context mcontext;

    public BadmintonAdapter(@NonNull Context context, ArrayList<badmintonData> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.mcontext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.badmintonlistitem, parent, false);
        }

        badmintonData product = (badmintonData) getItem(position);
        TextView t1 = listitemView.findViewById(R.id.bTeam1);
        TextView t2 = listitemView.findViewById(R.id.bTeam2);
        TextView t1s = listitemView.findViewById(R.id.tb1score);
        TextView date = listitemView.findViewById(R.id.bdate);

        TextView view = listitemView.findViewById(R.id.bviewScore);
        t1.setText(product.getTeam1());
        t2.setText(product.getTeam2());
        t1s.setText(product.getGameStats());
        date.setText(product.getDate());
        Log.d("reached",product.getTeam1());
        //desc.setText(product.getDescription());
        //Log.d("test2","logo "+product.getLogo());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, badmintonMatchDetails.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

                i.putExtra("mid",product.getMatchId());
                i.putExtra("obj",product);
                mcontext.startActivity(i);
            }
        });

        return listitemView;
    }
}
