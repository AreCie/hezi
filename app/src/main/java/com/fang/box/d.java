package com.fang.box;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class d extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.d);
		LinearLayout sm=findViewById(R.id.sm);
		LinearLayout zzp=findViewById(R.id.zzp);
		LinearLayout llp=findViewById(R.id.llp);
		LinearLayout gxrz=findViewById(R.id.gxrz);
		sm.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					Toast.makeText(getApplication(), "暂无代码", Toast.LENGTH_LONG).show();
				}
			});
		zzp.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("alipays://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=HTTPS://QR.ALIPAY.COM/FKX03004O9CF804G78II41#Intent;scheme=alipays;package=com.eg.android.AlipayGphone;end")));
				}
			});
		llp.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=2042642971")));
					Toast.makeText(getApplication(), "咸鱼Fang为你服务", Toast.LENGTH_SHORT).show();
				}
			});
		gxrz.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					startActivity(new Intent(d.this, gxrz.class));
				}
			});
	}
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event)
	{  
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{  
			new AlertDialog.Builder(d.this).setTitle("退出")
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
		}return false;
	}}
