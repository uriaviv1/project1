package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SummeyAct extends AppCompatActivity {
    Context context;
    FirebaseAuth firebaseAuth;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    Button moveToPlayersActivity, logOut, gotochatactivity;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summey);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        context = this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        actionBarDrawerToggle.onOptionsItemSelected(item);
           // return true;

        switch (item.getItemId()) {
            case R.id.PlayerListMenu:
                Intent intent = new Intent(context, Players.class);
                startActivity(intent);
                return true;
            case R.id.chatMenu:
                Intent intent2 = new Intent(context, Players.class);
                startActivity(intent2);
                return true;
            case R.id.LogOutMenu:
                LogOutMethod();
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    private void LogOutMethod() {
        firebaseAuth.signOut();
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
