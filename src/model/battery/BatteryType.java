package model.battery;

public class BatteryType {

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
