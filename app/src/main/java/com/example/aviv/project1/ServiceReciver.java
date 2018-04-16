package com.example.aviv.project1;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;
    public class ServiceReciver extends Service {

        String bateria = "Nada";
        private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent intent) {
                int level = intent.getIntExtra( "level", 0 );
                bateria = String.valueOf(level);
            }
        };

        public void onCreate() {
            super.onCreate();
            this.registerReceiver(this.broadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Toast.makeText(getApplicationContext(), "Command=" + bateria + "%", Toast.LENGTH_LONG).show();
            stopSelf();
            return START_STICKY;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            unregisterReceiver(broadcastReceiver);
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }


    }
