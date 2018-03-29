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
import com.google.firebase.firestore.FirebaseFirestore;

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
        String[] stringsImages = new String[2];
        firebaseFirestore = FirebaseFirestore.getInstance();
        toStringFromObject(stringsText, "score", 0);
        toStringFromObject(stringsText, "htmlTag", 1);
        toStringFromObject(stringsImages, "homeTeam", 0);
        toStringFromObject(stringsImages, "guestTeam", 1);
        home = rootView.findViewById(R.id.homeImage);
        guest = rootView.findViewById(R.id.guestImage);
        new DownloadImage(home, guest).execute(stringsImages);
        new DownloadText(TV).execute(stringsText);
        return rootView;


    }

    private void toStringFromObject(final String[] stringsText, String documentId, final int i) {
        DocumentReference docRef = firebaseFirestore.collection("urls").document(documentId);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                    DocumentTostring s = documentSnapshot.toObject(DocumentTostring.class);
                Toast.makeText(getContext(),  documentSnapshot.toString(), Toast.LENGTH_LONG).show();
                Log.d("tag",documentSnapshot.toString());
                if (notEmpty(s.getString())) {
                    stringsText[i] = s.getString();
                }
            }
        });
    }







    public static boolean notEmpty(String string) {
        if (string == null || string.length() == 0)
            throw new IllegalArgumentException("String must not be empty");
            return true;
    }

}
