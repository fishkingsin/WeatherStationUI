package com.idthk.weatherstation.ui;

import java.util.ArrayList;
import java.util.List;

import com.idthk.weatherstation.data.Category;
import com.idthk.weatherstation.data.HistoryData;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

public class MyFragmentFunction extends Fragment {
	public void createGraph(ViewGroup graph, Context context, ArrayList<HistoryData> list , Category cat) {
		graph.removeAllViews();

		GraphViewSeriesStyle style = new GraphViewSeriesStyle();
		style.thickness = 1;
		style.color = 0xFF73CBfD;
		
		GraphViewSeriesStyle style2 = new GraphViewSeriesStyle();
		style.thickness = 1;
		style.color = 0xFFFF0000;
//		LineGraphView mGraphView2 = new LineGraphView(context, "");
		LineGraphView mGraphView = new LineGraphView(context, "");
		List<GraphViewData> data = new ArrayList<GraphViewData>();
		List<GraphViewData> data2 = new ArrayList<GraphViewData>();
		List<String> hStr = new ArrayList<String>();
		int count = list.size();
		float max = 0;
		float min = 0;
		for (int i = 0; i < count; i++) {
			
			int value = 30;
			data2.add(new GraphViewData(i, value));
			
			float v = list.get(i).getChartDegree(cat);//(float) (Math.sin((i*(Math.PI/count)))*15+15	);
			data.add(new GraphViewData(i, v));
			max = Math.max(max, v);
			if (i == 0) {
				min = v;
			} else {
				min = Math.min(min, v);
			}
		}

		for (int i = 0; i < 7; i++) {
			hStr.add(String.valueOf(i+1));
		}
		GraphViewData[] a = data.toArray(new GraphViewData[data.size()]);
		GraphViewSeries series = new GraphViewSeries("Hour", style, a);
		GraphViewSeries series2 = new GraphViewSeries("Hour", style2, data2.toArray(new GraphViewData[data2.size()]));
		
		mGraphView.setHorizontalLabels(hStr.toArray(new String[hStr.size()]));
		// mGraphView.setVerticalLabels(new String[] { "-", "-", "-" });
		mGraphView.setManualYAxisBounds(max*1.1, min*0.9);
		mGraphView.addSeries(series);
		mGraphView.addSeries(series2);
		
		// stuff that updates ui
		graph.addView(mGraphView);
	}
}
