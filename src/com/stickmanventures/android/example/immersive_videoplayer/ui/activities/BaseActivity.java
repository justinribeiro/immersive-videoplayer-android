package com.stickmanventures.android.example.immersive_videoplayer.ui.activities;

import com.stickmanventures.android.example.immersive_videoplayer.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

public class BaseActivity extends Activity {
	
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = getBaseContext();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	protected Context getContext() {
		return context;
	}
}
