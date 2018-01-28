package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Chatactivity extends AppCompatActivity {
FirebaseFirestore FF;
    Context context;
    //String s;
    Button send;
    ListView LV1;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatactivity2);
        context=this;
        //s=getIntent().getExtras().getString("name");
        send=(Button)findViewById(R.id.send);
        message=(EditText)findViewById(R.id.message);
        CollectionReference collectionReference=FF.collection("message");
        collectionReference.addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                Set<String>set=new HashSet<String>();
                Iterator i=documentSnapshots.iterator();
                while (i.hasNext())
                {
                    set.add((String) i.next());
                }
            }
        });
        FF=FirebaseFirestore.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,Object>massege=new HashMap<>();
                massege.put("Message",message.getText().toString());
                massege.put("name","uri");
                FF.collection("message").add(massege);
                send.setText("");

            }
        });

    }
}
