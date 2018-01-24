package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SummeyAct extends AppCompatActivity implements View.OnClickListener {
Context context;
FirebaseAuth firebaseAuth;

    Button moveToPlayersActivity,logOut;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summey);
    moveToPlayersActivity=(Button)findViewById(R.id.goToPlayersActivity);
    moveToPlayersActivity.setOnClickListener(this);
    logOut=(Button)findViewById(R.id.logOut);
    logOut.setOnClickListener(this);
    firebaseAuth=FirebaseAuth.getInstance();

    context=this;
    }

    @Override
    public void onClick(View view) {
        if(view==moveToPlayersActivity) {
            intent = new Intent(this, Players.class);
            startActivity(intent);
        }
        if (view==logOut)
        {
            firebaseAuth.signOut();
            intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
