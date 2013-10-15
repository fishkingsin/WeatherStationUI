package com.idthk.weatherstation.ui;

import java.util.ArrayList;
import java.util.List;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

public class MyFragmentFunction extends Fragment {
	public void createGraph(ViewGroup graph, Context context) {
		graph.removeAllViews();

		GraphViewSeriesStyle style = new GraphViewSeriesStyle();
		style.thickness = 5;
		style.color = 0xFF73CBfD;
		
		GraphViewSeriesStyle style2 = new GraphViewSeriesStyle();
		style.thickness = 5;
		style.color = 0xFFFF0000;
//		LineGraphView mGraphView2 = new LineGraphView(context, "");
		LineGraphView mGraphView = new LineGraphView(context, "");
		List<GraphViewData> data = new ArrayList<GraphViewData>();
		List<GraphViewData> data2 = new ArrayList<GraphViewData>();
		List<String> hStr = new ArrayList<String>();
		int count = 7 * 24;
		int max = 0;
		int min = 0;
		for (int i = 0; i < count; i++) {
			
			int value = 10;
			data.add(new GraphViewData(i, value));
			data2.add(new GraphViewData(i, 30));
			max = Math.max(max, value);
			if (i == 0) {
				min = value;
			} else {
				min = Math.min(min, value);
			}
		}

		for (int i = 0; i < 7; i++) {
			hStr.add("|");
		}
		GraphViewData[] a = data.toArray(new GraphViewData[data.size()]);
		GraphViewSeries series = new GraphViewSeries("Hour", style, a);
		GraphViewSeries series2 = new GraphViewSeries("Hour", style2, data2.toArray(new GraphViewData[data2.size()]));
		
		mGraphView.setHorizontalLabels(hStr.toArray(new String[hStr.size()]));
		// mGraphView.setVerticalLabels(new String[] { "-", "-", "-" });
//		mGraphView.setManualYAxisBounds(max, min);
		mGraphView.addSeries(series);
		mGraphView.addSeries(series2);
		
		// stuff that updates ui
		graph.addView(mGraphView);
	}
}
