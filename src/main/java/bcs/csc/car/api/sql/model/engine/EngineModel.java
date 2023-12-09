package bcs.csc.car.api.sql.model.engine;

import java.io.Serializable;

/**
 * 
 * @author Brian Niski
 */
public class EngineModel implements Serializable {

	private long engineModelID;
	private String engineModelName;
	private String engineModelDescription;

	public EngineModel(long engineModelID, String engineModelName, String engineModelDescription) {
		this.engineModelID = engineModelID;
		this.engineModelName = engineModelName;
		this.engineModelDescription = engineModelDescription;
	}

	public long getEngineModelID() {
		return engineModelID;
	}

	public String getEngineModelName() {
		return engineModelName;
	}

	public String getEngineModelDescription() {
		return engineModelDescription;
	}

	@Override
	public String toString() {
		return "EngineModel [engineModelID=" + engineModelID + ", engineModelName=" + engineModelName
				+ ", engineModelDescription=" + engineModelDescription + "]";
	}

}
