package ae.ac.hct.tkamal.itemswebviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ItemWebViewActivity extends Activity {

    //declare the webview object reference
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_web_view);

        //get the instance of webview from the layout's compiled R class
        webView = findViewById(R.id.webView);

        //get the settings for the webview
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //enable JavaScript
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(true);

        webView.setInitialScale(0);

        //set the web view client to our web view client
        //this is done to load the hyperlinked pages in the webview itself
        webView.setWebViewClient(new ItemsWebViewClient());

        //point the URL to static index page of your Evennode URL
        String url = "http://items-webapi2.eu-4.evennode.com/static/index.html";
        webView.loadUrl(url);
    }

    private class ItemsWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }
    }
}
