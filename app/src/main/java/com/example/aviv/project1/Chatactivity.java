package com.example.aviv.project1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Chatactivity extends AppCompatActivity {
FirebaseFirestore FF;
    Context context;
    //String s;
    Button send;
    FirebaseUser firebaseUser;
    ListView LV1;
    EditText message;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatactivity2);
        context=this;
        LV1=(ListView)findViewById(R.id.Lv1);
        send=(Button)findViewById(R.id.send);
        message=(EditText)findViewById(R.id.message);
       firebaseAuth=FirebaseAuth.getInstance();

        FF=FirebaseFirestore.getInstance();
        firebaseUser= firebaseAuth.getCurrentUser();
        final String name=firebaseUser.getEmail();
        FF.collection("message").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>(){
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                ArrayList<Message> arrayList=new ArrayList<>();



                for (DocumentSnapshot documentSnapshot:documentSnapshots)
                {


                    if(documentSnapshot!=null) {
                        Log.d("agony", documentSnapshot.getId() + ", " + documentSnapshot.get("name"));
                        Message msg = documentSnapshot.toObject(Message.class);


                        arrayList.add(msg);

                    }


                }
              MsgAdapter msgAdapter=new MsgAdapter(context,0,0,arrayList);
               if(!msgAdapter.msgList.isEmpty()) {
                   LV1.setAdapter(msgAdapter);

                }

            }

        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Map<String,Object>messageMap=new HashMap<>();
                messageMap.put("message",message.getText().toString());
                messageMap.put("name",name);
                FF.collection("message").add(messageMap);
                message.setText("");


            }
        });

    }
}
