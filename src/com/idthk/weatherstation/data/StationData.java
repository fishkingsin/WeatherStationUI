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

	public String name;
	public float degree;
	public int humiditiy;
	public int pressure;
	public Integer battery_level;
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
		this.name = name;
		degree = 0;
		humiditiy = 0;
		pressure = 0;
		battery_level = Battery_Level.MID.getValue();
	}
	private void readFromParcel(Parcel in ) {
		name = in.readString();
		degree = in.readFloat();
		humiditiy = in.readInt();
		pressure = in.readInt();
		battery_level = Battery_Level.MID.getValue();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
		dest.writeString(name);
		dest.writeFloat(degree);
		dest.writeInt(humiditiy);
		dest.writeInt(pressure);
		dest.writeInt(battery_level);

	}

}
