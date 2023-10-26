package bcs.csc.car.api.sql.sql.model.drive;

public class DriveType {

	private long driveTypeID;
	private String driveTypeName;

	public DriveType(long driveTypeID, String driveTypeName) {
		this.driveTypeID = driveTypeID;
		this.driveTypeName = driveTypeName;
	}

	public long getDriveTypeID() {
		return driveTypeID;
	}

	public String getDriveTypeName() {
		return driveTypeName;
	}

	@Override
	public String toString() {
		return "DriveType [driveTypeID=" + driveTypeID + ", driveTypeName=" + driveTypeName + "]";
	}
	
}
