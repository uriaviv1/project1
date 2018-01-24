package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {
EditText fName,lName,password,email;
FirebaseAuth firebaseAuth;
Intent intent;
FirebaseFirestore db ;
Context context;
Button signUp;
NumberPicker numberPickerl;
    NewUser newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fName=(EditText)findViewById(R.id.firstName);
        signUp=(Button)findViewById(R.id.signUp);
        lName=(EditText)findViewById(R.id.lastName);
        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.password);
        numberPickerl=(NumberPicker)findViewById(R.id.agePicker);
        numberPickerl.setMaxValue(99);
        numberPickerl.setMinValue(0);
        signUp.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        context=this;

    }

    @Override
    public void onClick(View view) {

           newUser = new NewUser(fName.getText().toString(), lName.getText().toString(), email.getText().toString(), password.getText().toString(), numberPickerl.getValue());
            if(newUser!=null){

        Toast.makeText(this, newUser.toString(), Toast.LENGTH_LONG).show();
        intent=new Intent(context,SummeyAct.class);
        firebaseAuth.createUserWithEmailAndPassword(newUser.getEmail(),newUser.getPassword()).addOnCompleteListener(this);

    }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful())
        {
            final Map<String,Object> user=new HashMap<>();
            user.put("first",newUser.getFirstName());
            user.put("last",newUser.getLastName());
            user.put("age",newUser.getAge());
            db.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    db.collection("users")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (DocumentSnapshot document : task.getResult()) {
                                            Log.d("tag1", document.getId() + " => " + document.getData());
                                        }
                                    } else {
                                        Log.w("tag1", "Error getting documents.", task.getException());
                                    }
                                }
                            });
                    startActivity(intent);
                }
            });

        }
    }
}
