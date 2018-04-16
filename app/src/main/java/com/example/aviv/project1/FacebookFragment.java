package com.example.aviv.project1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
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

public class FacebookFragment extends Fragment {
    View rootView;
    WebView webView;
    android.app.AlertDialog alertDialog;

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.facebook_page, container, false);
        webView = rootView.findViewById(R.id.facebookFragment);

        alertDialog=new SpotsDialog(getContext(),R.style.Custom);
        alertDialog.setCancelable(false);
        alertDialog.setMessage("Downloading");
        alertDialog.show();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

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

        webView.loadUrl("https://www.facebook.com/bhbasket/");
        return rootView;
    }

    public void goBack() {

        webView.goBack();


    }
}
