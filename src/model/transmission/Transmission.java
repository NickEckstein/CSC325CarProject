package model.transmission;

public class Transmission {

	private long transmissionID;
	private String transmissionName;

	public Transmission(long transmissionID, String transmissionName) {
		this.transmissionID = transmissionID;
		this.transmissionName = transmissionName;
	}

	public long getTransmissionID() {
		return transmissionID;
	}

	public String getTransmissionName() {
		return transmissionName;
	}

	@Override
	public String toString() {
		return "Transmission [transmissionID=" + transmissionID + ", transmissionName=" + transmissionName + "]";
	}

}
