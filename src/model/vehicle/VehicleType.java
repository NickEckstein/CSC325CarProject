package model.vehicle;

public class VehicleType {

	private long vehicleTypeID;
	private String vehicleTypeName;

	public VehicleType(long vehicleTypeID, String vehicleTypeName) {
		this.vehicleTypeID = vehicleTypeID;
		this.vehicleTypeName = vehicleTypeName;
	}

	public long getVehicleTypeID() {
		return vehicleTypeID;
	}

	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	@Override
	public String toString() {
		return "VehicleType [vehicleTypeID=" + vehicleTypeID + ", vehicleTypeName=" + vehicleTypeName + "]";
	}

}
