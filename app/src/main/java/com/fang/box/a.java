package com.fang.box;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class a extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a);
		setTitle("GridLayoutActivity");
		GridView gridview = findViewById(R.id.grid_view);
		 //启用后显示内容将设置为图片(需将设置为字符注释掉)
		// gridview.setAdapter(new ImageAdapter(this));
		//设置的字符
		String[] b=new String[]{"001","002","003","004","005","006"};
		//启用后显示内容将设置为字符(需将设置为图片注释掉)
		ListAdapter a=new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1,b);
		gridview.setAdapter(a);
		//Gird View 的点击事件
		gridview.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View view, int position, long id)
				{
					switch (position)
					{
							 case 0:
							 Toast.makeText(getApplication(), "第一个", Toast.LENGTH_SHORT).show();
							 break;
							 case 1:
							 Toast.makeText(getApplication(), "第二个", Toast.LENGTH_SHORT).show();
							 break;
							 case 2:
							 Toast.makeText(getApplication(), "第三个", Toast.LENGTH_SHORT).show();
							 break;
							 case 3:
							 Toast.makeText(getApplication(), "第四个", Toast.LENGTH_SHORT).show();
							 break;
							 case 4:
							 Toast.makeText(getApplication(), "第五个", Toast.LENGTH_SHORT).show();
							 break;
							 case 5:
							 break;
							 case 6:
							 break;
							 default:
							 break;
					}
				}
			});
	}
	public class ImageAdapter extends BaseAdapter
	{
		private Context mContext;
		public ImageAdapter(Context c)
		{
			mContext = c;
		}
		public int getCount()
		{
			return mThumbIds.length;
		}
		public Object getItem(int position)
		{
			return null;
		}
		public long getItemId(int position)
		{
			return 0;
		}
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ImageView imageView;
			if (convertView == null)
			{
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(250, 250));//图片的长宽
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);//依次是(TOP,Right,Bottom,Left)
			}
			else
			{
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(mThumbIds[position]);
			return imageView;
		}
		//设置的图片
		private Integer[] mThumbIds =
		{
			R.drawable.wyy,
			R.drawable.wyy, 
			R.drawable.wyy, 
			R.drawable.wyy, 
			R.drawable.wyy, 
			R.drawable.wyy, 
			R.drawable.wyy,
			R.drawable.wyy,
			R.drawable.wyy, 
		};
	}
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
            new AlertDialog.Builder(a.this).setTitle("退出")
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
