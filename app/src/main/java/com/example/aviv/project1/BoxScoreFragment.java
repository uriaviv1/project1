package com.example.aviv.project1;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 07/03/2018.
 */

public class BoxScoreFragment extends Fragment {
    TextView TV;
    FirebaseFirestore firebaseFirestore;
    ImageView home, guest;
    private String[] stringsText = new String[2];
    private String[] stringsImages = new String[2];


    View rootView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.box_score, container, false);
        TV = rootView.findViewById(R.id.BoxScoreTextView);

        firebaseFirestore = FirebaseFirestore.getInstance();

        home = rootView.findViewById(R.id.homeImage);
        guest = rootView.findViewById(R.id.guestImage);

        firebaseFirestore.collection("urls")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot querySnapshot : task.getResult()) {
                                Log.d("tag5",querySnapshot.getId()+"=>" + querySnapshot.getData());


                                if (querySnapshot.getId().equals("htmlTag")) {


                                    stringsText[0]= (String) querySnapshot.get("src");

                                }


                                    if (querySnapshot.getId().equals("score")) {


                                        stringsText[1]= (String) querySnapshot.get("src");



                                    }

                                if (querySnapshot.getId().equals("homeTeam")) {

                                    stringsImages[0]= (String) querySnapshot.get("src");

                            }
                                if (querySnapshot.getId().equals("guestTeam")) {


                                    stringsImages[1]= (String) querySnapshot.get("src");

                                }
                            }
                            }
                        }
                });

                reapetAsync();
        return rootView;
    }
    public void reapetAsync() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            new DownloadImage(home, guest).execute(stringsImages);
                            new DownloadText(TV).execute(stringsText);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 100000); //execute in every 30000 ms
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}










