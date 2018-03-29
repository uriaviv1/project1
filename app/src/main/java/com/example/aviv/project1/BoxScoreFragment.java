package com.example.aviv.project1;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * Created by Administrator on 07/03/2018.
 */

public class BoxScoreFragment extends Fragment {
    TextView TV;
    FirebaseFirestore firebaseFirestore;
    ImageView home, guest;


    View rootView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.box_score, container, false);
        TV = rootView.findViewById(R.id.BoxScoreTextView);
        final String[] stringsText = new String[2];
        final String[] stringsImages = new String[2];
        firebaseFirestore = FirebaseFirestore.getInstance();

        home = rootView.findViewById(R.id.homeImage);
        guest = rootView.findViewById(R.id.guestImage);
        firebaseFirestore.collection("urls").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for (DocumentSnapshot documentSnapshot : documentSnapshots) {

                    DocumentTostring s = documentSnapshot.toObject(DocumentTostring.class);
                    Toast.makeText(getContext(),  documentSnapshot.toString(), Toast.LENGTH_LONG).show();
                    if (documentSnapshot.getId().toString() == "htmlTag") {
                        stringsText[0] = s.getString();
                        if (documentSnapshot.getId().toString() == "score") {
                            stringsText[1] = s.getString();
                        }
                    }
                    if (documentSnapshot.getId().toString() == "homeTeam") {
                        stringsImages[0] = s.getString();
                    }
                    if (documentSnapshot.getId().toString() == "guestTeam") {
                        stringsImages[1] = s.getString();
                    }
                }
            }

        });

        new DownloadImage(home, guest).execute(stringsImages);
        new DownloadText(TV).execute(stringsText);
        return rootView;
    }


}










