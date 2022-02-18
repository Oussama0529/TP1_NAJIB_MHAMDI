package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Launch;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Launch launch = (Launch) getIntent().getSerializableExtra("myLaunch");
        String Url = launch.links.article_link;
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Url);
    }
}