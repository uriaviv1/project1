package com.example.aviv.project1;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
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

import dmax.dialog.SpotsDialog;

import static com.example.aviv.project1.R.style.Custom;

/**
 * Created by Administrator on 07/03/2018.
 */

public class DownloadText extends AsyncTask<String,String,String> {

   TextView tv;
   ImageView home,guest;

   Context context;
    android.app.AlertDialog dialog;



    public DownloadText(TextView tv,Context context) {
        this.tv=tv;
        this.context=context;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new SpotsDialog(context,R.style.Custom);
        dialog.dismiss();
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document document= null;
        Elements score;
        try {
            document = Jsoup.connect(strings[1]).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
         score=document.select(strings[0]);

        dialog.dismiss();
        return score.text();


    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        dialog.dismiss();
        super.onCancelled();
    }


}
