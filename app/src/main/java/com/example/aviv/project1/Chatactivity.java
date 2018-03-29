package com.example.aviv.project1;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Chatactivity extends Fragment {
FirebaseFirestore FF;
    Context context;
    Button send;
    FirebaseUser firebaseUser;
    ListView LV1;
    EditText message;
    FirebaseAuth firebaseAuth;
    Integer i=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_chatactivity2, container, false);
        LV1=(ListView)rootView.findViewById(R.id.Lv1);
        send=(Button)rootView.findViewById(R.id.send);
        message=(EditText)rootView.findViewById(R.id.message);
       firebaseAuth=FirebaseAuth.getInstance();

        FF=FirebaseFirestore.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String name=firebaseUser.getEmail();
        FF.collection("message").orderBy("id").addSnapshotListener(new com.google.firebase.firestore.EventListener<QuerySnapshot>(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                ArrayList<Message> arrayList=new ArrayList<>();

                i=0;

                for (DocumentSnapshot documentSnapshot:documentSnapshots)
                {


                    if(documentSnapshot!=null) {
                        Log.d("agony", documentSnapshot.getId() + ", " + documentSnapshot.get("name"));
                        Message msg = documentSnapshot.toObject(Message.class);
                        i++;
                        arrayList.add(msg);



                    }


                }
                if(getActivity()!=null) {
                    MsgAdapter msgAdapter = new MsgAdapter(getContext(), 0, 0, arrayList);
                    delete(arrayList, msgAdapter);
                }


            }

        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addNewMessage(name);


            }
        });

       return rootView;

    }

    private void addNewMessage(String name) {
        Map<String,Object> messageMap=new HashMap<>();
        messageMap.put("message",message.getText().toString());
        messageMap.put("name",name);
        messageMap.put("id", i);
        FF.collection("message").document(i.toString()).set(messageMap);
        message.setText("");
    }

    private void delete(ArrayList<Message> arrayList, MsgAdapter msgAdapter) {
        if(arrayList.size()>20)
        {
            for(Integer k=0;k<arrayList.size();k++)
            {
                FF.collection("message").document(k.toString()).delete();

            }
        }
        if(!msgAdapter.msgList.isEmpty()) {
            LV1.setAdapter(msgAdapter);

         }
    }
}
