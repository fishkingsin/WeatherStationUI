package com.idthk.weatherstation.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.idthk.weatherstation.ui.R;

public class StationData implements Parcelable {

	public enum Battery_Level {

		LOW(R.drawable.battery_low),

		MID(R.drawable.backup_battery),

		HI(R.drawable.battery);

		private final Integer id;

		Battery_Level(Integer id) {
			this.id = id;
		}

		public Integer getValue() {
			return id;
		}

	}

	private String name;
	private float degree;
	private float maxDegree;
	private float minDegree;
	private int humidity;
	private int pressure;
	private Integer battery_level;
	private String format = "%.2f";
	private int maxHumidity;
	private int minHumidity;
	private int maxPressure;
	private int minPressure;
	
	public static final Parcelable.Creator<StationData> CREATOR = new Parcelable.Creator<StationData>() {
		public StationData createFromParcel(Parcel in) {
			return new StationData(in);
		}

		public StationData[] newArray(int size) {
			return new StationData[size];
		}
	};
	
	public StationData(Parcel in) {
		readFromParcel( in );
	}
	public StationData(String name) {
		this.setName(name);
//		setDegree(0);
//		setHumiditiy(0);
//		setPressure(0);
		setBattery_level(Battery_Level.MID.getValue());
	}
	private void readFromParcel(Parcel in ) {
		setName(in.readString());
		setDegree(in.readFloat());
		setHumiditiy(in.readInt());
		setPressure(in.readInt());
		setBattery_level(Battery_Level.MID.getValue());
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
		dest.writeString(getName());
		dest.writeFloat(getDegree());
		dest.writeInt(getHumiditiy());
		dest.writeInt(getPressure());
		dest.writeInt(getBattery_level());

	}
	public CharSequence getDegreeAsString() {
		// TODO Auto-generated method stub
		return String.format(format ,getDegree());
	}
	public CharSequence getMaxDegreeAsString() {
		// TODO Auto-generated method stub
		return String.format(format ,maxDegree);
	}
	public CharSequence getMinDegreeAsString() {
		// TODO Auto-generated method stub
		return String.format(format ,minDegree);
	}
	public float getDegree() {
		return degree;
	}
	public void setDegree(float degree) {
		this.degree = degree;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumiditiy() {
		return humidity;
	}
	public void setHumiditiy(int humiditiy) {
		this.humidity = humiditiy;
	}
	public Integer getBattery_level() {
		return battery_level;
	}
	public void setBattery_level(Integer battery_level) {
		this.battery_level = battery_level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CharSequence getHumidityAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(humidity);
	}
	public CharSequence getMaxHumidityAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(maxHumidity);
	}
	public CharSequence getMinHumidityAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(minHumidity);
	}
	public CharSequence getPressureAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(pressure);
	}
	public CharSequence getMaxPressureAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(maxPressure);
	}
	public CharSequence getMinPressureAsString() {
		// TODO Auto-generated method stub
		return String.valueOf(minPressure);
	}

}
