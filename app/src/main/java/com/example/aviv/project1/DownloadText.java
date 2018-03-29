package com.example.aviv.project1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 07/03/2018.
 */

public class DownloadText extends AsyncTask<String,String,String> {

   TextView tv;
   ImageView home,guest;

    public DownloadText(TextView tv) {
        this.tv=tv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        Document document= null;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Elements score;
        try {
            document = Jsoup.connect(strings[0]).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
         score=document.select(strings[1]);


        return score.text();

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
    }
}
