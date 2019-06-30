package com.fang.box;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;

public class bbzz extends Activity 
{
	private WebView webView;
	private ProgressBar progressBar;
	public WebViewClient WebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbzz);

		webView = this.findViewById(R.id.webView);
		progressBar = this.findViewById(R.id.bb);
		webView.setWebViewClient(new WebViewClient(){           
				@Override         
				public boolean shouldOverrideUrlLoading(WebView view, String url)
				{
					view.loadUrl(url);            
					return true;         
				}        
			});
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_NORMAL);
		//webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webView.setWebChromeClient(new WebChromeClient() {
				@Override
				public void onProgressChanged(WebView view, int newProgress)
				{
					Log.e("newProgress", "" + newProgress);
					if (newProgress == 100)
					{
						progressBar.setProgress(100);
						progressBar.setVisibility(View.GONE);
					}
					else
					{
						progressBar.setVisibility(View.VISIBLE);
						progressBar.setProgress(newProgress);
						if (progressBar.getProgress() == 100)
						{
							progressBar.setProgress(0);
						}
					}
					webView.setDownloadListener(new MyWebViewDownLoadListener());
				}

				private class MyWebViewDownLoadListener implements DownloadListener
				{  
					@Override  
					public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,long contentLength)
					{  
						Uri uri = Uri.parse(url);  
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);  
						startActivity(intent);  
					}  
				}  
			});
		webView.loadUrl("http://bbai520.com/");
		webView.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url)
				{
					view.loadUrl(url);
					return true;
				}
				@Override
				public void onPageStarted(WebView view, String url, Bitmap favicon)
				{
					super.onPageStarted(view, url, favicon);
				}
				@Override
				public void onPageFinished(WebView view, String url)
				{
					super.onPageFinished(view, url);
				}
				@Override
				public void onReceivedError(WebView view, int errorCode,String description, String failingUrl)
				{
					super.onReceivedError(view, errorCode, description, failingUrl);
					view.loadDataWithBaseURL(null, "没网了？检查下吧", "text/html", "utf-8", null);
					loadFailure();
				}
				private void loadFailure()
				{
					Toast.makeText(getApplication(), "当前无网络", Toast.LENGTH_LONG).show();
				}
			});
	}
	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{ 
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{ 
			if
			(webView.canGoBack()) 
			{ 
				webView.goBack();
				return true; 
			}
			}
		return super.onKeyDown(keyCode, event);
	}}
