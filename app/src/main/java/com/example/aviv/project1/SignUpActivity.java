package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText password, email;
    FirebaseAuth firebaseAuth;
    Intent intent;
    FirebaseFirestore db;
    Context context;
    Button signUp;
    NewUser newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUp = (Button) findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.password);
        signUp.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        context = this;

    }

    @Override
    public void onClick(View view) {
        intent = new Intent(context, SummeyAct.class);
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    startActivity(intent);

                }
                else {
                    Toast.makeText(context, "oops something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}


