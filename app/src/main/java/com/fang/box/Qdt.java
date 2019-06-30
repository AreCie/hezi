package com.fang.box;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.webkit.*;

public class Qdt extends Activity 
{
	private static final String TAG = MainActivity.class.getSimpleName(); 
    private String errorHtml = ""; 
    WebView mWebView; 
	private final int SPLASH_DISPLAY_LENGHT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qdt);
		new Handler().postDelayed(new Runnable() 
			{  
				public void run() 
				{   
					Intent Pc = new Intent(Qdt.this, MainActivity.class);  
					Qdt.this.startActivity(Pc); 
					Qdt.this.finish();    
				}         
			}, SPLASH_DISPLAY_LENGHT);   
		errorHtml = "<html><body><a>?断网了？<br>检查下吧</a></body></html>"; 
        mWebView = findViewById(R.id.t); 
        mWebView.getSettings().setJavaScriptEnabled(true); 
        mWebView.loadUrl("http://api.douqq.com/?key=YUNNZD1rM1p2OVdYaz1yMHF3M3VqT1pjZUFRQUFBPT0&msg=%E4%B8%80%E8%A8%80"); 
        Log.i(TAG, "--onCreate--"); 
        mWebView.setWebViewClient(new MyWebViewClient()); 
    } 
    @Override 
    protected void onResume()
	{ 
        super.onResume(); 
		Log.i(TAG, "--onResume()--"); 
    } 
    public class MyWebViewClient extends WebViewClient
	{ 
        @Override 
        public boolean shouldOverrideUrlLoading(WebView view, String url)
		{ 
			Log.i(TAG, "-MyWebViewClient->shouldOverrideUrlLoading()--"); 
			view.loadUrl(url); 
            return true; 
        } 
        @Override 
        public void onPageStarted(WebView view, String url, Bitmap favicon)
		{ 
			Log.i(TAG, "-MyWebViewClient->onPageStarted()--"); 
            super.onPageStarted(view, url, favicon); 
        } 
        @Override 
        public void onPageFinished(WebView view, String url)
		{ 
			Log.i(TAG, "-MyWebViewClient->onPageFinished()--"); 
            super.onPageFinished(view, url); 
        } 
        @Override 
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
		{ 
            super.onReceivedError(view, errorCode, description, failingUrl);
			Log.i(TAG, "-MyWebViewClient->onReceivedError()--\n errorCode=" + errorCode + " \ndescription=" + description + " \nfailingUrl=" + failingUrl); 
			view.loadData(errorHtml, "text/html", "java");
		}
	}
}

