package com.idthk.weatherstation.data;

import java.util.Calendar;

public class HistoryData {
	public Calendar date;
	int hiDegree;
	int lowDegree;
	public HistoryData()
	{
		date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, (int)Math.random()*30);
		hiDegree = (int) (Math.random()*30);
		lowDegree = (int) (Math.random()*10);
	}
}
