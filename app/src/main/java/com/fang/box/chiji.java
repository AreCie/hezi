package com.fang.box;

import android.app.*;
import android.os.*;
import android.view.*;

public class chiji extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chiji);
	}
}
