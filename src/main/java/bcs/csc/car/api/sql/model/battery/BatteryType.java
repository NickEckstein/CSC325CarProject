package bcs.csc.car.api.sql.model.battery;

import java.io.Serializable;

public class BatteryType implements Serializable {

	private long batteryID;
	private String batteryName;

	public BatteryType(long batteryID, String batteryName) {
		this.batteryID = batteryID;
		this.batteryName = batteryName;
	}

	public long getBatteryID() {
		return batteryID;
	}

	public String getBatteryName() {
		return batteryName;
	}
	
	@Override
	public String toString() {
		return "BatteryType [batteryID=" + batteryID + ", batteryName=" + batteryName + "]";
	}

}
