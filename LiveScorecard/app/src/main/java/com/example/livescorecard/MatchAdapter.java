package com.example.livescorecard;

import android.content.Context;
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
        matchData product = (matchData) getItem(position);
        TextView team1 = listitemView.findViewById(R.id.Team1);
        TextView team2 = listitemView.findViewById(R.id.Team2);
        TextView t1Score= listitemView.findViewById(R.id.t1score);
        TextView t2Score= listitemView.findViewById(R.id.t2score);
        Button b= listitemView.findViewById(R.id.viewScore);
        //TextView desc = listitemView.findViewById(R.id.prod_description);
//        ImageView logo = listitemView.findViewById(R.id.prod_image);
//        TextView view =listitemView.findViewById(R.id.viewbtn);
//        title.setText(product.getTitle());
//        price.setText(product.getPrice());
//        //desc.setText(product.getDescription());
//        //Log.d("test2","logo "+product.getLogo());
//        Picasso.get().load(product.getLogo()).into(logo);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(mcontext,productScreen.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                i.putExtra("title",product.getTitle());
//                i.putExtra("price",product.getPrice());
//                i.putExtra("desc",product.getDescription());
//                i.putExtra("logo",product.getLogo());
//                i.putExtra("pid",product.getPid());
//                i.putExtra("catid",product.getCatid());
//                mcontext.startActivity(i);
//            }
//        });

        return listitemView;
    }
}
