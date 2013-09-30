package com.idthk.weatherstation.data;

import java.util.Calendar;

public class HistoryData {
	public Calendar date;
	int hiDegree;
	int lowDegree;
	public HistoryData()
	{
		date = Calendar.getInstance();
		hiDegree = 20;
		lowDegree = 10;
	}
}
