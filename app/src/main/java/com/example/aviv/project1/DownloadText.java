package com.example.aviv.project1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 07/03/2018.
 */

public class DownloadText extends AsyncTask<String,String,String> {

   TextView tv;

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
            document = Jsoup.connect("http://basket.co.il/game-zone.asp?GameId=23251").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements score=document.select("div.game_zone_result");
        return score.text();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
    }
}
