package com.mobiverse.MobiVerse;

import android.webkit.WebView;

public class MobiverseBrowser {

    private WebView webView;

    public MobiverseBrowser(WebView webView) {
        this.webView = webView;
        this.webView.getSettings().setJavaScriptEnabled(true);
    }

    public void loadUrl(String url) {
        this.webView.loadUrl(url);
    }
}
