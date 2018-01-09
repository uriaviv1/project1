package com.example.aviv.project1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Aviv on 22/12/2017.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {
    Context context;
    List<Player>playerList;
    public PlayerAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Player> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.playerList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.player,parent,false);
        ImageView playerPicture=(ImageView)view.findViewById(R.id.playerImage);
        TextView fullName=(TextView)view.findViewById(R.id.fullName);
        TextView Position=(TextView)view.findViewById(R.id.postaion);
        TextView number=(TextView)view.findViewById(R.id.number);
        TextView height=(TextView)view.findViewById(R.id.hight);
        Player temp=playerList.get(position);
        playerPicture.setImageBitmap(temp.getPhoto());
        fullName.setText(temp.getFirstName()+" "+temp.getLastName());
        Position.setText(temp.getPosation());
        number.setText(String.valueOf(temp.getNumber()));
        height.setText(String.valueOf(temp.getHeight()));


        return view;
    }
}
