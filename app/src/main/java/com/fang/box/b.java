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
import java.io.*;

public class b extends Activity 
{
	private WebView webView;
	private ProgressBar progressBar;
	public WebViewClient WebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);


		webView = this.findViewById(R.id.webView);
		progressBar = this.findViewById(R.id.a);
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
		setAllowFileAccess(false);
		setAllowFileAccessFromFileURLs(false);
		setAllowUniversalAccessFromFileURLs(false);
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
						progressBar.setVisibility(View.GONE);//INVISIBLE 
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
		webView.loadUrl("http://m.panist.icoc.bz/");
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
				public void onReceivedError(WebView view, int errorCode,
											String description, String failingUrl)
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

	private void setAllowUniversalAccessFromFileURLs(boolean p0)
	{
	}

	private void setAllowFileAccessFromFileURLs(boolean p0)
	{
	}

	private void setAllowFileAccess(boolean p0)
	{
	}
	@Override 
	public boolean 
	onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) 
		{ if (webView.canGoBack()) 
			{ 
				webView.goBack();
				return true; 
			} 
			else 
			{ 
				new AlertDialog.Builder(b.this).setTitle("退出")
					.setMessage("确定要退出软件么？")
					.setPositiveButton("没错", new DialogInterface.OnClickListener()
					{
						@Override				
						public void onClick(DialogInterface dialog, int which)
						{
							System.exit(0);
						}			
					})
					.setNegativeButton("点错了", new DialogInterface.OnClickListener()
					{
						@Override			
						public void onClick(DialogInterface dialog, int which)
						{
						}			
					}).show();
				return false;
			}
		}return false;
	}}
