package com.fang.box;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.SearchView.*;

public class c extends Activity
{ 
    Button qq,chiji,zhuomian,meitu,bbzz,spjx;
    @Override 
    public void onCreate(Bundle savedInstanceState)
	{ 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.c); 
        qq = findViewById(R.id.qq); 
		bbzz=findViewById(R.id.bbzz);
		spjx=findViewById(R.id.spjx);
		chiji = findViewById(R.id.chiji);
		meitu = findViewById(R.id.meitu);
		zhuomian = findViewById(R.id.zhuomian);
        qq.setOnClickListener(new OnClickListener(){ 
				@Override 
				public void onClick(View v)
				{ 
					startActivity(new Intent(c.this, qq.class));
				}
			});
		bbzz.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					startActivity(new Intent(c.this, bbzz.class));
				}
			});
		chiji.setOnClickListener(new OnClickListener(){
				@Override 
				public void onClick(View v)
				{ 
					startActivity(new Intent(c.this, chiji.class));
				}
			});
		meitu.setOnClickListener(new OnClickListener(){ 
				@Override 
				public void onClick(View v)
				{ 
					startActivity(new Intent(c.this, meitu.class));
				}
			});
		spjx.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					startActivity(new Intent(c.this, spjx.class));
				}
			});
		zhuomian.setOnClickListener(new OnClickListener(){ 
				@Override 
				public void onClick(View v)
				{ 
					startActivity(new Intent(c.this, zhuomian.class));
				}
			});}
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
            new AlertDialog.Builder(c.this).setTitle("退出")
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
        return super.onKeyDown(keyCode, event);  
    }
} 

