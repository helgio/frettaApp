package com.trainstation.frettirtest2.service;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.trainstation.frettirtest2.R;

/**
 * Created by Helgi on 24/01/16.
 */
public class WebViewActivity extends Activity {

    private WebView webView;
    public String url = "http://google.com";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }
}
