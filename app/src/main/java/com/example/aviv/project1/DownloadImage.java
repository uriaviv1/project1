package com.example.aviv.project1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by Administrator on 14/03/2018.
 */

public class DownloadImage extends AsyncTask<String[],String,Bitmap[]>{


    private ImageView guest;
    private ImageView home;
    public DownloadImage(ImageView home, ImageView guest) {
        this.guest = guest;
        this.home = home;
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
    protected Bitmap[] doInBackground(String[]... strings) {
        Bitmap[] bitmaps=new Bitmap[2];
        bitmaps[0]=getBitmapFromURL(String.valueOf(strings[0]));
        bitmaps[1]=getBitmapFromURL(String.valueOf(strings[1]));
        return bitmaps;
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        super.onPostExecute(bitmaps);
        home.setImageBitmap(bitmaps[0]);
        guest.setImageBitmap(bitmaps[1]);
    }
}

