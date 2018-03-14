package com.example.aviv.project1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Document;

/**
 * Created by Administrator on 07/03/2018.
 */

public class BoxScoreFragment extends Fragment {
    TextView TV;
    FirebaseFirestore firebaseFirestore;
    ImageView home,guest;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.box_score, container, false);
        TV = rootView.findViewById(R.id.BoxScoreTextView);
        firebaseFirestore=FirebaseFirestore.getInstance();
        String homeTeam=firebaseFirestore.collection("URLS").document("homeTeam").get().toString();
        String guestTeam=firebaseFirestore.collection("URLS").document("guestTeam").get().toString();
        String score=firebaseFirestore.collection("URLS").document("score").get().toString();
        String htmlTag=firebaseFirestore.collection("URLS").document("htmlTag").get().toString();
        String []stringsImages=new String[2];
        stringsImages[0]=homeTeam;
        stringsImages[1]=guestTeam;
        String [] stringsText=new String[2];
        stringsImages[0]=score;
        stringsText[1]=htmlTag;

        home = rootView.findViewById(R.id.homeImage);
        guest=rootView.findViewById(R.id.guestImage);
        new DownloadImage(home,guest).execute(stringsImages);
        new DownloadText(TV).execute(stringsText);
        return rootView;


    }


}


