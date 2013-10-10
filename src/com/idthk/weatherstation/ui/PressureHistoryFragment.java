package com.idthk.weatherstation.ui;

import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PressureHistoryFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	public static final PressureHistoryFragment newInstance(StationData data) {
		PressureHistoryFragment f = new PressureHistoryFragment();
		Bundle bdl = new Bundle(1);
		bdl.putParcelable(EXTRA_MESSAGE, data);
		f.setArguments(bdl);
		return f;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_pressure, container, false);
    }
}
