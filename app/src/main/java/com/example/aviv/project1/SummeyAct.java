package com.example.aviv.project1;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
public class SummeyAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,OnBrightnessLow{

    NavigationView navigationView;
    FirebaseAuth firebaseAuth;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Intent intent;
    android.app.Fragment fragment;
    android.app.FragmentManager fragmentManager;
    FrameLayout frameLayout;
    android.app.FragmentTransaction fragmentTransaction;
    private TextView tv;
    Context context;
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //int butteryPercent=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
           // changeBrightness(butteryPercent);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summey);
        firebaseAuth = FirebaseAuth.getInstance();
        context=this;
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout_summeey);
        navigationView.setNavigationItemSelectedListener(this);
        Intent serviceIntent = new Intent(this, ServiceReciver.class);
        startService(serviceIntent);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
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
        Log.d("menu id", String.valueOf(item.getItemId()));
        FragmentStart();
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.PlayerListMenu:
                drawerLayout.closeDrawers();
                fragment = new Players();
                replaceFragment(fragment);

                break;
            case R.id.FanChatMenu:
                fragment = new Chatactivity();
                drawerLayout.closeDrawers();
                replaceFragment(fragment);
                break;
            case R.id.SighnOutMenu:
                LogOutMethod();
                drawerLayout.closeDrawers();
                break;
            case R.id.BoxScoreMenu:
                drawerLayout.closeDrawers();
                fragment = new BoxScoreFragment();
                replaceFragment(fragment);
                break;
            case R.id.faceboogPage:
                drawerLayout.closeDrawers();
                fragment = new FacebookFragment();
                replaceFragment(fragment);
                break;
            case R.id.instagram:
                drawerLayout.closeDrawers();
                fragment = new InstagramFragment();
                replaceFragment(fragment);
                break;


        }
        return false;

    }

   // @Override
   // protected void onStop() {

       //this.unregisterReceiver(this.broadcastReceiver);
       // super.onStop();
   // }

    private void replaceFragment(Fragment fragment) {
        fragmentTransaction.replace(R.id.frame_layout_summeey, fragment);
        fragmentTransaction.commit();
    }

    private void FragmentStart() {
        Fragment fragment;
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

   // protected void onStart() {
       // registerReceiver(this.broadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
      //  super.onStart();
   // }

    @Override
    public void changeBrightness(int buttatyPercents) {
        if(buttatyPercents<10) {
            int brightness;
            Settings.System.putInt(getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
          //  brightness = System.getInt(getContentResolver(),
                    //Settings.System.SCREEN_BRIGHTNESS;
        }

    }
}
