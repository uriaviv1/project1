package com.example.aviv.project1;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Players extends Fragment {
PlayerAdapter playerAdapter;
ArrayList<Player> players;
ListView LV;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_players, container, false);
        Bitmap Avivi= BitmapFactory.decodeResource(getResources(),R.drawable.avivi);
        Bitmap Taurean= BitmapFactory.decodeResource(getResources(),R.drawable.turian);
        Bitmap Sam= BitmapFactory.decodeResource(getResources(),R.drawable.sam);
        Bitmap aviram= BitmapFactory.decodeResource(getResources(),R.drawable.aviram);
        Bitmap erlich= BitmapFactory.decodeResource(getResources(),R.drawable.erlich);
        Bitmap jeff= BitmapFactory.decodeResource(getResources(),R.drawable.jeff);
        Bitmap mike= BitmapFactory.decodeResource(getResources(),R.drawable.mike);
        Bitmap nick= BitmapFactory.decodeResource(getResources(),R.drawable.nick);
        Bitmap or= BitmapFactory.decodeResource(getResources(),R.drawable.or);
        Bitmap shown= BitmapFactory.decodeResource(getResources(),R.drawable.shown);
        Bitmap tim= BitmapFactory.decodeResource(getResources(),R.drawable.tim);
        Bitmap tom= BitmapFactory.decodeResource(getResources(),R.drawable.tom);
        Bitmap yonatan= BitmapFactory.decodeResource(getResources(),R.drawable.yonatan);

        Player P1=new Player("Noam","Aviv",10,Avivi,201,"SF");
        Player P2=new Player("jeff","Adrian",0,jeff,201,"C");
        Player P3=new Player("Sam","Singer",1,Sam,193,"PG");
        Player P4=new Player("Tom","Maayan",3,tom,185,"PG");
        Player P5=new Player("Amit","Erlich",7,erlich,185,"PG");
        Player P6=new Player("Shown","Dowson",8,shown,198,"SG");
        Player P7=new Player("Or","Leumi",9,or,192,"SG");
        Player P8=new Player("Tauran","Green",11,Taurean,185,"PG");
        Player P9=new Player("Aviram","Zelikovich",12,aviram,191,"SG");
        Player P10=new Player("Jonathan","Mor",4,yonatan,205,"PF");
        Player P11=new Player("Dominique","Archie",21,nick,201,"F");
        Player P12=new Player("Mike","Efevberha",24,mike,193,"SF");
        Player P13=new Player("Tim","Kempton",45,tim,208,"SF");
        players=new ArrayList<Player>();
        players.add(P2); players.add(P3); players.add(P4); players.add(P10); players.add(P5); players.add(P6);
        players.add(P7); players.add(P1); players.add(P8); players.add(P9); players.add(P11); players.add(P12); players.add(P13);
        playerAdapter=new PlayerAdapter(getContext(),0,0,players);
        LV=(ListView)rootView.findViewById(R.id.LV);
        LV.setAdapter(playerAdapter);
        return rootView;


    }
}
