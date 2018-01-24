package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button logIn,signUp;
Intent intent;
FirebaseUser firebaseUser;
FirebaseAuth firebaseAuth;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logIn=(Button)findViewById(R.id.mainSignIn);
        signUp=(Button)findViewById(R.id.mainSignUp);
        logIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        context=this;
        if(firebaseUser!=null)
        {
            intent=new Intent(this,SummeyAct.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if(view==logIn)
        {
            intent=new Intent(context,LogInActivity.class);
            startActivity(intent);
        }
        if(view==signUp)
        {
            intent=new Intent(context,SignUpActivity.class);
            startActivity(intent);
        }
    }
}
