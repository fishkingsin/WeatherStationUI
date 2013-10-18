package com.idthk.weatherstation.data;

import java.util.Calendar;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryData implements Parcelable {
	private Calendar date;
	private float degree;
	private float hiDegree;
	private float lowDegree;

	private int atmospheric;

	public int getAtmospheric() {
		return atmospheric;
	}

	public void setAtmospheric(int atmospheric) {
		this.atmospheric = atmospheric;
	}

	private int hiAtmospheric;

	public int getHiAtmospheric() {
		return hiAtmospheric;
	}

	public void setHiAtmospheric(int hiAtmospheric) {
		this.hiAtmospheric = hiAtmospheric;
	}

	private int lowAtmospheric;

	public int getLowAtmospheric() {
		return lowAtmospheric;
	}

	public void setLowAtmospheric(int lowAtmospheric) {
		this.lowAtmospheric = lowAtmospheric;
	}

	private int humidity;

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	private int hiHumidity;

	public int getHiHumidity() {
		return hiHumidity;
	}

	public void setHiHumidity(int hiHumidity) {
		this.hiHumidity = hiHumidity;
	}

	private int lowHumidity;

	public int getLowHumidity() {
		return lowHumidity;
	}

	public void setLowHumidity(int lowHumidity) {
		this.lowHumidity = lowHumidity;
	}

	public static final Parcelable.Creator<HistoryData> CREATOR = new Parcelable.Creator<HistoryData>() {
		public HistoryData createFromParcel(Parcel in) {
			return new HistoryData(in);
		}

		public HistoryData[] newArray(int size) {
			return new HistoryData[size];
		}
	};

	public HistoryData(Calendar _date, float _degree, float _hiDegree,
			float _lowDegree, int _humidity , int _lowhumidity , int _hihumidity 
			, int _pressure , int _lowpressure , int _hipressure ) {
		setDate(date);
		setDegree(_degree);
		setHiDegree(_hiDegree);
		setLowDegree(_lowDegree);
		this.setHumidity(_humidity);
		this.setLowHumidity(_lowhumidity);
		this.setHiHumidity(_hihumidity);
		this.setAtmospheric(_pressure);
		this.setLowAtmospheric(_lowpressure);
		this.setHiAtmospheric( _hipressure);
	}

	public HistoryData() {
		setDate(Calendar.getInstance());
		getDate().set(Calendar.DAY_OF_MONTH, (int) Math.random() * 30);
		setDegree((int) (Math.random() * 30));
		setHiDegree((int) (Math.random() * 30));
		setLowDegree((int) (Math.random() * 10));
		
		this.setHumidity((int) (Math.random() * 100));
		this.setLowHumidity((int) (Math.random() * 100));
		this.setHiHumidity((int) (Math.random() * 100));
		this.setAtmospheric((int) (Math.random() * 3000));
		this.setLowAtmospheric((int) (Math.random() * 3000));
		this.setHiAtmospheric( (int) (Math.random() * 3000));
	}

	public HistoryData(Parcel in) {
		readFromParcel(in);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeLong(date.getTimeInMillis());
		dest.writeFloat(this.getDegree());
		dest.writeFloat(this.getHiDegree());
		dest.writeFloat(this.getLowDegree());
		
		dest.writeInt(this.getHumidity());
		dest.writeInt(this.getLowHumidity());
		dest.writeInt(this.getHiHumidity());
		dest.writeInt(this.getAtmospheric());
		dest.writeInt(this.getLowAtmospheric());
		dest.writeInt(this.getHiAtmospheric());
		
	}

	private void readFromParcel(Parcel in) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(in.readLong());
		setDate(instance);
		setDegree(in.readFloat());
		setHiDegree(in.readFloat());
		setLowDegree(in.readFloat());
		
		this.setHumidity(in.readInt());
		this.setLowHumidity(in.readInt());
		this.setHiHumidity(in.readInt());
		this.setAtmospheric(in.readInt());
		this.setLowAtmospheric(in.readInt());
		this.setHiAtmospheric( in.readInt());
	}

	public float getHiDegree() {
		return hiDegree;
	}

	public void setHiDegree(float hiDegree) {
		this.hiDegree = hiDegree;
	}

	public float getLowDegree() {
		return lowDegree;
	}

	public void setLowDegree(float lowDegree) {
		this.lowDegree = lowDegree;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public float getChartDegree(Category cat) {
		return (cat.getValue() == Category.TEMPERATURE.getValue()) ? degree
				: (cat.getValue() == Category.PRESSURE.getValue()) ? atmospheric
						: humidity;
	}

}
