package com.stickmanventures.android.example.immersive_videoplayer.ui.fragments;

import com.stickmanventures.android.example.immersive_videoplayer.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideoPlayerFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_videoplayer, null);
		return view;
	}

}
