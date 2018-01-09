package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SummeyAct extends AppCompatActivity implements View.OnClickListener {
Context context;
    Button moveToPlayersActivity;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summey);
    moveToPlayersActivity=(Button)findViewById(R.id.goToPlayersActivity);
    moveToPlayersActivity.setOnClickListener(this);
    context=this;
    }

    @Override
    public void onClick(View view) {
        intent=new Intent(this,Players.class);
        startActivity(intent);
    }
}
