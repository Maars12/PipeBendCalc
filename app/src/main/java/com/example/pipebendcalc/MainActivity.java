package com.example.pipebendcalc;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    WebView webHtmlCss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webHtmlCss = (WebView) findViewById(R.id.webView);

        WebSettings ws = webHtmlCss.getSettings();
        ws.setJavaScriptEnabled(true);

        webHtmlCss.loadUrl("file:///android_asset/index.html");
        webHtmlCss.getSettings().setJavaScriptEnabled(true);
        webHtmlCss.setWebChromeClient(new WebChromeClient());
    }
}