package com.stickmanventures.android.example.immersive_videoplayer.ui.activities;

import java.util.ArrayList;

import com.stickmanventures.android.example.immersive_videoplayer.ImmersiveVideoplayer;
import com.stickmanventures.android.example.immersive_videoplayer.R;
import com.stickmanventures.android.example.immersive_videoplayer.adapters.HomeArrayAdapter;
import com.stickmanventures.android.example.immersive_videoplayer.entities.Video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeActivity extends BaseActivity {
	
	/** Reference to the instance for use with the onItemClick override method. */
	private Activity activity = this;
	
	private final String[] titles = new String[] { 
			"Video Player",
			"Video Player with Description" };
	private final String[] activites = new String[] {
			"com.stickmanventures.android.example.immersive_videoplayer.ui.activities.VideoPlayerActivity",
			"com.stickmanventures.android.example.immersive_videoplayer.ui.activities.VideoPlayerActivity" };
	private final String[] layouts = new String[] { "0", "1" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// Grab references of all required widgets
		final ListView homeListView = (ListView) findViewById(R.id.activityhome_listview);
		
		// Put all the titles in an arraylist for the adapter
		final ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < titles.length; ++i) {
			list.add(titles[i]);
		}
		
		// Inflate the listview with the example activities
		homeListView.setAdapter(new HomeArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list));
		homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = null;
				
				try {
					intent = new Intent(activity, Class.forName(activites[position]));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					// Create a video object to be passed to the activity
					Video video = new Video("http://clips.vorwaerts-gmbh.de/VfE_html5.mp4");
					video.setTitle("Big Buck Bunny");
					video.setAuthor("the Blender Institute");
					video.setDescription("A short computer animated film by the Blender Institute, part of the Blender Foundation. Like the foundation's previous film Elephants Dream, the film was made using Blender, a free software application for animation made by the same foundation. It was released as an Open Source film under Creative Commons License Attribution 3.0.");
					
					// Launch the activity with some extras
					intent.putExtra(ImmersiveVideoplayer.EXTRA_LAYOUT, layouts[position]);
					intent.putExtra(Video.class.getName(), video);
					startActivity(intent);
				}
			}
		});
	}

}
