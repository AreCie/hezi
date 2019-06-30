package com.fang.box;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.net.*;

public class MainActivity extends TabActivity {
	
	private Handler handler;
    private TabHost tabHost;

    protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
		new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						Message msg = new Message();
						msg.what = 0;
						URL u = new URL("https://share.weiyun.com/5b8aa1f2d1c96641e5cba3a3bda8ebf8");
						HttpURLConnection conn = (HttpURLConnection) u.openConnection();
						conn.connect();
						InputStream is = conn.getInputStream();
						BufferedReader reader = new BufferedReader(new InputStreamReader(is));
						String temp;
						StringBuffer buf = new StringBuffer();
						while ((temp = reader.readLine()) != null)
						{
							buf.append(temp);
						}
						is.close();

						String abt=buf.toString().substring(buf.toString().indexOf("【"), buf.toString().indexOf("】"));
						String dfs=buf.toString().substring(buf.toString().indexOf("（"), buf.toString().indexOf("）"));
						String bbt=abt.toString().substring(1);
						String nr=dfs.toString().substring(1);
						
						Double bt= Double.parseDouble(bbt);
						if (bt > 1.0)
						{
							msg.obj = nr;
							handler.sendMessage(msg);
						}
						else
						{
						}
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
				}
			}).start();

		handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				super.handleMessage(msg);
				final String nr= (String)msg.obj;
				AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
				a.setTitle("提示");
				a.setMessage("检测到有新版本可更新\n是否进行更新？");
				a.setPositiveButton("取消", new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
						}
					});
				a.setNegativeButton("确定", new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Uri uri = Uri.parse(nr);
							Intent intent = new Intent(Intent.ACTION_VIEW, uri);
							startActivity(intent);
						}
					});
				a.show();
			}
		};
        tabHost = getTabHost();
        addTab("act1", "首页", a.class);
        addTab("act2", "网页", b.class);
        addTab("act3", "工具", c.class);
		addTab("act4", "关于", d.class);

        setContentView(tabHost);

    }
    /**
     * 添加Activity标签
     * @param tag   标识
     * @param title 标签标题
     * @param clazz 激活的界面
     */
	 
    private void addTab(String tag, String title, Class clazz) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title);

        Intent intent = new Intent(getApplicationContext(),clazz);
        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);
    }

    @Override
    protected void onStop() {
        super.onStop();
    
	
}}
