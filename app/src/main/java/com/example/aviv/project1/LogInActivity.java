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

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
Button signIn;
FirebaseAuth firebaseAuth;
    Context context;
EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signIn=(Button)findViewById(R.id.logIn);
        email=(EditText)findViewById(R.id.emailSignIn);
        password=(EditText)findViewById(R.id.passwordSignIn);
        signIn.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();
        context=this;


    }

    @Override
    public void onClick(View view) {

    firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {

                Intent intent=new Intent(context,SummeyAct.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(context, "email or password are incorect", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}
