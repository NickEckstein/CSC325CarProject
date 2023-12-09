package bcs.csc.car.api.sql.model.drive;

import java.io.Serializable;

/**
 * 
 * @author Brian Niski
 */
public class DriveType implements Serializable {

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
