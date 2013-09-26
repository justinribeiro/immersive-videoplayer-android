package com.stickmanventures.android.example.immersive_videoplayer.adapters;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class HomeArrayAdapter extends ArrayAdapter<String> {

	private HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	public HomeArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
		
		for(int i = 0; i < objects.size(); ++i) {
			mIdMap.put(objects.get(i), i);
		}
	}

	@Override
	public long getItemId(int position) {
		String item = getItem(position);
		return mIdMap.get(item);
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

}