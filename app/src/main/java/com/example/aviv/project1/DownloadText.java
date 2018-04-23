package com.example.aviv.project1;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
String s="http://basket.co.il/game-zone.asp?GameId=23312";
   TextView tv;
   ImageView home,guest;

    Context context;
    android.app.AlertDialog alertDialog;



    public DownloadText(TextView tv,Context context) {
        this.tv=tv;
        this.context=context;
         alertDialog=new SpotsDialog(context,R.style.Custom);
         alertDialog.setCancelable(false);
         alertDialog.show();


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {


        Document document= null;
        //if(!(strings[1].length()==s.length())) {
//        Log.e("Tag/Class",strings[0]);
        try {
                document = Jsoup.connect(strings[1]).get();
                Elements as=document.select("div."+strings[0]);
                if(as!=null){
                    Element firstDiv=as.first();
                    if(firstDiv!=null){
                       return firstDiv.html();
                    }
                }else{
                    Log.e("Error","Is Null1");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
           return "No Result";

       // }

       // else return strings[0];




    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
        alertDialog.dismiss();

    }

    @Override
    protected void onCancelled() {

        super.onCancelled();
        alertDialog.dismiss();
    }


}
