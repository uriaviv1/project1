package com.example.aviv.project1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import dmax.dialog.SpotsDialog;

/**
 * Created by Administrator on 14/03/2018.
 */

public class DownloadImage extends AsyncTask<String,String,Bitmap[]>{


    private ImageView guest;
    private ImageView home;
    Context context;


    public DownloadImage(ImageView home, ImageView guest,Context context) {
        this.guest = guest;
        this.home = home;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();



    }

    private Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Bitmap[] doInBackground(final String... strings) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final Bitmap bitmaps[]=new Bitmap[2];
                bitmaps[1]=getBitmapFromURL(strings[1]);
                bitmaps[0]=getBitmapFromURL(strings[0]);




        return bitmaps;
    }
    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        super.onPostExecute(bitmaps);
        home.setImageBitmap(bitmaps[1]);
        guest.setImageBitmap(bitmaps[0]);

    }
}

