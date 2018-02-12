package com.example.aviv.project1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SummeyAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Context context;
    NavigationView navigationView;
    FirebaseAuth firebaseAuth;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summey);
        firebaseAuth=FirebaseAuth.getInstance();
        navigationView=(NavigationView)findViewById(R.id.navigation_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this ,drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;
        navigationView.setNavigationItemSelectedListener(this);






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
           // return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void LogOutMethod() {
        firebaseAuth.signOut();
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("menu id",String.valueOf(item.getItemId()));
        switch (item.getItemId()) {
            case R.id.PlayerListMenu:
                Intent intent = new Intent(context, Players.class);
                startActivity(intent);
                break;
            case R.id.FanChatMenu:
                Intent intent2 = new Intent(context,Chatactivity.class);
                startActivity(intent2);
                break;
                case R.id.SighnOutMenu:
                LogOutMethod();
                break;


        }
        return false;
    }
}
