package com.example.aviv.project1;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import dmax.dialog.SpotsDialog;

/**
 * Created by Aviv on 03/04/2018.
 */

public class InstagramFragment extends Fragment
{
    View rootView;
    android.app.AlertDialog alertDialog;
    WebView webView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.instagram_page, container, false);

        alertDialog=new SpotsDialog(getContext(),R.style.Custom);
        alertDialog.setCancelable(false);

        alertDialog.show();
        webView=(WebView)rootView.findViewById(R.id.instagram);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.instagram.com/bnei_h/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                alertDialog.dismiss();
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    goBack();
                    return true;
                }

                return false;
            }
        });
        return rootView;
    }
    public void goBack() {

        webView.goBack();


    }
}
