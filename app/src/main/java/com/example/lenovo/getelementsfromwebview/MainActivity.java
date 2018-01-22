package com.example.lenovo.getelementsfromwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    /**
     * Called when the activity is first created.
     */
    String TAG = this.getClass().getSimpleName();
    WebView wv;
    String useragent = "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)";
    String url = "http://www.thehindu.com/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.MyWebView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new VideoWebViewClient());
        wv.getSettings().setUserAgentString(useragent);
        wv.loadUrl(url);
        wv.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                WebView.HitTestResult hr = ((WebView) v).getHitTestResult();

                Log.i(TAG, "get extra " + hr.getExtra()+ " lll: "+ hr.getType());
                return false;
            }
        });
    }

    private class VideoWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return false;
        }


    }


}
